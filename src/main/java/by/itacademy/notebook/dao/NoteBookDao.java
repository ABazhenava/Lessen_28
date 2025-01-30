package by.itacademy.notebook.dao;

import by.itacademy.notebook.entity.Note;

import java.util.List;

public interface NoteBookDao {

    List<Note> save(Note n) throws DaoException;

    List<Note> allNotes() throws DaoException;
}
