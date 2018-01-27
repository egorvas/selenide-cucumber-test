package ru.egorvas.propertyfinder.definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ru.egorvas.propertyfinder.CucumberTest;
import ru.egorvas.propertyfinder.general.Helpers;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AgentProfileDefinitions {
//  private String keyword;


  @And("select first agent")
  public void selectAgent(){
    $$("div.tile-block-container").first().click();
  }

  @Then("capture agent info in a text file")
  public void saveAgentInfoToFile(){
    List<String> agentData = new ArrayList<String>();
    agentData.add("Name: " + $("h1.user-name").text()+"\n");
    agentData.add("Nationality: " + $("div.user-nationality > div.content").text()+"\n");
    agentData.add("Languages: " + $("div.user-language > div.content").text()+"\n");
    agentData.add("License: " + $("div.user-rera-no > div.content").text()+"\n");
    $("button[data-tab='aboutMe']").click();
    agentData.add("About Me: " + $("div.user-tab.user-tab-about-me.active").text()+"\n");
    agentData.add("Phone Number: " + $("a.action-button.call-agent.reveal").getAttribute("data-phone")+"\n");
    agentData.add("Company Name: " + $("div.company-name").text()+"\n");
    agentData.add("Experience: " + $("div.user-experience > div.content").text()+"\n");
    agentData.add("Active Listings: " + $("div.user-active-listing > div.content").text()
            .split(" ")[0]+"\n");
    if ($("div.user-linkedin").exists()){
      agentData.add("Linkedin: " + $("div.user-linkedin > div.content > a").getAttribute("href")+"\n");
    }

    CucumberTest.addTxtToAllure( Helpers.saveToFile(agentData,"agentdata.txt"));
  }

  @When("I change language to Arabic")
  public void changeLangToArabic(){
    $("div.language-wrapper").click();
  }


}
