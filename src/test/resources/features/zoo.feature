Feature: Gestion du Zoo

  Scenario: Ajouter un panda au zoo
    Given un zoo vide
    When j'ajoute un panda nommé "Chutian"
    Then le zoo contient 1 panda
