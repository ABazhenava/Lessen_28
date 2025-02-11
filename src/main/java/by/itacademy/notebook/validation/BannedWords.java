package by.itacademy.notebook.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class BannedWords {
    public static final Set<String> BANNED_WORDS = new HashSet<>(Arrays.asList("слово1", "слово2", "слово3", "слово4", "слово5"));
    public static final String BANNED_WORDS_REGEX = "\\b(" + String.join("|", BANNED_WORDS) + ")\\b";
}
