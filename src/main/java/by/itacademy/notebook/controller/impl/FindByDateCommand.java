package by.itacademy.notebook.controller.impl;

import by.itacademy.notebook.controller.Command;
import by.itacademy.notebook.dao.DaoException;
import by.itacademy.notebook.entity.Note;
import by.itacademy.notebook.logic.LogicException;
import by.itacademy.notebook.logic.LogicProvider;
import by.itacademy.notebook.logic.NotebookLogic;
import by.itacademy.notebook.validation.ValidatorUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FindByDateCommand implements Command {
    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();

    @Override
    public String execute(String request) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String response = "";
        String[] requestParts;

        requestParts = request.split("\n");

        if (requestParts.length < 2 || !ValidatorUtils.hasValidateDate(requestParts[1])) {
            return "Неправильный формат даты. Используйте, пожалуйста, dd.MM.yyyy.";
        }

        try {
            for (Note n : logic.find(formatter.parse(requestParts[1]))) {
                response = response + n.toString() + "\n";
            }
        } catch (ParseException e) {
            response = "Запись не обновлена.";
        } catch (LogicException | DaoException e) {
            response = "Что-то случилось. Пробуйте еще раз.";
        }
        return response;
    }
}
