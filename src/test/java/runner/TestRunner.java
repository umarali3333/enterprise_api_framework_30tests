
package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/*
Main runner class executing all feature files
*/

@CucumberOptions(
features="src/test/resources/features",
glue={"steps"},
plugin={"pretty","html:target/cucumber-report.html"},
monochrome=true
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
