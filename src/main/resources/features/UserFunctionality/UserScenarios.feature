Feature: Creating, editing and deleting user
  As PetStore client I should be able to create user/users, delete ones
  Scenario: Should I be able to create a user
    Given I enter proper data
    When I send new POST request
    Then I should have new user created
    Scenario I try to create user with wrong params
      Given I enter incorrect data
      When I send a request
      Then The user shouldn't be created
      Scenario: I should be able to successfully update user info
        When I try to send new info
        Then It should change user info
        Scenario: I should be able to search for user by username
          When I try to find user by username
          Then I should get user info
          Scenario: I should be able to add users via array or list
            When I try to create lists with array/list
            Then Users should be created
            Scenario: As user I should be able to login
              When I send username and password
              Then I should be successfully logged in
              Scenario: User should be successfully deleted if there's a need
                When I send username to delete user
                Then User should be successfully deleted
                Scenario: There should be a server error after trying to delete user with incorrect request parameters
                  When I send incorrect username to delete the user
                  Then There should be an error