package by.itacademy.notebook.start;

import by.itacademy.notebook.controller.Controller;
import by.itacademy.notebook.logic.LogicException;


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

    }
}