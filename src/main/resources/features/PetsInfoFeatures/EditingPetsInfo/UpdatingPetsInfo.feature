Feature: Updating pets information
  As PetStore user I should be able to successfully update pets information
  Scenario: Should I be able to upload new photo
    Given I want to add new pet photos
    When I add pet photo by sending its unique ID, photos and additional data
    Then Pet photo should be successfully updated
      Scenario: I shouldn't be able to upload incorrect photo
        Given I want to add new incorrect pet photo
        When I try to add pet photo by sending incorrect files
        Then Pet photo shouldn't be successfully updated
        Scenario: I want to change pet details
          Given I send new info
          When It should be correctly applied
          Then Pets information should correspond to the latest updates
            Scenario: I want to change pet details with negative details
            Given I send new incorrect info
            When It shouldn't be correctly applied
            Then Pets information should remain the same
              Scenario: Update pet store info with form data
                Given I should update pet store info with correct data
                When I send request containing proper data
                Then I can update pet store info
                  Scenario: Update pet store info with invalid form data
                    Given I should update pet store info with incorrect data
                    When I send request containing invalid data
                    Then I can't update pet store info
                    Scenario: I should be able to delete specific pet
                      Given I want to delete the pet
                      When I send request with proper data to delete the pet from store
                      Then Pet should be deleted and couldn't be searched by its ID