package ru.egorvas.propertyfinder.definitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import ru.egorvas.propertyfinder.CucumberTest;
import ru.egorvas.propertyfinder.general.Helpers;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class VillasSearchDefinitions {
//  private String keyword;

  @When("I search for VILLA to BUY in location THE PEARL with minimum 3BEDS and maximum 7BEDS")
  public void makeSearch(){
    $("div.category-select.pure-u-1-1.pure-u-sm-1-4.pure-push").click();
    $("div.category-select.pure-u-1-1.pure-u-sm-1-4.pure-push").$$("li").
            find(Condition.text("Buy")).click();

    ElementsCollection bedsDropDowns = $(By.id("bedroom_group")).$$(By.className("pure-u-1-2"));
    bedsDropDowns.get(0).click();
    bedsDropDowns.get(0).$$("li").find(Condition.text("3 Beds")).click();
    bedsDropDowns.get(1).click();
    bedsDropDowns.get(1).$$("li").find(Condition.text("7 Beds")).click();

    $("div.search.pure-u-1-1.pure-u-sm-3-4.pure-push > span > input").setValue("The Pearl").submit();
  }

  @And("sort the villas from maximum price to lowest price")
  public void configSort(){
    $("div.sort").$("button.ms-choice").click();
    $("div.sort").$$("li").find(Condition.text("Price (low)")).click();
  }
  
  @Then("I able to fetch all the prices of the listing and save it in a csv file with format : listing title - price")
  public void savingCsv() {
    ElementsCollection options = $(By.id("primary-content")).$$("div.property-content");
    Map<String,String> csvData = new HashMap<String, String>();

    for (SelenideElement element : options){
      csvData.put(element.$("bdi").getText(), element.$("span.val").getText().replace(",",""));
    }
    CucumberTest.addCsvToAllure(Helpers.saveToCSV(csvData, "search_result.csv", "Name", "Price"));

  }

}
