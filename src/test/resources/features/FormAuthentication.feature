@formauthentication @all
Feature: Form Authentication functionality

 #Scenario: validate the form authentication functionality
  # Given I navigate to the form authentication link in the url
  # When I click on form authentication and enter username and password
  # Then validate login successful
    
   Scenario Outline: validate the form authentication functionality
    Given I navigate to the form authentication link in the <url>
    When I click on form authentication and enter <username> and <password>
   Then validate login successful
    
    Examples: 
   
  |url                                      | username  | password           | 
  |https://the-internet.herokuapp.com/      |tomsmith   |SuperSecretPassword!|
  |https://the-internet.herokuapp.com/      |smith      |SuperSecretPassword!|
  |https://the-internet.herokuapp.com/      |tomsmith   |Super!              |
  |https://the-internet.herokuapp.com/      |tom        |Secret              |
 
 #Scenario Outline: validate the form authentication functionality
  # Given I navigate to the form authentication link in the url
  #  When I click on form authentication and enter <username> and <password>
   # Then validate login <testresult>
    
   # Examples: 
   
  # | username  | password           | testresult         |
  # |tomsmith   |SuperSecretPassword!|sucessful|
  # |smith      |SuperSecretPassword!|username is incorrect|
  # |tomsmith   |Super!              |password is incorrect|
  # |tom        |Secret              |username is incorrect|