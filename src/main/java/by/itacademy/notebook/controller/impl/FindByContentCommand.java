package by.itacademy.notebook.controller.impl;

import by.itacademy.notebook.controller.Command;
import by.itacademy.notebook.entity.Note;
import by.itacademy.notebook.logic.LogicException;
import by.itacademy.notebook.logic.LogicProvider;
import by.itacademy.notebook.logic.NotebookLogic;
import by.itacademy.notebook.validation.Validation;

import java.util.List;

public class FindByContentCommand implements Command {
    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();


    @Override
    public String execute(String request) {
        String response = "";
        String[] params;
        List<Note> notesByContent = null;

        params = request.split("\n");

        if (params.length < 2 || !Validation.isValidContent(params[1])) {
            return "Неправильный формат содержимого записи.";
        }

        try {
            notesByContent = logic.find(params[1]);
        } catch (LogicException e) {
            e.printStackTrace();
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
