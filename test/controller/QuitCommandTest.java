package controller;

import model.Model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import suite.DummyRenderer;

public class QuitCommandTest {

	private QuitCommand underTest = null;

	private Model model;
	private Model expectedModel;

	private int MAX_WIDTH = 20;
	private int MAX_LENGHT = 4;

	@Before
	public void setUp() {
		underTest = new QuitCommand();
		underTest.setRenderer(new DummyRenderer());
		model = new Model();
		model.setCanvas(new char[MAX_LENGHT + 2][MAX_WIDTH + 2]);

		expectedModel = new Model();
		expectedModel.setCanvas(new char[MAX_LENGHT + 2][MAX_WIDTH + 2]);
	}

	@Test
	public void executeTest() {
		Assert.assertTrue(underTest.execute(model, new String[0]));
	}

	@Test
	public void executeShouldNotChangeModelTest() {

		for (int i = 0; i < model.getCanvas().length; i++) {
			for (int j = 0; j < model.getCanvas()[i].length; j++) {
				Assert.assertEquals(model.getCanvas()[i][j], expectedModel.getCanvas()[i][j]);
			}
		}
	}

}
