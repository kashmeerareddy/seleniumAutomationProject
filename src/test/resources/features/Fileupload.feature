@Fileupload @all
Feature: File download functionality

  Scenario: validate the File upload functionaity
    Given I navigate to the File upload link in the url
    When I click on choose file
    And I upload a file
    Then validate the file upload is successful
   
