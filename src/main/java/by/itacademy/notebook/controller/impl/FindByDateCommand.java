package by.itacademy.notebook.controller.impl;

import by.itacademy.notebook.controller.Command;
import by.itacademy.notebook.dao.DaoException;
import by.itacademy.notebook.entity.Note;
import by.itacademy.notebook.logic.LogicException;
import by.itacademy.notebook.logic.LogicProvider;
import by.itacademy.notebook.logic.NotebookLogic;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FindByDateCommand implements Command {
    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();

    @Override
    public String execute(String request) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String response = "";
        String[] params;

        params = request.split("\n");

        try {
            for (Note n : logic.find(formatter.parse(params[1]))) {
                response = response + n.toString();
            }
        } catch (ParseException e) {
            e.printStackTrace();
            response = "Запись не обновлена.";
        } catch (LogicException | DaoException e) {//? можно ли тут такое
            e.printStackTrace();
            response = "Что-то случилось. Пробуйте еще раз";
        }
        return response;
    }
}

