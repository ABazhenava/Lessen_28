package by.itacademy.notebook.dao.impl;

import by.itacademy.notebook.dao.DaoException;
import by.itacademy.notebook.dao.NoteBookDao;
import by.itacademy.notebook.entity.Note;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FileNoteBookDao implements NoteBookDao {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public List<Note> save(Note n) throws DaoException {
        FileWriter writer = null;
        try {
            writer = new FileWriter("notes.txt", true);

            writer.write("Title: " + n.getTitle() + "\n");
            writer.write("Content: " + n.getContent() + "\n");
            writer.write("Date: " + n.getD() + "\n");
            writer.write("-----\n");
            System.out.println("Запись сохранена.");
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка при сохранении записи: " + e.getMessage());
            throw new DaoException(e);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении записи: " + e.getMessage());
            throw new DaoException(e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e1) {
                    System.err.println("Ошибка при закрытии файла: " + e1.getMessage());
                    throw new DaoException(e1);
                }
            }
        }
        return null;
    }


    //    public List<Note> allNotes() throws DaoException {
//        List<Note> notes = new ArrayList<>();
//        BufferedReader reader = null;
//        try {
//            reader = new BufferedReader(new FileReader("notes.txt"));
//            String line;
//            Note note = null;
//            while ((line = reader.readLine()) != null) {
//                note = processLine(line, note, notes);
//            }
//        } catch (ParseException e) {
//            throw new DaoException("Ошибка при чтении даты: ", e);
//        } catch (IOException e) {
//            throw new DaoException("Ошибка при чтении записей: ", e);
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e1) {
//                    throw new DaoException("Ошибка при закрытии файла: ", e1);
//                }
//            }
//        }
//        return notes;
//    }
//
//    private Note processLine(String line, Note note, List<Note> notes) throws ParseException {
//        if (line.startsWith("Title: ")) {
//            note = new Note();
//            note.setTitle(line.substring(7));
//        } else if (line.startsWith("Content: ")) {
//            note.setContent(line.substring(9));
//        } else if (line.startsWith("Date: ")) {
//            note.setD(DATE_FORMAT.parse(line.substring(6)));
//        } else if (line.equals("----------")) {
//            notes.add(note);
//        }
//        return note;
//    }
    @Override
    public List<Note> allNotes() throws DaoException {
        List<Note> notes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("notes.txt"))) {
            String line;
            Note note = null;
            while ((line = reader.readLine()) != null) {
                note = processLine(line, note, notes);
            }
        } catch (ParseException e) {
            throw new DaoException("Ошибка при чтении даты: ", e);
        } catch (IOException e) {
            throw new DaoException("Ошибка при чтении записей: ", e);
        }
        return notes;
    }

    private Note processLine(String line, Note note, List<Note> notes) throws ParseException {
        if (line.startsWith("Title: ")) {
            note = new Note();
            note.setTitle(line.substring(7));
        } else if (line.startsWith("Content: ")) {
            note.setContent(line.substring(9));
        } else if (line.startsWith("Date: ")) {
            note.setD(DATE_FORMAT.parse(line.substring(6)));
        } else if (line.equals("----------")) {
            notes.add(note);
        }
        return note;
    }
}
