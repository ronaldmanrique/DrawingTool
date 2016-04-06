package controller;

import model.Model;
import view.ConsoleRenderer;

public class BucketCommand extends Command {

	public BucketCommand() {
		renderer = new ConsoleRenderer();
	}

	@Override
	public boolean execute(Model model, String... args) {
		int x = Integer.parseInt(args[1]);
		int y = Integer.parseInt(args[2]);
		char c = args[3].charAt(0);

		model.isValidCoordinate(x, y);

		fill(x, y, model, c);
		renderer.render(model);
		return shouldEndExecution();
	}

	private void fill(int x, int y, Model model, char fillCharacter) {
		if (isScapeChar(model.getCanvas()[y][x], fillCharacter)) {
			return;
		}
		if (!model.isValidCoordinate(x, y)) {
			return;
		}
		model.getCanvas()[y][x] = fillCharacter;

		fill(x, y + 1, model, fillCharacter);
		fill(x, y - 1, model, fillCharacter);
		fill(x + 1, y, model, fillCharacter);
		fill(x - 1, y, model, fillCharacter);
	}

	private boolean isScapeChar(char character, char fillCharacter) {
		return character == fillCharacter || character != ' ';
	}
}
