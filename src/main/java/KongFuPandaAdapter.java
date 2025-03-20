import hero.Hero;
import hero.Skill;
import zoo.Panda;

import java.util.List;
import java.util.Random;

/**
 * @className: KongFuPandaAdapter
 * @author: Junli YE, junli.ye@dauphine.eu
 * @description: TODO
 * @date: 20/03/2025 14:14
 */
public class KongFuPandaAdapter extends Hero {
    private final Panda panda;

    private static final List<String> SKILL_POOL = List.of(
            "Coup de Poing Rapide", "Coup de Pied Tornade", "Esquive de Tigre", "Frappe du Dragon",
            "Saut Acrobate", "Défense de Fer", "Griffes Tranchantes", "Lancer de Bambou",
            "Contre-Attaque", "Charge du Panda", "Méditation", "Blocage de Roche",
            "Aura de Combat", "Frappe Explosive", "Danse du Singe", "Hurlement du Loup",
            "Énergie de Feu", "Plongeon Rapide", "Frappe Fantôme", "Vitesse de l’Éclair"
    );

    public KongFuPandaAdapter(Panda panda) {
        super(panda.getName(), 10);
        this.panda = panda;
    }

    public void exercise() {
        Random random = new Random();

        // Randomly increase 1-30 points XP
        int gainedXp = random.nextInt(30) + 1;  // Generate random numbers between 1-30
        this.xp += gainedXp;

        System.out.println(this.getName() + " s'entraîne ! ");
        System.out.println("XP gagné : " + gainedXp + "  (Total XP : " + this.xp + ")");

        // 2. Randomly decide whether to acquire a new skill (50% probability)
        if (random.nextBoolean()) {
            String newSkill = SKILL_POOL.get(random.nextInt(SKILL_POOL.size()));
            skills.add(new Skill(newSkill, 100));
            System.out.println("Félicitations ! " + panda.getName() + " a appris une nouvelle compétence : " + newSkill + " !");
        } else {
            System.out.println("Pas de nouvelle compétence pour cette fois.");
        }
    }

}
