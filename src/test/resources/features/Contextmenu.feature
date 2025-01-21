@Contextmenu @all
Feature: Context Menu functionality

  Scenario: validate the Context Menu functionality
    Given I navigate to the context menu link in the url
    When I click on context menu box 
    Then validate the alert