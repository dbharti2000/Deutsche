Feature: Register a new user

  @ui @pageobject @Search
  Scenario: Register a new user for ETSY website
    Given user is at Etsy homepage
    When user submits the registration form
    Then user should get registration confirmation message