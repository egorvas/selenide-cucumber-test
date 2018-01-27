Feature: Veryfing search for agents

  Scenario: Comparing number of agents with number of agents from India

    Given I open browser with http://propertyfinder.ae
    When click on FIND AGENTS tab
    And filter agents who can speak "HINDI, ENGLISH, ARABIC"
    And click on Search
    Then compare number agents with number and number agents from India
