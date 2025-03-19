package stepDefinitions;

@Given
public class ZooSteps {
	private Zoo zoo;
	private Pandas panda;
	
	@Given("un zoo vide")
	public void un_zoo_vide() {
		zoo = new Zoo("Zoo de Dauphine");
	}
	
	@When("j'ajoute un panda nommé {string} âgé de {int} ans")
	public void j_ajoute_un_panda_nomme_age_de(String name, int age) {
		panda = new Pandas(name, age);
		zoo.ajouterPanda(panda);
	}
	
	@Then("le zoo contient {int} panda(s)")
	public void le_zoo_contient_panda(int nombre) {
		Assertions.assertEquals(nombre, zoo.getNombreDePandas());
	}
	
	@When("je nourris tous les pandas")
	public void je_nourris_tous_les_pandas() {
		for (Pandas p : zoo.getPandaList()) {
			p.eat();
		}
	}
	
	@Then("tous les pandas sont nourris")
	public void tous_les_pandas_sont_nourris() {
		for (Pandas p : zoo.getPandaList()) {
			System.out.println(p.getName() + " a été nourri.");
		}
	}
}
