package resources.pages.stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import resources.pages.action.ActionsCommon;
import resources.pages.selector.ScenarioPages;
import resources.utils.DriverManager;

import java.io.IOException;

public class UltimateQaStep {
    WebDriver driver =  DriverManager.getDriver();
    ActionsCommon action = new ActionsCommon(driver);

    @Given("escolho a tela para realizar o teste: {string}")
    public void escolho_a_tela_para_realizar_o_teste(String tela) throws IOException {
        By locator = switch (tela) {
            case "BIG_PAGE" -> ScenarioPages.BIG_PAGE;
            case "FAKE_LADING" -> ScenarioPages.FAKE_LADING;
            case "BIG_PRICING" -> ScenarioPages.BIG_PRICING;
            case "FILL_OUT" -> ScenarioPages.FILL_OUT;
            case "LEARN_HOW" -> ScenarioPages.LEARN_HOW;
            case "LOGIN_AUTOMATION" -> ScenarioPages.LOGIN_AUTOMATION;
            case "INTERACTION_WITH" -> ScenarioPages.INTERACTION_WITH;
            default -> throw new IllegalArgumentException("Link cenário não encontrado: " + tela);
        };
        action.clickElement(locator);
    }
}
