Feature: Gestion du Zoo Dauphine
  Afin de gérer et former les pandas,
  En tant que directeur suprême du zoo,
  Je souhaite classifier mes pandas, organiser des entraînements intensifs,
  Et promouvoir automatiquement ceux qui atteignent le rang de Kung Fu Panda.

  # =======================
  # US1 - Gestion du Zoo & Classement des Pandas
  # =======================
  Scenario: Affichage de la liste des pandas
    Given un zoo nommé "Zoo Dauphine" existe
    And le zoo "Zoo Dauphine" contient les pandas suivants:
      | nom    | statut           |
      | Panda1 | Panda Ordinaire  |
      | Panda2 | Panda Apprenti   |
    When je consulte la liste des pandas
    Then je dois voir que "Panda1" est de type "Panda Ordinaire"
    And je dois voir que "Panda2" est de type "Panda Apprenti"

  # =======================
  # US2 - Sessions d’Entraînement Intensive pour Apprentis Pandas
  # =======================
  Scenario: Session d’entraînement intensive pour un panda apprenti
    Given un panda apprenti "Po" avec 0 XP et sans techniques
    When "Po" effectue une session d'entraînement intensive
    Then "Po" gagne entre 1 et 30 XP
    And il se peut qu'il apprenne une nouvelle technique de Kung Fu
    And une session d'entraînement intensive consiste en 5 entraînements consécutifs sans repos
