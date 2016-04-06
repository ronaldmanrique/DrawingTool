package controller;

import model.Model;
import view.QuitRenderer;

public class QuitCommand extends Command {

	public QuitCommand() {
		renderer = new QuitRenderer();
	}

	@Override
	public boolean execute(Model model, String... args) {
		renderer.render(model);
		return shouldEndExecution();
	}

	@Override
	public boolean shouldEndExecution() {
		return true;
	}
}
