package resources.commons;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;
import resources.utils.DriverManager;


public class ActionsCommon {
    private final WebDriver driver;

    public ActionsCommon(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToPage(String url) {
        driver.get(url);
    }

    public void clickElement(By locator) throws IOException {
        validateElement(locator);
        driver.findElement(locator).click();
        DriverManager.screenshotElement(locator);
    }

    public void inputElement(By locator, String msg) throws IOException {
        validateElement(locator);
        driver.findElement(locator).sendKeys(msg);
        DriverManager.screenshotElement(locator);
    }
    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void validateElement(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            System.out.println("Elemento não encontrado " + locator.toString());
        }
    }
}
