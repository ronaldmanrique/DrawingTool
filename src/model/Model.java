package model;

public class Model {

	private char canvas[][];

	public char[][] getCanvas() {
		return canvas;
	}

	public void setCanvas(char[][] canvas) {
		this.canvas = canvas;
	}

	public boolean isValidCoordinate(int x, int y) {

		int maxWidth = canvas[0].length - 2;
		int maxLength = canvas.length - 2;

		if (x > maxWidth || y > maxLength) {
			return false;
		}
		return true;
	}
}
