@all
  Feature: add to cart

    @Cart
      Scenario: Add to cart
        Given User is on login and home page
        When fill username and password
        And User click login buttons
        And User click add to cart button
        Then User verify add to cart result
