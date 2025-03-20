package zoo;

public class Skill {
    private String skillName;
    private int damage;
    private Hero hero; //Skill ⟶ Hero (0..1)

    public Skill(String skillName, int damage) {
        this.skillName = skillName;
        this.damage = damage;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
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
