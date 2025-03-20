package hero;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String name;
    private int xp;
    private List<Skill> skills; // Hero corresponds to multiple Skills : (0.. *)

    public Hero(String name, int xp) {
        this.name = name;
        this.xp = xp;
        this.skills = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public void takeDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Damage cannot be negative.");
        }
        xp -= damage;
    }

    public void addSkill(Skill skill) {
        if (skills.stream().anyMatch(s -> s.getSkillName().equals(skill.getSkillName()))) {
            throw new IllegalArgumentException("Skill " + skill.getSkillName() + " already learned!");
        }
        skills.add(skill);
        skill.setHero(this);
    }

    public void removeSkill(Skill skill) {
        if (skills.contains(skill)) {
            skills.remove(skill);
            skill.setHero(null);
        }
    }

    // Refactoring : extracting the original skill damage calculation into a separate method
    public int castAllSkills() {
        int totalDamage = 0;
        for (Skill skill : skills) {
            totalDamage += calculateSkillDamage(skill);
        }
        return totalDamage;
    }

    private int calculateSkillDamage(Skill skill) {
        return skill.getDamage();
    }

    // Test Infected
    public void levelUp(int increase) {
        if (increase < 0) {
            throw new IllegalArgumentException("Level increase must be positive.");
        }
        xp += increase * 10;
    }
}
