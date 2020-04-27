@selenium
Feature: Purchase order process
  User want to buy man's Tshirt

  @selenium
  Scenario: Test 1. Purchase men's Tshirt
    Given Store page is opened
      | http://5.196.7.235/ |
    When Brad Pitt select men's TShirt
    And Brad Pitt proceed to checkout
    And Brad Pitt type his correct credentials during purchase
    And Brad Pitt fill Address, City, State, Zip Code, Country
      | Beverly Hills |
      | Los Angeles   |
      | California    |
      | 21222         |
      | United States |
    And Brad Pitt select shipping method
    And Brad Pitt select payment method
    Then Brad Pitt is able to see order confirmation
    And Brad Pitt is able to see correct total price
      | $26.12 |