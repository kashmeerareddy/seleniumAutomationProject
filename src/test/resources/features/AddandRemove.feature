@AddandRemove @all
Feature: AddandRemove functionality

  Scenario: validate the AddandRemove functionality
    Given I navigate to the AddandRemove link in the url
    When I click addelement button then delete button should display
    And I click on delete button then delete button should disappear
    Then validate Elemental Selenium link