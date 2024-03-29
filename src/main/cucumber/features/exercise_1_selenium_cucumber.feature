Feature: Resolving first exercise
  Scenario Outline: Successfully added address to account on website https://mystore-testlab.coderslab.pl/index.php and deleted
    Given https://mystore-testlab.coderslab.pl/index.php opened in Google Chrome
    And Sign in button clicked
    When '<Login>' and '<password>' entered in log form
    And SIGN IN button clicked
    And Tile Addresses clicked in the bottom menu
    And Create new address button clicked
    And New address form filled with '<Alias>' '<Address>' '<City>' '<Zip postal code>' '<Country>' '<Phone>'
    And Save button clicked
    Then Will check if the data in the added address is correct.
    And Will take screenshot of added address
    And The above address is deleted
    And Will check if the address has been deleted
    And Quit Driver for better performance

    Examples:
    |Alias|Address    |City     |Zip postal code|Country|Phone    |Login                     |password  |
    |Dom  |Bobrowiecka|Warszawa |02-340         |Poland |506506506|damiangorzkowski@gmail.com|1234567890|

