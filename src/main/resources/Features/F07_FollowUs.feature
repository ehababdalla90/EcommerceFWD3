Feature: F07_FollowUS
Background:
  Given user navigate to home page
    Scenario: click on facebook link
      When user open facebook link
      And Open the second tab
    Scenario: click on twitter link
      When user open twitter link
      And Open the twitter tab

  Scenario: click on rss link
    When user open rss link
    And Open the rss tab

  Scenario: click on youtube link
    When user open youtube link
    And Open the youtube tab
