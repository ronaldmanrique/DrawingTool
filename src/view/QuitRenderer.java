package view;

import model.Model;

public class QuitRenderer implements Renderer {

	@Override
	public void render(Model model) {
		System.out.println("Bye, Bye!!");
	}

}
