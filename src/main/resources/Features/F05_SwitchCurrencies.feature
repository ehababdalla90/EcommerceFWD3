@Runner
  Feature: Switch Currency|| user could switch between currencies

    Background: user could login with valid data
      Given user navigate to home page
#      And user click on login
#      When user enter valid "test133@gmail.com" and valid "Qwert6613"
#      And user clicks login button
#      Then user logged in successfully

    Scenario: logged user could switch between currencies
      When user choose Euro from dropdown menu
      Then euro is selected successfully
      When user choose USD from dropdown menu
      Then usd is selected successfully

