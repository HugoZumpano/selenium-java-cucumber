package resources.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    private static final WebDriver driver = DriverManager.getDriver();

    public static void screenshotElement(By locator) throws IOException {
        String time = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss-SS").format(new Date());
        WebElement element = driver.findElement(locator);
        String originalStyle = element.getDomProperty("style");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + time + ".png"));
        js.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }
}
