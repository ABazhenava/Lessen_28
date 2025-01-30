package by.itacademy.notebook.logic;

import by.itacademy.notebook.dao.DaoException;
import by.itacademy.notebook.entity.Note;

import java.util.Date;
import java.util.List;

public interface NotebookLogic {

	public void add(Note n) throws LogicException;

	public void add(String title, String content) throws LogicException;

	public List<Note> find(String text) throws LogicException;

	public List<Note> find(Date date) throws LogicException, DaoException;

	public List<Note> allNotes() throws LogicException, DaoException;
}
