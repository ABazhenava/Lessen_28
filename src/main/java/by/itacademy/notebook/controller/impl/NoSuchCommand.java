package by.itacademy.notebook.controller.impl;

import by.itacademy.notebook.controller.Command;

public class NoSuchCommand implements Command {

	@Override
	public String execute(String request) {
		return "Ошибка запроса";
	}

}
