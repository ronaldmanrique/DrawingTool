package main;

import java.util.Scanner;

import controller.CommandFactory;

public class ConsoleMenu {

	public void start() {
		showMessage("Hello:");
		showMainMenu();
	}

	public void showMainMenu() {
		
		showMessage("Enter command:");
		Scanner in = new Scanner(System.in);
		String command = in.nextLine();
		boolean programShouldExit = CommandFactory.getInstance().executeCommand(command);
		if(!programShouldExit){
			showMainMenu();
		}
	}

	
	public void showMessage(String message) {
		System.out.println(message);

	}
}
