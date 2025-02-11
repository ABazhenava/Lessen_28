package by.itacademy.notebook.controller;

import by.itacademy.notebook.dao.DaoException;
import by.itacademy.notebook.logic.LogicException;
import by.itacademy.notebook.validation.ValidatorUtils;


public class Controller {
    private final char paramDelimeter = '\n';
    private final CommandProvider provider = new CommandProvider();

    public String doAction(String request) throws LogicException, DaoException {
        String substring = request.substring(0, request.indexOf(paramDelimeter));
        String command = substring.toUpperCase();

        if (!ValidatorUtils.hasValidateCommandName(command)) {
            return "Неправильный формат команды.";
        }

        String commandName = request.substring(0, request.indexOf(paramDelimeter));

        Command execution = provider.getCommand(commandName.toUpperCase());
        String response = execution.execute(request);
        return response;
    }
}
