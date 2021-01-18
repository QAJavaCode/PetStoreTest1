Feature: Adding Pets
  As PetStore user I should be able to successfully add pets to the catalog
  Scenario: Should I be able to add new pet
    Given I want to add new pet by sending relevant info
    When I add pet by sending its unique ID, name, photos and status in request body
    Then Pet should be successfully added to the pet store
    Scenario: As PetStore user I shouldn't be able to add pets to the catalog using incorrect params
      Given I want to add new pet by sending irrelevant info
      When I add pet by sending its wrong ID, name, photos and status in request body
      Then Pet shouldn't be successfully added to the pet store