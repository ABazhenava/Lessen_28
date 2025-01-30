package by.itacademy.notebook.controller.impl;

import by.itacademy.notebook.controller.Command;
import by.itacademy.notebook.entity.Note;
import by.itacademy.notebook.logic.LogicException;
import by.itacademy.notebook.logic.LogicProvider;
import by.itacademy.notebook.logic.NotebookLogic;

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
        try {
            notesByContent = logic.find(params[1]);
        } catch (LogicException e) {
            e.printStackTrace();
            response = "Что-то пошло не так. Пробуйте еще раз";
        }

        for (Note n : notesByContent) {
            response = response + n.toString();
        }
        return response;
    }
}

