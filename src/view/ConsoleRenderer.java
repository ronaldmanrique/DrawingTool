package view;

import model.Model;

public class ConsoleRenderer implements Renderer {

	@Override
	public void render(Model model) {
		for (int i = 0; i < model.getCanvas().length; i++) {
			for (int j = 0; j < model.getCanvas()[i].length; j++) {
				System.out.print(model.getCanvas()[i][j]);
			}
			System.out.println();
		}
	}

}
