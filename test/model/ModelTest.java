package model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ModelTest {

	private Model underTest;
	private int MAX_WIDTH = 20;
	private int MAX_LENGHT = 4;

	@Before
	public void setUp() {
		underTest = new Model();
		underTest.setCanvas(new char[MAX_LENGHT + 2][MAX_WIDTH + 2]);
	}

	@Test
	public void isValidCoordinateTest() {
		Assert.assertFalse(underTest.isValidCoordinate(MAX_WIDTH + 1, MAX_LENGHT + 1));
		Assert.assertTrue(underTest.isValidCoordinate(MAX_WIDTH, MAX_LENGHT));
		Assert.assertTrue(underTest.isValidCoordinate(MAX_WIDTH - 1, MAX_LENGHT - 1));
	}
}
