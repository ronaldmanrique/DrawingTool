package controller;

import model.Model;

public class CommandFactory {

	private Model model;
	private static CommandFactory instance = null;

	public enum CommandType {
		C, L, R, B, Q
	};

	private CommandFactory() {
		model = new Model();
	}

	public static CommandFactory getInstance() {
		if (instance == null) {
			instance = new CommandFactory();
		}
		return instance;
	}

	public boolean executeCommand(String commandStr) {
		String[] args = commandStr.split(" ");
		// First arguments defines the command.
		try {
			CommandType commandType = CommandType.valueOf(args[0]);
			Command command = getCommand(commandType);
			return command.execute(model, args);
		} catch (Exception e) {
			System.out.println("Command not supported: " + commandStr + " " + e.getMessage() + ".");
			return false;
		}
	}

	public Command getCommand(CommandType commandType) {
		if (commandType != null) {
			switch (commandType) {
			case C:
				return new CreateCommand();
			case L:
				return new LineCommand();
			case R:
				return new RectangleCommand();
			case B:
				return new BucketCommand();
			case Q:
				return new QuitCommand();
			default:
				return null;
			}
		}
		return null;
	}

}
