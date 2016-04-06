package controller;

import model.Model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import suite.DummyRenderer;
import suite.TestUtil;

public class CreateCommandTest {

	private CreateCommand underTest = null;

	private Model model;
	private int MAX_WIDTH = 20;
	private int MAX_LENGHT = 4;

	@Before
	public void setUp() {
		underTest = new CreateCommand();
		underTest.setRenderer(new DummyRenderer());
		model = new Model();
	}

	@Test
	public void executeTest() {
		String args[] = { "Can be ignored", "" + MAX_WIDTH, "" + MAX_LENGHT };
		Assert.assertFalse(underTest.execute(model, args));
		Assert.assertEquals(MAX_LENGHT, model.getCanvas().length - 2);
		Assert.assertEquals(MAX_WIDTH, model.getCanvas()[0].length - 2);

		char expectedCanvas[][] = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' } };
		Assert.assertTrue(TestUtil.compareMatrix(expectedCanvas, model.getCanvas()));
	}

	@Test(expected = NumberFormatException.class)
	public void executeShouldTrowExceptionTest() {
		String args[] = { "Can be ignored", "not a number", "not a number" };
		Assert.assertFalse(underTest.execute(model, args));
	}

}
