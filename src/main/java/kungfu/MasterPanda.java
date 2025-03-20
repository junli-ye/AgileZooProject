package kungfu;

public class MasterPanda implements PandaState {
	
	@Override
	public void train(KongFuPandaAdapter panda) {
		System.out.println(panda.getName() + " effectue une formation de maître !");
		panda.exercise();
	}
	
	@Override
	public void fight(KongFuPandaAdapter panda) {
		System.out.println(panda.getName() + " combat avec une puissance incroyable !");
	}
}
