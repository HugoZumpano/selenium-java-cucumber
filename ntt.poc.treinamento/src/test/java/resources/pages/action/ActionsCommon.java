package resources.pages.action;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;

import resources.utils.ScreenshotUtil;


public class ActionsCommon {
    private final WebDriver driver;

    public ActionsCommon(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToPage(String url) {
        driver.get(url);
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void clickElement(By locator) throws IOException {
        validateElement(locator);
        ScreenshotUtil.screenshotElement(locator);
        find(locator).click();
    }

    public void inputText(By locator, String msg) throws IOException {
        validateElement(locator);
        find(locator).sendKeys(msg);
        ScreenshotUtil.screenshotElement(locator);
    }
    public String getText(By locator){
        return find(locator).getText();
    }

    protected void validateElement(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            System.out.println("Elemento não encontrado " + locator.toString());
        }
    }
}
