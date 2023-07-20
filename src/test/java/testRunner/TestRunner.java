package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
		(
			features = ".//Features/Login.feature",	//feature file location
			// to run all feature files features=".//Features/"
			// to run multiple; features={".//Features/Customer.feature",".//Features/Login.feature"}
			glue = "stepDefinitions",	//packageName, where the step definitions are implemented
			//All the stepDefinition files will be considered
			dryRun = false,	//when true, checks whether each step has corresponding step definition(implementation method)
							//when false, executes actual tests
			monochrome = false,
			//plugin= {"pretty","html: test-output/cucumber-reports/report.html"}	//html will be created in test-output; test-output will be auto created
			//plugin= {"pretty","json: test-output/cucumber-reports/report.json"}
			//tags = "@Sanity or @Regression",	
			tags = "@Sanity or @Regression",			
			//"@Tag1 and @Tag2"	-- OR
			//"@Tag1 or @Tag2" -- AND
			//"@Tag1 and not @Regression
			//plugin= {"pretty","html:test-output/cucumber-reports/report.html","json:test-output/cucumber-reports/report.json"}
			plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}	
		)
	
//Always run through TestRunner or else reports won't be generated


public class TestRunner {

}
