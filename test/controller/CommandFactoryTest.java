package controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommandFactoryTest {

	CommandFactory commandFactory = null;

	@Before
	public void setUp() {
		commandFactory = CommandFactory.getInstance();
	}
	
	@Test
	public void executeCommandTest() {
		Assert.assertTrue(commandFactory.executeCommand("Q no matter what"));
		Assert.assertFalse(commandFactory.executeCommand("Something else maybe not supported"));
	}
	@Test
	public void getCommandTest() {
		Assert.assertTrue(commandFactory.getCommand(CommandFactory.CommandType.C) instanceof CreateCommand);
		Assert.assertTrue(commandFactory.getCommand(CommandFactory.CommandType.L) instanceof LineCommand);
		Assert.assertTrue(commandFactory.getCommand(CommandFactory.CommandType.R) instanceof RectangleCommand);
		Assert.assertTrue(commandFactory.getCommand(CommandFactory.CommandType.B) instanceof BucketCommand);
		Assert.assertTrue(commandFactory.getCommand(CommandFactory.CommandType.Q) instanceof QuitCommand);
		Assert.assertNull(commandFactory.getCommand(null));

	}

}
