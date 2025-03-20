package state;

import adapter.KongFuPandaAdapter;

public class ApprenticePanda implements PandaState {
	
	@Override
	public void train(KongFuPandaAdapter panda) {
		System.out.println("🥋 " + panda.getName() + " continue son entraînement !");
		panda.exercise();
		
		if (panda.getHero().getXp() >= 1000 && panda.getHero().getSkills().size() >= 10) {
			panda.setState(new MasterPanda());
			System.out.println("🐉 " + panda.getName() + " est devenu un Maître du Kung Fu !");
		}
	}
	
	@Override
	public void fight(KongFuPandaAdapter panda) {
		System.out.println("⚔️ " + panda.getName() + " se bat avec des compétences basiques !");
	}
}
