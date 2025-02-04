package by.itacademy.notebook.logic.impl;

import by.itacademy.notebook.dao.DaoException;
import by.itacademy.notebook.dao.DaoProvider;
import by.itacademy.notebook.dao.NoteBookDao;
import by.itacademy.notebook.entity.Note;
import by.itacademy.notebook.logic.LogicException;
import by.itacademy.notebook.logic.NotebookLogic;
import by.itacademy.notebook.validation.ValidationMethods;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotebookLogicImpl implements NotebookLogic {
    private final DaoProvider provider = DaoProvider.getInstance();
    private final NoteBookDao dao = provider.getNoteBookDao();

    public void add(Note n) throws LogicException {
        try {
            dao.save(n);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    public void add(String title, String content) throws LogicException {
        if (!ValidationMethods.isValidTitle(title)) {
            throw new LogicException("Неправильный формат заголовка записи.");
        }
        if (title.length() >= 200) {
            throw new LogicException("Заголовок должен содержать не более 200 символов.");
        }
        if (ValidationMethods.containsForbiddenWords(title)) {
            throw new LogicException("Загловок содержит нецензурные слова. Пожалуйста, исправьте.");
        }
        if (!ValidationMethods.isValidContent(content)) {
            throw new LogicException("Неправильный формат содержания.");
        }
        if (content.length() >= 1000) {
            throw new LogicException("Содержание может включать не более 1000 символов.");
        }
        if (ValidationMethods.containsForbiddenWords(content)) {
            throw new LogicException("В содержании найдены нецензурные слова. Пожалуйста, исправьте.");
        }

        Note n = new Note(title, content);
        try {
            dao.save(n);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    public List<Note> find(String text) throws LogicException {
        List<Note> result = new ArrayList<Note>();
        List<Note> myNotes = null;
        try {
            myNotes = dao.allNotes();
        } catch (DaoException e) {
            throw new LogicException(e);
        }

        for (Note n : myNotes) {
            if (isTextInNote(n, text)) {
                result.add(n);
            }
        }
        return result;
    }

    private boolean isTextInNote(Note n, String text) {
        return n.getTitle().contains(text) || n.getContent().contains(text);
    }

    public List<Note> find(Date date) throws LogicException {
        List<Note> result = new ArrayList<Note>();
        List<Note> myNotes = null;

        try {
            myNotes = dao.allNotes();
        } catch (DaoException e) {
            throw new LogicException(e);
        }
        for (Note n : myNotes) {
            if (n.getD().equals(date)) {
                result.add(n);
            }
            return result;
        }
        return result;
    }

    public List<Note> allNotes() throws LogicException {
        try {
            return dao.allNotes();
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }
}
