Feature: Villas search and saving to csv

  Scenario: Serch for villa in Pearl with 3-7 beds and save search result to csv

    Given I open browser with http://propertyfinder.qa
    When I search for VILLA to BUY in location THE PEARL with minimum 3BEDS and maximum 7BEDS
    And sort the villas from maximum price to lowest price
    Then I able to fetch all the prices of the listing and save it in a csv file with format : listing title - price