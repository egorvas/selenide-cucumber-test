package ru.egorvas.propertyfinder.definitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class AgentsSearchDefinitions {
//  private String keyword;

  @When("click on FIND AGENTS tab")
  public void clickOnTheFindAgentsButton(){
    $("a.js-find-agent").click();
  }

  @And("filter agents who can speak \"HINDI, ENGLISH, ARABIC\"")
  public void selectLanguages(){
    $x("//span[.='Languages']").click();
    ElementsCollection langs = $(By.className("search-filter-container")).$$("li");
    langs.find(Condition.text("English")).click();
    langs.find(Condition.text("Arabic")).click();
    langs.find(Condition.text("Hindi")).click();
  }

  @And("click on Search")
  public void clickSearch(){
    $(By.className("submit")).click();
  }

  @Then("compare number agents with number and number agents from India")
  public void compareNumberOfAgents(){
    SelenideElement numberOfAgentsElement = $(By.className("serp-h1"));
    String numberOfAgentsText = numberOfAgentsElement.text();

    $x("//span[.='Nationality']").click();
    $$(By.cssSelector("li")).find(Condition.text("India")).click();

    numberOfAgentsElement.waitUntil(Condition.not(Condition.text(numberOfAgentsText)),5000);
    Assert.assertTrue(Integer.parseInt(numberOfAgentsText.split(" ")[0])>
            Integer.parseInt(numberOfAgentsElement.text().split(" ")[0]));
  }

}
