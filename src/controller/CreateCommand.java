package controller;

import model.Model;
import view.ConsoleRenderer;

public class CreateCommand extends Command {

	public CreateCommand() {
		renderer = new ConsoleRenderer();
	}

	@Override
	public boolean execute(Model model, String... args) {
		int heigth = Integer.parseInt(args[1]);
		int width = Integer.parseInt(args[2]);
		char[][] canvas = new char[width + 2][heigth + 2];

		for (int i = 0; i < canvas.length; i++) {
			for (int j = 0; j < canvas[i].length; j++) {
				if (i == 0 || i == canvas.length - 1) {
					canvas[i][j] = '-';
				} else if (j == 0 || j == canvas[i].length - 1) {
					canvas[i][j] = '|';
				} else {
					canvas[i][j] = ' ';
				}
			}
		}

		model.setCanvas(canvas);
		renderer.render(model);
		return shouldEndExecution();
	}
}
