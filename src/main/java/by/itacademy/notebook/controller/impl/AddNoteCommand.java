package by.itacademy.notebook.controller.impl;

import by.itacademy.notebook.controller.Command;
import by.itacademy.notebook.entity.Note;
import by.itacademy.notebook.logic.LogicException;
import by.itacademy.notebook.logic.LogicProvider;
import by.itacademy.notebook.logic.NotebookLogic;
import by.itacademy.notebook.validation.ValidatorUtils;

public class AddNoteCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();

    @Override
    public String execute(String request) {
        String response = null;
        String[] requestParts;
        Note newNote;

        requestParts = request.split("\n");

        if (requestParts.length < 3 || !requestParts[1].startsWith("title=") || !requestParts[2].startsWith("content=")) {
            return "Неверный формат запроса. Пожалуйста, используйте title= и content= в правильном порядке.";
        }
        String title = requestParts[1].split("=")[1];
        String content = requestParts[2].split("=")[1];

        if (!ValidatorUtils.hasValidateTitle(title) || !ValidatorUtils.hasValidateContent(content)) {
            return "Неправильный формат заголовка или содержимого записи";
        }

        newNote = new Note();
        newNote.setTitle(title);
        newNote.setContent(content);

        try {
            logic.add(newNote);
            response = "Запись сохранена успешно.";
        } catch (LogicException e) {
            response = "Попробуйте еще раз.";
        }
        return response;
    }
}
