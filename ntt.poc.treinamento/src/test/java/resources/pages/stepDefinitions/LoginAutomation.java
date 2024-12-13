package resources.pages.stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import resources.commons.ActionsCommon;
import resources.pages.URLs.UltimateQa;
import resources.pages.selector.LoginAutomationSelector;
import resources.pages.selector.ScenarioPages;
import resources.utils.DriverManager;
import resources.utils.ScreenshotUtil;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class LoginAutomation {
    WebDriver driver =  DriverManager.getDriver();
    ActionsCommon action = new ActionsCommon(driver);

    @Given("eu acesso a pagina ultimate qa")
    public void eu_acesso_a_pagina_ultimate_qa() {
        action.navigateToPage(UltimateQa.ULTIMATE_QA);
    }

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

    @When("eu digito o email com formato incorreto: {string}")
    public void eu_digito_o_email_com_formato_incorreto(String string) throws IOException {
        action.inputElement(LoginAutomationSelector.INPUT_EMAIL , string);
        action.clickElement(LoginAutomationSelector.INPUT_PASSWORD);
    }

    @Then("valido que apareceu a mensagem de email incorreto {string}")
    public void valido_que_apareceu_a_mensagem_de_email_incorreto(String msgEmailInvalid) throws IOException {
        String  text = action.getText(LoginAutomationSelector.MSG_EMAIL_INVALID);
        assertEquals(msgEmailInvalid , text);
        ScreenshotUtil.screenshotElement(LoginAutomationSelector.MSG_EMAIL_INVALID);
    }
}
