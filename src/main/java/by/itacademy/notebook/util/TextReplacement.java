package by.itacademy.notebook.util;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextReplacement {

//    private String searchText;
//    private String replacement;
//
//    public TextReplacement() {
//    }
//
//    public TextReplacement(String searchText, String replacement) {
//        this.searchText = searchText;
//        this.replacement = replacement;
//    }
//
//    public void replaceTextInFile(String inputFile, String outputFile) {
//        BufferedReader reader = null;
//        BufferedWriter writer = null;
//        try {
//            reader = new BufferedReader(new FileReader(inputFile));
//            StringBuilder text = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                text.append(line).append(System.lineSeparator());
//            }
//
//            Pattern pattern = Pattern.compile(searchText, Pattern.CASE_INSENSITIVE);
//            Matcher matcher = pattern.matcher(text.toString());
//            if (!matcher.find()) {
//                System.out.println("Искомого значение не найдено в файле.");
//                return;
//            }
//            String result = matcher.replaceAll(replacement);
//
//            writer = new BufferedWriter(new FileWriter(outputFile, true));
//            writer.write(result);
//            writer.newLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (reader != null) {
//                    reader.close();
//                }
//                if (writer != null) {
//                    writer.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}

