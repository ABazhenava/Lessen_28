package by.itacademy.notebook.controller.impl;

import by.itacademy.notebook.controller.Command;
import by.itacademy.notebook.entity.Note;
import by.itacademy.notebook.logic.LogicException;
import by.itacademy.notebook.logic.LogicProvider;
import by.itacademy.notebook.logic.NotebookLogic;
import by.itacademy.notebook.validation.ValidatorUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateNoteCommand implements Command {
    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();

    @Override
    public String execute(String request) throws LogicException {
        String response = null;
        String[] requestParts;
        Note newNote;

        requestParts = request.split("\n");
        newNote = new Note();
        if (requestParts.length < 5 || !ValidatorUtils.hasValidateId(requestParts[1].split("=")[1])) {
            return "Неправильный формат ID.";
        }
        newNote.setId(Integer.parseInt(requestParts[1].split("=")[1]));

        if (!ValidatorUtils.hasValidateTitle(requestParts[2].split("=")[1])) {
            return "Неправильный формат заголовка записи.";
        }
        newNote.setTitle(requestParts[2].split("=")[1]);

        if (!ValidatorUtils.hasValidateContent(requestParts[3].split("=")[1])) {
            return "Неправильный формат содержания записи.";
        }
        newNote.setContent(requestParts[3].split("=")[1]);

        if (!ValidatorUtils.hasValidateDate(requestParts[4].split("=")[1])) {
            return "Неправильный формат даты, используйте. пожалуйста --> dd.MM.yyyy.";
        }

        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        Date date;
        try {
            date = format.parse(requestParts[4].split("=")[1]);
            newNote.setD(date);
            logic.add(newNote);
            response = "Запись была обновлена успешно.";
        } catch (ParseException e) {
            response = "Запись не обновлена.";
        } catch (LogicException e) {
            response = "Что-то случилось. Пробуйте еще раз";
        }
        return response;
    }
}
