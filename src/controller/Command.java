package controller;

import view.Renderer;
import model.Model;

public abstract class Command {

	protected Renderer renderer;

	public abstract boolean execute(Model model, String... args);

	public boolean shouldEndExecution() {
		return false;
	}

	public void setRenderer(Renderer renderer) {
		this.renderer = renderer;
	}
}
