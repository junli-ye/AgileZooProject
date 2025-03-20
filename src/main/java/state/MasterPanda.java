package state;

import adapter.KongFuPandaAdapter;

public class MasterPanda implements PandaState {
	
	@Override
	public void train(KongFuPandaAdapter panda) {
		System.out.println("🐉 " + panda.getName() + " est déjà un Maître du Kung Fu et n'a plus besoin d'entraînement !");
	}
	
	@Override
	public void fight(KongFuPandaAdapter panda) {
		System.out.println("🔥 " + panda.getName() + " combat avec une puissance incroyable !");
	}
}
