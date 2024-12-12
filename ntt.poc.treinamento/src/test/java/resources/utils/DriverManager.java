package resources.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DriverManager {
    public static WebDriver driver;

    public static void initialDriver() {
        if(driver == null){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
    }
    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver não iniciado");
        }
        return driver;
    }
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
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
