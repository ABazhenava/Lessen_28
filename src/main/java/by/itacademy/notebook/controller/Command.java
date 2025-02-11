package by.itacademy.notebook.controller;

import by.itacademy.notebook.dao.DaoException;
import by.itacademy.notebook.logic.LogicException;

public interface Command {
	String execute(String request) throws LogicException, DaoException;
}
