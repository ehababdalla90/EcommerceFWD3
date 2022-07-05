@Runner
Feature: Forgot Password|| User could reset his password

  Scenario: user could reset his password
    Given user navigate to home page
    And user click on forgot password
    And user enter his "test133@gmail.com"
    And user click on recovery
    Then email is sent to the user