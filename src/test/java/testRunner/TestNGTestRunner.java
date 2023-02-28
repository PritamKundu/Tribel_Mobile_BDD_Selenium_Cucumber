package testRunner;
import io.cucumber.core.api.TypeRegistry;
import io.cucumber.cucumberexpressions.ParameterType;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Test
@CucumberOptions(features="src/test/java/features",glue ="stepDefinitions",monochrome=true,
		tags ="",
		plugin= {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)

public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}

	public void configureTypeRegistry(TypeRegistry typeRegistry) {
		typeRegistry.defineParameterType(new ParameterType<>(
				"integerList",  //this name can be used in the step method
				"(-?[0-9]+(,\\s*-?[0-9]+)*)", //regexp to match to a comma separated integer list which can contain negative numbers and whitespaces as well
				List.class,  //the expected parameter type
				this::transform  // equivalent to (String s) -> this.transformer(s), this is the transformer method which will be used to create the desired step parameter
		));
	}

	//transforms the string form to an integer list
	private List<Integer> transform(String integers) {
		List<String> integersAsString = Arrays.asList(integers.split(","));
		return integersAsString.stream().map(s -> Integer.valueOf(s.trim())).collect(Collectors.toList());
	}





}

