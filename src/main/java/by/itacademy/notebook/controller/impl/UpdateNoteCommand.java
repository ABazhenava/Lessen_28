package by.itacademy.notebook.controller.impl;

import by.itacademy.notebook.controller.Command;
import by.itacademy.notebook.entity.Note;
import by.itacademy.notebook.logic.LogicException;
import by.itacademy.notebook.logic.LogicProvider;
import by.itacademy.notebook.logic.NotebookLogic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateNoteCommand implements Command {
    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();

    @Override
    public String execute(String request) throws LogicException {
        String response = null;
        String[] params;
        Note newNote;

        params = request.split("\n");
        newNote = new Note();

        newNote.setId(Integer.parseInt(params[1].split("=")[1]));
        newNote.setTitle(params[2].split("=")[1]);
        newNote.setContent(params[3].split("=")[1]);

        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd");
        Date date;
        try {
            date = format.parse(params[4].split("=")[1]);
            newNote.setD(date);

            logic.add(newNote);
            response = "Запись была обновлена успешно.";
        } catch (ParseException e) {
            e.printStackTrace();
           response = "Запись не обновлена.";
		} catch(LogicException e) {
            e.printStackTrace();
            response = "Что-то случилось. Пробуйте еще раз";
        }
        return response;
    }
}
