package controller;

import model.Model;
import view.ConsoleRenderer;

public class LineCommand extends Command {

	public LineCommand() {
		renderer = new ConsoleRenderer();
	}

	@Override
	public boolean execute(Model model, String... args) {
		int x1 = Integer.parseInt(args[1]);
		int y1 = Integer.parseInt(args[2]);
		int x2 = Integer.parseInt(args[3]);
		int y2 = Integer.parseInt(args[4]);

		if (!(x1 == x2 || y1 == y2)) {
			throw new RuntimeException("Currently only horizontal or vertical lines are supported");
		}

		boolean validate = model.isValidCoordinate(x1, y1);
		validate = validate && model.isValidCoordinate(x2, y2);
		if (!validate) {
			throw new RuntimeException("The line coordinates are out of the canvas.");
		}

		// swaps coordinates
		if (x1 > x2) {
			int temp = x2;
			x2 = x1;
			x1 = temp;
		}
		if (y1 > y2) {
			int temp = y2;
			y2 = y1;
			y1 = temp;
		}
		// creates the line based on coordinates
		for (int i = 0; i < model.getCanvas().length; i++) {
			for (int j = 0; j < model.getCanvas()[i].length; j++) {
				if (j >= x1 && j <= x2 && i >= y1 && i <= y2) {
					model.getCanvas()[i][j] = 'x';
				}
			}
		}

		renderer.render(model);
		return shouldEndExecution();
	}
}
