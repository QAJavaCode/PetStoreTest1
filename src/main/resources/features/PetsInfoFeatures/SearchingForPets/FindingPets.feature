Feature: Finding proper pets
  As PetStore user I should be able to find pets by status
  Scenario: Should I be able to find pets by status
    Given I start searching pets by status
    When I enter correct statuses
    Then Pet I found have proper status
    Scenario: I try to search pets by incorrect status parameters
      Given I start searching pets by incorrect status
      When I enter incorrect statuses
      Then Server should respond with an error
      Scenario: I should be able to find pets by correct IDs
        Given I start searching pets by correct IDs
        When I enter correct ID and send request
        Then Proper pet should be found
        Scenario: I try to search pets by incorrect IDs
          Given I start searching pets by incorrect IDs
          When I enter incorrect ID and send request
          Then Pet shouldn't be found