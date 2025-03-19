📌 AgileZooProject
📝 Description
AgileZooProject est un projet de test automatisé utilisant Cucumber et JUnit pour simuler la gestion d’un zoo. Ce projet permet d'ajouter, de suivre et de tester différentes interactions avec des pandas dans un zoo.

📂 Structure du projet
AgileZooProject
│── src
│   ├── main
│   │   ├── java
│   │   │   ├── zoo
│   │   │   │   ├── Zoo.java
│   │   │   │   ├── Pandas.java
│   ├── test
│   │   ├── java
│   │   │   ├── stepDefinitions
│   │   │   │   ├── ZooSteps.java
│   │   │   ├── ZooTest.java
│   │   │   ├── PandasTest.java
│   │   ├── resources
│   │   │   ├── features
│   │   │   │   ├── zoo.feature
│── pom.xml
│── README.md
│── .gitignore

Cloner le projet :

git clone https://github.com/junli-ye/AgileZooProject.git
cd AgileZooProject
Configurer les dépendances avec Maven :
mvn clean install

🚀 Comment exécuter les tests
⚡ Méthode 1 : Depuis IntelliJ
Faites un clic droit sur zoo.feature et sélectionnez "Run Feature".
⚡ Méthode 2 : En ligne de commande
Exécutez Cucumber avec Maven :
mvn test

📌 Auteur
👤 Junli YE
👤 Yingxuan LI
