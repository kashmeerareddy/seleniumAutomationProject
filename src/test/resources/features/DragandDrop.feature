@DragandDrop @all
Feature: Drag and Drop functionality

  Scenario: validate the Drag and Drop functionality
    Given I navigate to the Drag and Drop link in the url
    When I drag sourceelement and drop at targetelemnt
    Then validate drag and drop functionality