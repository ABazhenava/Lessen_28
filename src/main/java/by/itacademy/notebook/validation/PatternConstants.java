package by.itacademy.notebook.validation;

import java.util.regex.Pattern;

public final class PatternConstants {
    public static final Pattern COMMAND_PATTERN = Pattern.compile("^[А-Я] + $");
    public static final Pattern TITLE_PATTERN = Pattern.compile("^[А-Яа-я0-9_ ]+$");
    public static final Pattern CONTENT_PATTERN = Pattern.compile("^[А-Яа-я0-9_ .,!?;]+$");
    public static final Pattern DATE_PATTERN = Pattern.compile("^\\d{2}\\.\\d{2}\\.\\d{4}$");
    public static final Pattern ID_PATTERN = Pattern.compile("^\\d+$");

}
