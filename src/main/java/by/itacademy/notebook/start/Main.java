package by.itacademy.notebook.start;

import by.itacademy.notebook.controller.Controller;
import by.itacademy.notebook.logic.LogicException;
import by.itacademy.notebook.util.TextReplacement;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws LogicException {
        Controller contr = new Controller();
        String request;
        String response;

        request = "ADD\ntitle=Номер один\nсоntent=Первая запись по списку";
        response = contr.doAction(request);
        System.out.println(response);

        request = "ADD\ntitle=Номер два\nсоntent=Вторая запись по списку";
        response = contr.doAction(request);
        System.out.println(response);

        request = "UPDATE\nid=1\ntitle=Номер один\ncontent=Новая запись по списку\ndate=2025-01-01";
        response = contr.doAction(request);
        System.out.println(response);

        request = "FINDBYDATE\ndate=2025-01-02";
        response = contr.doAction(request);
        System.out.println(response);

        request = "FINDBYContent\nid=1";
        response = contr.doAction(request);
        System.out.println(response);

        request = "DISPLAY\nall Notes";
        response = contr.doAction(request);
        System.out.println(response);

//////////////////////////////////////////////////////
//
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Введите искомое выражение: ");
//        String newContent = scanner.nextLine();
//
//        System.out.print("Введите заменяемое значение: ");
//        String replacement = scanner.nextLine();
//
//        TextReplacement textReplacement = new TextReplacement(newContent, replacement);
//        textReplacement.replaceTextInFile("notes.txt", "notes.txt");
//
//        scanner.close();

//        Scanner scanner = new Scanner(System.in);
//        String menuPoint = "";
//        while (!"0".equals(menuPoint)) {
//            System.out.println(NotebookApp.MENU);
//            menuPoint = scanner.nextLine();
//
//            switch (menuPoint) {
//                case "1":
//                    processInputRequest(scanner, contr, "ADD\n", "Введите данные для создания новой записи.");
//                    break;
//                case "2":
//                    processInputRequest(scanner, contr, "GETNOTESBYCONTENT\n", "Введите данные для поиска записей по содержимому.");
//                    break;
//                case "3":
//                    processInputRequest(scanner, contr, "GETNOTEBYDATE\n", "Введите дату для поиска записей по дате в формате (дд/мм/гггг):");
//                    break;
//                case "4":
//                    processRequest(contr, "GETALLNOTES\n");
//                    break;
//                case "5":
//                    updateNoteById(scanner, contr);
//                    break;
//                case "0":
//                    handleExit(scanner, contr);
//                    break;
//                default:
//                    processRequest(contr, "WRONG_REQUEST\n");
//            }
//        }
//    }
//
//    private static void processRequest(Controller contr, String action) throws LogicException {
//        String response = contr.doAction(action);
//        System.out.println(response);
//    }
//
//    private static void processInputRequest(Scanner scanner, Controller contr, String action, String message) throws LogicException {
//        System.out.println(message);
//        System.out.println(NotebookApp.INVALID_INPUT_MSG);
//        String input = scanner.nextLine().replace(";", "");
//        String response = contr.doAction(action + input);
//        System.out.println(response);
//    }
//
//    private static void updateNoteById(Scanner scanner, Controller contr) throws LogicException {
//        System.out.println("Введите id записи, которую хотите изменить:");
//        String id = scanner.nextLine();
//        System.out.println("Введите новое значение:");
//        String newValue = scanner.nextLine().replace(";", "");
//        String response = contr.doAction("UPDATENOTEBYID\n" + id + "\n" + newValue);
//        System.out.println(response);
//    }
//
//    private static void handleExit(Scanner scanner, Controller contr) throws LogicException {
//        String needSave = "";
//        while (!needSave.equals("y") && !needSave.equals("n")) {
//            System.out.println("Желаете сохранить? (Y/N)");
//            needSave = scanner.nextLine().toLowerCase();
//            if (needSave.equals("y")) {
//                processRequest(contr, "SAVE\n");
//            }
//        }
//    }
//
    }
}
