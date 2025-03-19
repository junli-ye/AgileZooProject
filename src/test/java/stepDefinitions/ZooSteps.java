package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import zoo.Zoo;
import zoo.Pandas;

public class ZooSteps {
	private Zoo zoo;
	private Pandas panda;
	
	@Given("an empty zoo")
	public void an_empty_zoo() {
		zoo = new Zoo("Dauphine Zoo");
	}
	
	@When("I add a panda named {string} aged {int} years")
	public void i_add_a_panda_named_aged_years(String name, int age) {
		panda = new Pandas(name, age);
		zoo.registerPanda(panda);
	}
	
	@Then("the zoo contains {int} panda")
	public void the_zoo_contains_panda(int count) {
		Assertions.assertEquals(count, zoo.getPandaList().size());
	}
}
