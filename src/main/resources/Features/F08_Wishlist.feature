Feature: F08_Wishlist
  Scenario: User could add products to the wishlist
    Given user navigate to home page
    When Click on wishlist button
    And AssertSuccessMessage
    And Get RGBA value

    Scenario: User could add products to the wishlist (implicit wait)
      Given user navigate to home page
      When Click on wishlist button
      And Click on wishlist button in main bar
      Then Check the QTY in wishlist is greater than 0