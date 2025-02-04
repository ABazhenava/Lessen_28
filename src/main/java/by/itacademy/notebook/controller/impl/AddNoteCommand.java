package by.itacademy.notebook.controller.impl;

import by.itacademy.notebook.controller.Command;
import by.itacademy.notebook.entity.Note;
import by.itacademy.notebook.logic.LogicException;
import by.itacademy.notebook.logic.LogicProvider;
import by.itacademy.notebook.logic.NotebookLogic;
import by.itacademy.notebook.validation.ValidationMethods;

public class AddNoteCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();

    @Override
    public String execute(String request) {
        String response = null;
        String[] params;
        Note newNote;

        params = request.split("\n");

        if (params.length < 3 || !params[1].startsWith("title=") || !params[2].startsWith("content=")) {
            return "Неверный формат запроса. Пожалуйста, используйте title= и content= в правильном порядке.";
        }
        String title = params[1].split("=")[1];
        String content = params[2].split("=")[1];

        if (!ValidationMethods.isValidTitle(title) || !ValidationMethods.isValidContent(content)) {
            return "Неправильный формат заголовка или содержимого записи";
        }

        newNote = new Note();
        newNote.setTitle(title);
        newNote.setContent(content);

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
