Feature: Resolving the second exercise
  Scenario Outline: Going through the entire purchasing process
    Given https://mystore-testlab.coderslab.pl/index.php opened in Google Chrome
    And Sign in button clicked
    When '<Login>' and '<password>' entered in log form
    And SIGN IN button clicked
    And Back to Main Page





    Examples:
    |Login                     |password  |
    |damiangorzkowski@gmail.com|1234567890|