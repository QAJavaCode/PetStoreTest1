Feature: Placing order
  As PetStore user I should be able to place or an order, get its details by ID and inventory details
  Scenario: Should I be able to order pets
    Given I enter proper ID and quantity
    When I send new request
    Then I should receive proper order data
      Scenario: I try to place an order with an incorrect data
        Given I enter improper ID and quantity
        When I send bad request
        Then I shouldn't receive proper order data
        Scenario: I want to get order details by pet ID
          Given I enter pet ID from 1 to 10
          When I send proper request
          Then I can get proper order data
            Scenario: I want to get order details by pet ID
              Given I enter wrong pet ID
              When I send improper request
              Then I can't get proper order data
              Scenario: I want to delete my order
                Given I enter order ID
                When I send request to the server
                Then Order doesn't exist after it's been deleted
                Scenario: I want to delete my order using wrong parameters
                  Given I enter negative order ID
                  When I send bad request to the server
                  Then Order couldn't be deleted
                  Scenario: I want to get pet inventory data
                    When I send request
                    Then I get the inventory data