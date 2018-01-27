Feature: Saving information about agent to file

  Scenario: Open profile of the first agent and save his data to file and make screenshot on English and Arabic langs

    Given I open browser with http://propertyfinder.ae
    When click on FIND AGENTS tab
    And select first agent
    Then capture agent info in a text file
    Then capture screenshot of the page with name FirstScreenshot
    When I change language to Arabic
    Then capture screenshot of the page with name SecondScreenshot