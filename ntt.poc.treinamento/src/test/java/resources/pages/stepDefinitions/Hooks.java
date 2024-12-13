package resources.pages.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import resources.utils.DriverManager;
import resources.utils.ScreenshotUtil;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {
    private WebDriver driver;

    @Before
    public void setup() {
        DriverManager.initialDriver();
    }

    @After
    public void tearDown(io.cucumber.java.Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            ScreenshotUtil.screenshotPage();
        }
        driver.quit();
    }

}