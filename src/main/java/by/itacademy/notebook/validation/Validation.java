package by.itacademy.notebook.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Validation {

    public static boolean isValidCommandName(String request) {
        Matcher matcher = PatternConstants.COMMAND_PATTERN.matcher(request);
        return matcher.matches();
    }

    public static boolean isValidTitle(String title) {
        Matcher matcher = PatternConstants.TITLE_PATTERN.matcher(title);
        return matcher.matches();
    }

    public static boolean isValidContent(String content) {
        Matcher matcher = PatternConstants.CONTENT_PATTERN.matcher(content);
        return matcher.matches();
    }

    public static boolean isValidDate(String date) {
        Matcher matcher = PatternConstants.DATE_PATTERN.matcher(date);
        return matcher.matches();
    }

    public static boolean isValidId(String id) {
        Matcher matcher = PatternConstants.ID_PATTERN.matcher(id);
        return matcher.matches();
    }

    public static boolean containsForbiddenWords(String input) {
        Pattern pattern = Pattern.compile(PatternConstants.FORBIDDEN_WORDS_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
