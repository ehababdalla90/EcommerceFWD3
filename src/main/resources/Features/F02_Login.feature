@Runner
Feature: Login|| user could login to the site

  Scenario: user could login with valid data

    Given user navigate to home page
    And user click on login
    When user enter valid "test133@gmail.com" and valid "password"
    And user clicks login button
    Then user logged in successfully

  Scenario: user could login with invalid data

    Given user navigate to home page
    And user click on login
    When user enter valid "test11@ail.com" and valid "613"
    And user clicks login button
    Then user could not login