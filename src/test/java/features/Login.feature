@selenium
Feature: Login to the application
  In order to get access to account user have to input correct login and password


  Scenario: Test 1. AutomationPractice login
    Given Store page is opened
      | http://5.196.7.235/ |
    When Brad Pitt type his correct credentials during login
    Then Brad Pitt is logged properly into his account
      | My account |
