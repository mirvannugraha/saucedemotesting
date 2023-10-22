@all
Feature: logout

  @Logout
  Scenario: Logout
    Given User is on login and home pages
    When User fills username and password
    And User click Login button
    And User click navigation
    Then User click logout button
