package by.itacademy.notebook.controller.impl;

import by.itacademy.notebook.controller.Command;
import by.itacademy.notebook.entity.Note;
import by.itacademy.notebook.logic.LogicException;
import by.itacademy.notebook.logic.LogicProvider;
import by.itacademy.notebook.logic.NotebookLogic;

public class AddNoteCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();

    @Override
    public String execute(String request) {
        String response = null;
        String[] params;
        Note newNote;

        params = request.split("\n");
        newNote = new Note();
        newNote.setTitle(params[1].split("=")[1]);
        newNote.setContent(params[2].split("=")[1]);

        try {
            logic.add(newNote);
            response = "Запись сохранена успешно.";

        } catch (LogicException e) {
            e.printStackTrace();
            response = "Попробуйте еще раз.";
        }
        return response;
    }
}
