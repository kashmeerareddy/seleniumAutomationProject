@Checkbox @all
Feature: Checkbox functionality

  Scenario: validate the checkbox functionality
    Given I navigate to the checkbox link in the url
    When checkbox is selected
    And unselect the selected checkbox
    Then validate the checkbox is enable or disable