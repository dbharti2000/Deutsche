Feature: Sample

  @ui @pageobject
  Scenario: Should be able to search for a product from the input box
    Given John is viewing the Etsy landing page
    When he searches for a product craft from the input box
    Then the result should contain craft

  @ui @screenplay
  Scenario: Should be able to search for a product from the input box (screenplay)
    Given John is viewing the Etsy landing page (screenplay)
    When he searches for a product from the input box (screenplay)
    Then the result should be displayed (screenplay)

  @ui @pageobject
  Scenario: Should be able to search for a product from the drop-down menu e.g. Hats & Caps or Belts & Braces
    Given John is viewing the Etsy landing page
    When he selects the first menu item
    And he selects the first link from the drop down menu
    Then the result should have link text

  @ui @pageobject
  Scenario: Should be able to search for a product from the icons e.g. Home & Living
    Given John is viewing the Etsy landing page
    When he selects the Home & Living icon
    Then the result should contain Home & Living

  @test @api
  Scenario: GET call to homepage
    Given John is a Etsy customer
    When he makes a GET request to landing page
    Then he should get response code 200
