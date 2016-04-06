package controller;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import controller.BucketCommandTest;
import controller.CommandFactoryTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ BucketCommandTest.class, CommandFactoryTest.class, CreateCommandTest.class, LineCommandTest.class, QuitCommandTest.class,
		RectangleCommandTest.class })
public class ControllerTestSuite {

}
