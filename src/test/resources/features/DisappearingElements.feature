@DisappearingElements@all
Feature: Disappearing Elements functionality

  Scenario: validate the Disappearing Elements functionality
    Given I navigate to the Disappearing Elements link in the url
    When I click on Home link
    Then I validate home page contents
    #And I navigate to the Disappearing Elements link in the url
    And I click on About and Contact Us and Portfolio link 
    Then I validate the About Page contents

 
