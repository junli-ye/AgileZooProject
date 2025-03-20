package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import hero.Hero;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroSteps {
    private Hero hero;

    @Given("a hero named {string} with {int} health points")
    public void a_hero_named_with_health_points(String name, int healthPoints) {
        hero = new Hero(name, healthPoints);
    }

    @When("the hero takes {int} damage")
    public void the_hero_takes_damage(int damage) {
        hero.takeDamage(damage);
    }

    @Then("the hero's health should be {int}")
    public void the_hero_s_health_should_be(int expectedHealth) {
        assertEquals(expectedHealth, hero.getHealthPoints());
    }
}
