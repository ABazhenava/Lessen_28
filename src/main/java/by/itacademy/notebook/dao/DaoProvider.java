package by.itacademy.notebook.dao;

import by.itacademy.notebook.dao.impl.FileNoteBookDao;

public final class DaoProvider {
    private static final DaoProvider INSTANCE = new DaoProvider();

    private DaoProvider() {
    }

    private NoteBookDao noteBookDao = (NoteBookDao) new FileNoteBookDao();

    public NoteBookDao getNoteBookDao() {
        return noteBookDao;
    }

    public static DaoProvider getInstance() {
        return INSTANCE;
    }
}
