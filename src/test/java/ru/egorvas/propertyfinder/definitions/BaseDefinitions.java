package ru.egorvas.propertyfinder.definitions;

import com.codeborne.selenide.Configuration;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import ru.egorvas.propertyfinder.CucumberTest;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.screenshot;

/**
 * Created by egorvas on 27.01.2018.
 */
public class BaseDefinitions {
    private String keyword;

    @Given("I open browser with (.*)")
    public void openBrowserWith(String keyword){
        Configuration.browser = "chrome";
        open(keyword);
    }

    @Then("capture screenshot of the page with name (.*)")
    public void makeScreenshot(String keyword){
        CucumberTest.addScreenshotToAllure(screenshot(keyword));
    }
}
