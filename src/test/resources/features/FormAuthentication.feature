@formauthentication @all
Feature: Form Authentication functionality

  Scenario: validate the form authentication functionality
    Given I navigate to the form authentication link in the url
    When I click on form authentication and enter username and password
    Then validate login successful