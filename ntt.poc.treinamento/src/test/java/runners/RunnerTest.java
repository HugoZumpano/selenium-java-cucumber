package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
				plugin = {"pretty","html:target/report.html", "json:target/report.json","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
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

