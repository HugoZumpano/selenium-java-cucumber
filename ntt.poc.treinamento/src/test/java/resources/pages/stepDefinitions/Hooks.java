package resources.pages.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import resources.utils.DriverManager;
import resources.utils.ScreenshotUtil;
import java.io.IOException;


public class Hooks {

    @Before
    public void setup() {
        DriverManager.initialDriver();
    }

    @After
    public void tearDown(io.cucumber.java.@NotNull Scenario scenario) throws IOException {
        if (scenario.isFailed()){
                ScreenshotUtil.screenshotPage();
            }
            DriverManager.quitDriver();
       }
}
