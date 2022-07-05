@Runner
  Feature: Search|| User could search of products
    Background: user log into system
      Given user navigate to home page
#      And user click on login
#      When user enter valid "test133@gmail.com" and valid "Qwert6613"
#      And user clicks login button
#      Then user logged in successfully

    Scenario Outline: Logged user could search products
      When user click on search field
      And user enter "<search>" to search
      Then user find the product and relative products

      Examples:
      |search|
      |HTC   |
      |Apple |
      |nike  |

    Scenario Outline: Logged user could search products
      When user click on search field
      And user enter "<search>" to search
      Then user find "<search>" product

      Examples:
        |search|
        |SCI_FAITH|
        |APPLE_CAM|
        |SF_PRO_11|
        |AP_MBP_13|



