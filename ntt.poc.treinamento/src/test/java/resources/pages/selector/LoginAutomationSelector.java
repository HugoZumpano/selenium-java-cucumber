package resources.pages.selector;

import org.openqa.selenium.By;

public class LoginAutomationSelector {
    public static final By INPUT_EMAIL = By.cssSelector("[id='ussser[email]']");
    public static final By INPUT_PASSWORD = By.cssSelector("[id='user[password]']");
    public static final By BUTTON_SIGN_IN = By.cssSelector("[data-callback='onSubmit']");
    public static final By MSG_EMAIL_INVALID = By.cssSelector("[id='user[email]-error']");
}
