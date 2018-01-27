package ru.egorvas.propertyfinder.definitions;

import com.codeborne.selenide.Configuration;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import ru.egorvas.propertyfinder.general.SystemConstants;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.screenshot;
import static ru.egorvas.propertyfinder.CucumberTest.addScreenshotToAllure;

/**
 * Created by egorvas on 27.01.2018.
 */
public class BaseDefinitions {
    private String keyword;

    @Given("I open browser with (.*)")
    public void openBrowserWith(String keyword){
        Configuration.browser = SystemConstants.BROWSER;
        Configuration.timeout = SystemConstants.TIMEOUT;
        open(keyword);
    }

    @Then("capture screenshot of the page with name (.*)")
    public void makeScreenshot(String keyword){
        addScreenshotToAllure(screenshot(keyword));
    }

    @After
    public void addScreenshotOnFail(Scenario scenario) {
        if(scenario.isFailed()) {
            addScreenshotToAllure(screenshot("failScreenshot"));
        }
    }
}
