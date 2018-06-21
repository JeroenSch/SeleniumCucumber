Feature: Search for cheese on Gooogle

  Scenario: Search cheese in Firefox
    Given The website of "google.be" is opened in Firefox
    When enter "Cheese" in the search bar
    Then the title of the page should say "Cheese - Google zoeken"
    And close the website

  Scenario: Search cheese in Chrome
    Given The website of "google.be" is opened in Chrome
    When enter "Cheese" in the search bar
    Then the title of the page should say "Cheese - Google zoeken"
    And close the website