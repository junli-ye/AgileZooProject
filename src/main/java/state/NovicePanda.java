package state;

import adapter.KongFuPandaAdapter;

public class NovicePanda implements PandaState {
	
	@Override
	public void train(KongFuPandaAdapter panda) {
		System.out.println("🐼 " + panda.getName() + " commence son entraînement de Kung Fu !");
		panda.exercise();
		
		if (panda.getHero().getXp() >= 100) { // 访问 hero 的 XP
			panda.setState(new ApprenticePanda()); // 切换状态
			System.out.println("🎉 " + panda.getName() + " est maintenant un apprenti guerrier !");
		}
	}
	
	@Override
	public void fight(KongFuPandaAdapter panda) {
		System.out.println("🚫 " + panda.getName() + " est encore novice et ne peut pas combattre !");
	}
}
