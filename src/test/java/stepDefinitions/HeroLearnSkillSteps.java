package stepDefinitions;

import com.example.dota2.Hero;
import com.example.dota2.Skill;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.*;

public class HeroLearnSkillSteps {
    private Hero hero;
    private Exception caughtException;

    @Given("a hero named {string} with {int} health points and no skills")
    public void a_hero_named_with_health_points_and_no_skills(String name, int healthPoints) {
        hero = new Hero(name, healthPoints);
    }

    @When("the hero learns a skill named {string} with {int} damage")
    public void the_hero_learns_a_skill_named_with_damage(String skillName, int damage) {
        Skill skill = new Skill(skillName, damage);
        hero.addSkill(skill);
    }

    @Then("the hero should have a skill named {string}")
    public void the_hero_should_have_a_skill_named(String expectedSkillName) {
        boolean hasSkill = hero.getSkills().stream()
                .anyMatch(skill -> skill.getSkillName().equals(expectedSkillName));
        assertTrue(hasSkill, "Hero should have the skill: " + expectedSkillName);
    }

    @When("the hero learns a skill named {string} with {int} damage again")
    public void the_hero_learns_a_skill_named_with_damage_again(String skillName, int damage) {
        try {
            Skill skill = new Skill(skillName, damage);
            hero.addSkill(skill);
        } catch (Exception e) {
            caughtException = e;
        }
    }

    @Then("an error should be thrown with message {string}")
    public void an_error_should_be_thrown_with_message(String expectedMessage) {
        assertNotNull(caughtException, "Expected an exception but none was thrown.");
        assertEquals(expectedMessage, caughtException.getMessage());
    }
}
