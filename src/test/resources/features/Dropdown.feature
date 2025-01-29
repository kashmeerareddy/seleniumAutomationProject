@Dropdown @all
Feature: Dropdown functionality

  # I want to use this template for my feature file
  Scenario: validate the form dropdown functionality
    Given I navigate to the dropdown functionality in the url
    When I click on dropdown and I select a value from the dropdown
    Then I validate if the selected value is populated