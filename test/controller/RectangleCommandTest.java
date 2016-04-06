package controller;

import model.Model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import suite.DummyRenderer;
import suite.TestUtil;

public class RectangleCommandTest {

	private RectangleCommand underTest = null;

	private Model model;

	@Before
	public void setUp() {
		underTest = new RectangleCommand();
		underTest.setRenderer(new DummyRenderer());
		model = new Model();

		char initialCanvas[][] = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
				{ '|', 'x', 'x', 'x', 'x', 'x', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
				{ '|', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
				{ '|', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' } };
		model.setCanvas(initialCanvas);
	}

	@Test
	public void executeTest() {
		String args[] = { "Can be ignored", "16", "1", "20", "3" };
		Assert.assertFalse(underTest.execute(model, args));

		char expectedCanvas[][]  = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x', 'x', 'x', '|' },
				{ '|', 'x', 'x', 'x', 'x', 'x', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', 'x', '|' },
				{ '|', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x', 'x', 'x', '|' },
				{ '|', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' } };
		
		Assert.assertTrue(TestUtil.compareMatrix(expectedCanvas, model.getCanvas()));
	}


	@Test(expected = RuntimeException.class)
	public void executeShouldTrowExceptionFirstCoordLowerThanSecondTest() {
		String args[] = { "Can be ignored", "6", "2", "7", "7" };
		Assert.assertFalse(underTest.execute(model, args));
	}

	@Test(expected = RuntimeException.class)
	public void executeShouldTrowExceptionOutOfCanvasTest() {
		String args[] = { "Can be ignored", "111", "2222", "111", "2222" };
		Assert.assertFalse(underTest.execute(model, args));
	}
}
