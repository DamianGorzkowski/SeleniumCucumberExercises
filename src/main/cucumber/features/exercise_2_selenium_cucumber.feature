Feature: Resolving the second exercise
  Scenario Outline: Going through the entire purchasing process
    Given https://mystore-testlab.coderslab.pl/index.php opened in Google Chrome v2
    When the user clicks on the Sign in button
    And enters '<Login>' and '<password>' in the login form
    And clicks the SIGN IN button
    And goes back to the Main Page
    And selects the Hummingbird Printed Sweater for purchase
    And checks if there's a 20% discount on it
    And selects size M
    And chooses 5 pieces according to the test parameters
    And adds the product to the shopping cart
    And proceeds to the checkout option
    And confirms the delivery address
    And chooses the pick-up in-store delivery method
    And selects the payment option - Pay by Check
    And clicks on 'order with an obligation to pay'
    And saves a screenshot
    And goes to the order history and details
    And checks if the order is listed with the status 'Awaiting check payment'
    Then verifies if the total amount matches the order placed two steps earlier.
    And Quit Driver


    Examples:
    |Login                     |password  |
    |damiangorzkowski@gmail.com|1234567890|