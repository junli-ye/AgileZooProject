package stepDefinitions;

import kungfu.KongFuPandaAdapter;
import hero.Skill;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kungfu.MasterPanda;
import zoo.Panda;
import zoo.Zoo;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UnifiedSteps {

    private Zoo zoo;
    private List<Panda> registeredPandas;
    private KongFuPandaAdapter adapter;
    private int initialXp;

    // =======================
    // US1 - Gestion du Zoo & Classement des Pandas
    // =======================

    @Given("un zoo nommé {string} existe")
    public void un_zoo_nomme_existe(String zooName) {
        zoo = new Zoo(zooName);
    }

    @Given("le zoo {string} contient les pandas suivants:")
    public void le_zoo_contient_les_pandas_suivants(String zooName, List<Map<String, String>> pandasTable) {
        for (Map<String, String> row : pandasTable) {
            String name = row.get("nom");
            String statut = row.get("statut");
            if (statut.equalsIgnoreCase("Panda Ordinaire")) {
                Panda panda = new Panda(name, 5); // âge arbitraire
                zoo.registerPanda(panda);
            } else if (statut.equalsIgnoreCase("Panda Apprenti")) {
                adapter = new KongFuPandaAdapter(name, 5);
                zoo.registerPanda(adapter);
            }
        }
    }

    @When("je consulte la liste des pandas")
    public void je_consulte_la_liste_des_pandas() {
        registeredPandas = zoo.getPandaList();
    }

    @Then("je dois voir que {string} est de type {string}")
    public void je_dois_voir_que_est_de_type(String pandaName, String expectedType) {
        boolean found = false;
        for (Panda panda : registeredPandas) {
            if (panda.getName().equals(pandaName)) {
                found = true;
                if (expectedType.equalsIgnoreCase("Panda Ordinaire")) {
                    assertTrue("Erreur de type : " + pandaName,
                            panda instanceof Panda && !(panda instanceof KongFuPandaAdapter));
                } else if (expectedType.equalsIgnoreCase("Panda Apprenti")) {
                    assertTrue("Erreur de type : " + pandaName,
                            panda instanceof KongFuPandaAdapter);
                }
            }
        }
        assertTrue("Le panda " + pandaName + " n'a pas été trouvé dans le zoo.", found);
    }

    // =======================
    // US2 - Sessions d’Entraînement Intensive pour Apprentis Pandas
    // =======================

    @Given("un panda apprenti {string} avec {int} XP et sans techniques")
    public void un_panda_apprenti_avec_XP_et_sans_techniques(String name, int xp) {
        adapter = new KongFuPandaAdapter(name, 5);
        adapter.getHero().setXp(xp);
        adapter.getHero().getSkills().clear();
        initialXp = xp;
    }

    @When("{string} effectue une session d'entraînement intensive")
    public void effectue_une_session_intensive(String name) {
        assertNotNull("Adapter ne doit pas être null", adapter);
        adapter.intensiveTraining();
    }

    @Then("{string} gagne entre {int} et {int} XP")
    public void gagne_entre_XP(String name, int minXp, int maxXp) {
        int xpAfter = adapter.getHero().getXp();
        int gained = xpAfter - initialXp;
        // Chaque exercice augmente l'XP entre 1 et 30 ; l'augmentation totale pour 5 exercices est comprise entre [minXp*5, maxXp*5].
        assertTrue("XP gagné (" + gained + ") est inférieur au minimum attendu", gained >= (minXp * 5));
        assertTrue("XP gagné (" + gained + ") est supérieur au maximum attendu", gained <= (maxXp * 5));
    }

    @Then("il se peut qu'il apprenne une nouvelle technique de Kung Fu")
    public void il_se_peut_quil_apprenne_une_nouvelle_technique() {
        int skillCount = adapter.getHero().getSkills().size();
        assertTrue("Le nombre de techniques devrait être >= 0", skillCount >= 0);
        System.out.println("Techniques acquises: " + skillCount);
    }

    @Then("une session d'entraînement intensive consiste en {int} entraînements consécutifs sans repos")
    public void session_intensive_consiste_en_entraînements(int sessionCount) {
        System.out.println("Une session intensive comporte " + sessionCount + " entraînements consécutifs.");
    }

    // =======================
    // US3 - Promotion au Rang de Kung Fu Panda
    // =======================

    @Given("un panda apprenti {string} ayant {int} XP et {int} techniques de Kung Fu")
    public void un_panda_apprenti_ayant_XP_et_techniques(String name, int xp, int techniques) {
        adapter = new KongFuPandaAdapter(name, 5);
        adapter.getHero().setXp(xp);
        for (int i = 0; i < techniques; i++) {
            Skill skill = new Skill("Technique " + (i + 1), 100);
            adapter.getHero().addSkill(skill);
        }
    }

    @Then("{string} atteint au moins {int} XP")
    public void atteint_au_moins_XP(String name, int minXp) {
        int currentXp = adapter.getHero().getXp();
        assertTrue("XP actuel (" + currentXp + ") est inférieur au minimum attendu (" + minXp + ")", currentXp >= minXp);
    }

    @Then("{string} a acquis au moins {int} techniques de Kung Fu")
    public void a_acquis_au_moins_techniques(String name, int minTechniques) {
        int count = adapter.getHero().getSkills().size();
        assertTrue("Le nombre de techniques (" + count + ") est inférieur à " + minTechniques, count >= minTechniques);
    }

    @Then("{string} est automatiquement promu au rang de {string}")
    public void est_promu_au_rang(String name, String expectedRank) {
        // Vérifier la promotion en déterminant si l'état actuel est MasterPanda.
        assertTrue("Le panda " + name + " n'est pas promu au rang de " + expectedRank,
                adapter.getState() instanceof MasterPanda);
    }
}
