package resources.pages.action;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import resources.utils.DriverManager;

public class Hooks {

    @Before
    public void setup() {
        DriverManager.initialDriver();
    }

    @After
    public void teardown() {
        DriverManager.quitDriver();
    }
}
