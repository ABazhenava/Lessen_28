package by.itacademy.notebook.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ValidationMethods {

    public static boolean isValidCommandName(String request) {
        Matcher matcher = PatternVar.COMMAND_PATTERN.matcher(request);
        return matcher.matches();
    }

    public static boolean isValidTitle(String title) {
        Matcher matcher = PatternVar.TITLE_PATTERN.matcher(title);
        return matcher.matches();
    }

    public static boolean isValidContent(String content) {
        Matcher matcher = PatternVar.CONTENT_PATTERN.matcher(content);
        return matcher.matches();
    }

    public static boolean isValidDate(String date) {
        Matcher matcher = PatternVar.DATE_PATTERN.matcher(date);
        return matcher.matches();
    }

    public static boolean isValidId(String id) {
        Matcher matcher = PatternVar.ID_PATTERN.matcher(id);
        return matcher.matches();
    }

//    public static boolean containsForbiddenWords(String text) {
//        for (String word : PatternVar.FORBIDDEN_WORDS) {
//            if (text.toLowerCase().contains(word)) {
//                return true;
//            }
//        }
//        return false;
//    }

    public static boolean containsForbiddenWords(String input) {
        Pattern pattern = Pattern.compile(PatternVar.FORBIDDEN_WORDS_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
