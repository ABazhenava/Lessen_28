package by.itacademy.notebook.controller;

import by.itacademy.notebook.logic.LogicException;

public class Controller {
	private final char paramDelimeter = '\n';
	private final CommandProvider provider = new CommandProvider();
	
	public String doAction(String request) throws LogicException {
		String command;
		command = request.substring(0, request.indexOf(paramDelimeter));
		command = command.toUpperCase();
		
		String commandName;
		Command executionCommand;
		
		commandName = request.substring(0, request.indexOf(paramDelimeter));
		executionCommand = provider.getCommand(commandName);
		
		String response;
		response = executionCommand.execute(request);
		
		return response;
	}
}


