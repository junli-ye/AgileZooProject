package hero;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String name;
    private int healthPoints; // Rename: `health` to `healthPoints` to improve readability
    private List<Skill> skills; // Hero corresponds to multiple Skills : (0.. *)

    public Hero(String name, int healthPoints) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.skills = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
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
        healthPoints -= damage;
    }

    public void addSkill(Skill skill) {
        // 避免重复学习技能
        if (skills.stream().anyMatch(s -> s.getSkillName().equals(skill.getSkillName()))) {
            throw new IllegalArgumentException("Skill " + skill.getSkillName() + " already learned!");
        }
        skills.add(skill);
        skill.setHero(this); //维护双向关系
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
        healthPoints += increase * 10;
    }
}
