@Hovers @all
Feature: Hovers functionality 

  Scenario: validate the Hovers functionality 
    Given I navigate to the Hovers link in the url
    When I hover over the first user image
    Then I should see the details for the first user
    When I hover over the second user image
    Then I should see the details for the second user
    When I hover over the third user image
    Then I should see the details for the third user