@Runner
Feature: Registeration|| user could register to the site

Scenario: user could register entering valid data

    Given user navigate to home page
    And user click register
    When user fills gender"male" fname"automation" lname"tester" day"10" month"9" year"1998" email"test133@gmail.com" valid data
    And user fills valid password "password" confirm "password"
    And user clicks register button
    Then success message is displayed