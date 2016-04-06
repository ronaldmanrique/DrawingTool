package controller;

import model.Model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import suite.DummyRenderer;
import suite.TestUtil;

public class BucketCommandTest {

	private BucketCommand underTest = null;

	private Model model;

	@Before
	public void setUp() {
		underTest = new BucketCommand();
		underTest.setRenderer(new DummyRenderer());
		model = new Model();

		char initialCanvas[][] = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x', 'x', 'x', '|' },
				{ '|', 'x', 'x', 'x', 'x', 'x', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', 'x', '|' },
				{ '|', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'x', 'x', 'x', 'x', '|' },
				{ '|', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' } };
		model.setCanvas(initialCanvas);
	}

	@Test
	public void executeTest() {
		String args[] = { "Can be ignored", "10", "3", "o" };
		Assert.assertFalse(underTest.execute(model, args));

		char expectedCanvas[][]  = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
				{ '|', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'x', 'x', 'x', 'x', '|' },
				{ '|', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', ' ', ' ', ' ', 'x', '|' },
				{ '|', ' ', ' ', ' ', ' ', ' ', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'x', 'x', 'x', 'x', '|' },
				{ '|', ' ', ' ', ' ', ' ', ' ', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', '|' },
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' } };
		
		Assert.assertTrue(TestUtil.compareMatrix(expectedCanvas, model.getCanvas()));
	}

	@Test(expected = RuntimeException.class)
	public void executeShouldTrowExceptionOutOfCanvasTest() {
		String args[] = { "Can be ignored", "100", "101", "o" };
		Assert.assertFalse(underTest.execute(model, args));
	}
}
