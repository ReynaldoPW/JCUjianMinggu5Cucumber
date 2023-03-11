Feature: test shop demoQA
    Scenario: Login with valid credentials
    Given User is on the login page
    When User enters valid credentials
    And User clicks login button
    Then User should be redirected to the home page

    Scenario: Checkout 1 product - Place Order
        When user searches for a product
        And user adds the product to the cart
        And user proceeds to checkout
        And user fills in the checkout form
        And user clicks place order button
        Then user should see a confirmation message


