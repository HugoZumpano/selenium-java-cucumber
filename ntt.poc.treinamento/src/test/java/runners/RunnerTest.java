package runners;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
				plugin = {"pretty","html:target/report.html", "json:target/report.json"},
				features = {
						 RunnerTest.loginAutomation
				 },
				tags ="",
				glue = "resources.pages.stepDefinitions",
			    dryRun = false,
				monochrome = false
				 )
public class RunnerTest {
	public static final String loginAutomation = "src\\test\\java\\features\\login_automation.feature";
}

