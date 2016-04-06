package suite;

import model.ModelTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import controller.ControllerTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ControllerTestSuite.class, ModelTest.class })
public class JunitTestSuite {

}
