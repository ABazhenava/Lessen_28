package by.itacademy.notebook.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ValidatorUtils {

    public static boolean hasValidateCommandName(String request) {
        Matcher matcher = PatternConstants.COMMAND_PATTERN.matcher(request);
        return matcher.matches();
    }

    public static boolean hasValidateTitle(String title) {
        Matcher matcher = PatternConstants.TITLE_PATTERN.matcher(title);
        return matcher.matches();
    }

    public static boolean hasValidateContent(String content) {
        Matcher matcher = PatternConstants.CONTENT_PATTERN.matcher(content);
        return matcher.matches();
    }

    public static boolean hasValidateDate(String date) {
        Matcher matcher = PatternConstants.DATE_PATTERN.matcher(date);
        return matcher.matches();
    }

    public static boolean hasValidateId(String id) {
        Matcher matcher = PatternConstants.ID_PATTERN.matcher(id);
        return matcher.matches();
    }

    public static boolean isCheckForBannedWords(String input) {
        Pattern pattern = Pattern.compile(BannedWords.BANNED_WORDS_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
