@all
Feature: checkout

  @Checkout
  Scenario: Checkout item
    Given User is on login & home page
    When User Fill username and password
    And User Click login button
    Then User Verify login result
    When User Click add to cart button
    Then User click cart
    When User click checkout button
    And User fill first name, last name and postal code
    And User click continue button
    And User click finish button
    Then User verify checkout result
