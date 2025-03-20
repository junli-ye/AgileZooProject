package stepDefinitions;
import com.example.dota2.Hero;
import com.example.dota2.Skill;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class HeroForgetSkillSteps {
    private Hero hero;
    private Skill skill;

    @Given("a hero named {string} with {int} health points and a skill named {string} with {int} damage")
    public void a_hero_named_with_health_points_and_a_skill_named_with_damage(String name, int healthPoints, String skillName, int damage) {
        hero = new Hero(name, healthPoints);
        skill = new Skill(skillName, damage);
        hero.addSkill(skill);
    }

    @When("the hero forgets the skill named {string}")
    public void the_hero_forgets_the_skill_named(String skillName) {
        hero.removeSkill(skill);
    }

    @Then("the hero should not have a skill named {string}")
    public void the_hero_should_not_have_a_skill_named(String expectedSkillName) {
        boolean hasSkill = hero.getSkills().stream()
                .anyMatch(s -> s.getSkillName().equals(expectedSkillName));
        assertFalse(hasSkill, "Hero should not have the skill: " + expectedSkillName);
    }
}
