Feature: Resolving the second exercise
  Scenario Outline: Going through the entire purchasing process
    Given https://mystore-testlab.coderslab.pl/index.php opened in Google Chrome
    And Sign in button clicked
    When '<Login>' and '<password>' entered in log form
    And SIGN IN button clicked
    And Back to Main Page
    And Choose the Hummingbird Printed Sweater for purchase
    And Check if there's a 20% discount on it
    And Select size M
    And Choose 5 pieces according to the parameter given in the test
    Then Add the product to the shopping cart.
    And Proceed to the checkout option.
    And Confirm the address
    And Choose the pick-up in-store method for delivery
    And Select the payment option - Pay by Check
    And Click on 'order with an obligation to pay.'
    And Save screenshot
    And Go to the order history and details
    And Check if the order is on the list with the status 'Awaiting check payment,'
    And the amount is the same as in the order two steps earlier."





    Examples:
    |Login                     |password  |
    |damiangorzkowski@gmail.com|1234567890|