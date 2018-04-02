package Cucumberproject.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
   features= {"src/test/java/Cucumberproject/featurefile/"},
   glue= {"Cucumberproject.stepfiles"},
   monochrome=true,
   plugin= {"pretty","html:target/cucumber","json:target/cucumber.json",
	        "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber.html"   
   }
)

public class MainRunner {

}
