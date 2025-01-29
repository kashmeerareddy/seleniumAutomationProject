Feature: File download functionality

  Scenario: validate the File download functionaity
    Given I navigate to the File Download link in the url
    When I download a file
    Then validate the downloaded file
