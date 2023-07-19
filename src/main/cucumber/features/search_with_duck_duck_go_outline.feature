Feature: Search phrase with Duck Duck Go
  Scenario Outline: Successful search phrase with https://duckduckgo.com/
    Given https://duckduckgo.com/ opened in web browser
    When Phrase '<searchPhrase>' entered in search input box
    And Search button clicked
    Then First <count> results contain phrase '<searchPhrase>'
    And Save screenshot
    And Quit driver

    Examples:
      |searchPhrase          |count |
      |Faraon                |5     |
      |w pustyni i w puszczy |3     |
      |pogoda                |1     |