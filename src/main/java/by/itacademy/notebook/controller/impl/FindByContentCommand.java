package by.itacademy.notebook.controller.impl;

import by.itacademy.notebook.controller.Command;
import by.itacademy.notebook.entity.Note;
import by.itacademy.notebook.logic.LogicException;
import by.itacademy.notebook.logic.LogicProvider;
import by.itacademy.notebook.logic.NotebookLogic;
import by.itacademy.notebook.validation.ValidatorUtils;

import java.util.List;

public class FindByContentCommand implements Command {
    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();

    @Override
    public String execute(String request) {
        String response = "";
        String[] requestParts;
        List<Note> notesByContent = null;

        requestParts = request.split("\n");

        if (requestParts.length < 2 || !ValidatorUtils.hasValidateContent(requestParts[1])) {
            return "Неправильный формат содержимого записи.";
        }

        try {
            notesByContent = logic.find(requestParts[1]);
        } catch (LogicException e) {
            return "Что-то пошло не так. Пробуйте еще раз.";
        }

        if (notesByContent == null || notesByContent.isEmpty()) {
            response = "Записи не найдены.";
        } else {
            for (Note n : notesByContent) {
                response = response + n.toString() + "\n";
            }
        }
        return response;
    }
}
