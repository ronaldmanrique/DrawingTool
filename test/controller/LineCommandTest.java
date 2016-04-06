package controller;

import model.Model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import suite.DummyRenderer;
import suite.TestUtil;

public class LineCommandTest {

	private LineCommand underTest = null;

	private Model model;

	@Before
	public void setUp() {
		underTest = new LineCommand();
		underTest.setRenderer(new DummyRenderer());
		model = new Model();

		char initialCanvas[][] = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' } };
		model.setCanvas(initialCanvas);
	}

	@Test
	public void executeTest() {
		String args[] = { "Can be ignored", "1" , "2", "6" , "2"   };
		Assert.assertFalse(underTest.execute(model, args));

		char expectedCanvas[][] = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
				{ '|', 'x', 'x', 'x', 'x', 'x', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' } };
		
		Assert.assertTrue(TestUtil.compareMatrix(expectedCanvas, model.getCanvas()));

		
		// inverse coordinates
		String args2[] = { "Can be ignored", "6" , "2", "1" , "2"   };
		Assert.assertFalse(underTest.execute(model, args2));
		Assert.assertTrue(TestUtil.compareMatrix(expectedCanvas, model.getCanvas()));
	}

	@Test
	public void execute2Test() {
		String args[] = { "Can be ignored", "6" , "3", "6" , "4"   };
		Assert.assertFalse(underTest.execute(model, args));

		char expectedCanvas[][] = { 
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
				{ '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
				{ '|', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
				{ '|', ' ', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
				{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' } };
		
		Assert.assertTrue(TestUtil.compareMatrix(expectedCanvas, model.getCanvas()));
		
		// inverse coordinates
		String args2[] = { "Can be ignored", "6" , "4", "6" , "3"   };
		Assert.assertFalse(underTest.execute(model, args2));
		Assert.assertTrue(TestUtil.compareMatrix(expectedCanvas, model.getCanvas()));
	}

	@Test(expected = RuntimeException.class)
	public void executeShouldTrowExceptionNoHorizontalVerticalTest() {
		String args[] = { "Can be ignored", "6", "2", "7", "7" };
		Assert.assertFalse(underTest.execute(model, args));
	}

	@Test(expected = RuntimeException.class)
	public void executeShouldTrowExceptionOutOfCanvasTest() {
		String args[] = { "Can be ignored", "111", "2222", "111", "2222" };
		Assert.assertFalse(underTest.execute(model, args));
	}
}
