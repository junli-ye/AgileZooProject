package kungfu;

public class NovicePanda implements PandaState {
	@Override
	public void train(KongFuPandaAdapter panda) {
		System.out.println( panda.getName() + " c'est un panda ordinaire, qui ne fait rien.");
	}
	
	@Override
	public void fight(KongFuPandaAdapter panda) {
		System.out.println(panda.getName() + " est un panda normal, qui ne peut pas se battre !");
	}
}
