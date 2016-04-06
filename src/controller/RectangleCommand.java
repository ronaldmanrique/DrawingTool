package controller;

import model.Model;
import view.ConsoleRenderer;

public class RectangleCommand extends Command {

	public RectangleCommand() {
		renderer = new ConsoleRenderer();
	}

	@Override
	public boolean execute(Model model, String... args) {
		int x1 = Integer.parseInt(args[1]);
		int y1 = Integer.parseInt(args[2]);
		int x2 = Integer.parseInt(args[3]);
		int y2 = Integer.parseInt(args[4]);

		if (x2 <= x1 || y2 <= y1) {
			throw new RuntimeException("First coordianate should have lower X and Y values");
		}

		boolean validate = model.isValidCoordinate(x1, y1);
		validate = validate && model.isValidCoordinate(x2, y2);
		if (!validate) {
			throw new RuntimeException("The line coordinates are out of the canvas.");
		}

		// creates the rectangle based on coordinates
		for (int i = 0; i < model.getCanvas().length; i++) {
			for (int j = 0; j < model.getCanvas()[i].length; j++) {
				if ((j >= x1 && j <= x2) && (i >= y1 && i <= y2)) {
					if (j == x1 || j == x2 || i == y1 || i == y2) {
						model.getCanvas()[i][j] = 'x';
					}
				}
			}
		}

		renderer.render(model);
		return shouldEndExecution();
	}
}
