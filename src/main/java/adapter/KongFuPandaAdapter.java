package adapter;

import hero.Hero;
import hero.Skill;
import state.PandaState;
import zoo.Panda;

import java.util.List;
import java.util.Random;

/**
 * @className: adapter.KongFuPandaAdapter
 * @author: Junli YE, junli.ye@dauphine.eu
 * @description: Adapter Pattern: PandaAdapter combines Panda (from Zoo) and Hero (from Hero system)
 * @date: 20/03/2025 14:14
 */
public class KongFuPandaAdapter extends Panda {
    private Hero hero;
    private boolean kongFuPanda;
    private PandaState state;

    private static final List<String> SKILL_POOL = List.of(
            "Coup de Poing Rapide", "Coup de Pied Tornade", "Esquive de Tigre", "Frappe du Dragon",
            "Saut Acrobate", "Défense de Fer", "Griffes Tranchantes", "Lancer de Bambou",
            "Contre-Attaque", "Charge du Panda", "Méditation", "Blocage de Roche",
            "Aura de Combat", "Frappe Explosive", "Danse du Singe", "Hurlement du Loup",
            "Énergie de Feu", "Plongeon Rapide", "Frappe Fantôme", "Vitesse de l’Éclair"
    );
    
    public Hero getHero() { // 添加 getter 方法
        return this.hero;
    }
    
    public void setState(PandaState state) { // 添加 setState 方法
        this.state = state;
    }
    
    public void train() { // 使用状态模式
        state.train(this);
    }
    
    public void fight() { // 使用状态模式
        state.fight(this);
    }

    public KongFuPandaAdapter(String name, int age) {
        super(name, age);
        this.hero = new Hero(name, 100);
        this.kongFuPanda = false;
    }

    private void addXp(int toAddXp) {
        int currentXp = this.hero.getXp();
        this.hero.setXp(currentXp + toAddXp);
    }

    public void exercise() {
        Random random = new Random();

        // Randomly increase 1-30 points XP
        int gainedXp = random.nextInt(30) + 1;  // Generate random numbers between 1-30
        this.addXp(gainedXp);

        System.out.println(this.getName() + " s'entraîne ! ");
        System.out.println("XP gagné : " + gainedXp + "  (Total XP : " + this.hero.getXp() + ")");

        // 2. Randomly decide whether to acquire a new skill (50% probability)
        if (random.nextBoolean()) {
            String newSkill = SKILL_POOL.get(random.nextInt(SKILL_POOL.size()));
            this.hero.addSkill(new Skill(newSkill, 100));
            System.out.println("Félicitations ! " + this.getName() + " a appris une nouvelle compétence : " + newSkill + " !");
        } else {
            System.out.println("Pas de nouvelle compétence pour cette fois.");
        }

        // 3. Determine if a Kung Fu Panda
        if(this.isKungFuPanda()) {
            this.kongFuPanda = true;
            System.out.println("\uD83C\uDFC6 KONG FU PANDA !");
        }
    }

    private boolean isKungFuPanda() {
        return this.hero.getXp() >= 1000 && this.hero.getSkills().size() >= 10;
    }

    public void intensiveTraining() {
        for(int i = 0; i < 5; i++) {
            exercise();
        }
    }

}
