package by.itacademy.notebook.controller.impl;

import by.itacademy.notebook.controller.Command;
import by.itacademy.notebook.dao.DaoException;
import by.itacademy.notebook.entity.Note;
import by.itacademy.notebook.logic.LogicException;
import by.itacademy.notebook.logic.LogicProvider;
import by.itacademy.notebook.logic.NotebookLogic;

import java.util.ArrayList;
import java.util.List;

public class DisplayNotesCommand implements Command {
    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();

    @Override
    public String execute(String request) {
        List<Note> notes = new ArrayList<>();
        StringBuilder response = new StringBuilder();
        try {
            List<Note> n = logic.allNotes();
            for (Note note : n) {
                response.append(note.toString()).append("\n");
            }
        } catch (LogicException e) {
            response.append("Возникла ошибка при получении записей: ").append(e);
            return response.toString();
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
        return response.toString();
    }
}
