@Digestauthentication @all
Feature: Digest Authentication functionality

  Scenario: validate the digest authentication functionality
    Given I navigate to the digest authentication link in the url
    When I click on digest authentication and enter username and password and signin
    Then validate digest auth