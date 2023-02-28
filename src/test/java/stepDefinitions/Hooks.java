package stepDefinitions;
import java.io.IOException;
import io.cucumber.java.After;
import utils.TestContextSetup;

public class Hooks{

    TestContextSetup testContextSetup;

	public Hooks(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
	}

/*	@After
	public void

	AfterScenario() throws IOException, InterruptedException {
		testContextSetup.testBase.WebDriverManager().quit();
	}*/

}
