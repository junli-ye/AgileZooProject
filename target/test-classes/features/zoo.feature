Feature: Manage Pandas in the Zoo

  Scenario: Add a panda to the zoo
    Given an empty zoo
    When I add a panda named "Bao" aged 5 years
    Then the zoo contains 1 panda
