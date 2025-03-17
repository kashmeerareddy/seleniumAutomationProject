
@HorizontalSlider @all
Feature: Horizontal Slider functionality 

  Scenario: validate the horizontal slider functionality
    Given I navigate to the Horizontal Slider link in the url
    When I move the slider to the right
    Then validate the value change to a number greater than 0