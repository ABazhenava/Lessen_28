package by.itacademy.notebook.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public final class PatternConstants {

    public static final Pattern COMMAND_PATTERN = Pattern.compile("^[А-Я] + $");
    public static final Pattern TITLE_PATTERN = Pattern.compile("^[А-Яа-я0-9_ ]+$");
    public static final Pattern CONTENT_PATTERN = Pattern.compile("^[А-Яа-я0-9_ .,!?;]+$");
    public static final Pattern DATE_PATTERN = Pattern.compile("^\\d{2}\\.\\d{2}\\.\\d{4}$");
    public static final Pattern ID_PATTERN = Pattern.compile("^\\d+$");
    public static final Set<String> FORBIDDEN_WORDS = new HashSet<>(Arrays.asList("слово1", "слово2", "слово3", "слово4", "слово5"));
    public static final String FORBIDDEN_WORDS_REGEX = "\\b(" + String.join("|", FORBIDDEN_WORDS) + ")\\b";

}
