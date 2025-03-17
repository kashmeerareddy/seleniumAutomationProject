
@Exitintent @all
Feature: Exit intent functionality

  Scenario: validate the Exit intent functionality
  Given I navigate to the Exit intent link in the url
   When I move my mouse out of the viewport
    Then verify the exit intent modal window appear
   # When I close the modal window
    #And I move my mouse out of the viewport again
    #Then validate the modal window should not appear