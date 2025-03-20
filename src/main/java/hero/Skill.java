package hero;

public class Skill {
    private String name;
    private int damage;
    private Hero hero; //Skill ⟶ Hero (0..1)

    public Skill(String skillName, int damage) {
        this.name = skillName;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
