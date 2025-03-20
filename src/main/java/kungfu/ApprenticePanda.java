package kungfu;

public class ApprenticePanda implements PandaState {
	@Override
	public void train(KongFuPandaAdapter panda) {
		System.out.println(panda.getName() + " Continuez à pratiquer le kung-fu !");
		panda.exercise();
		
		if (panda.getHero().getXp() >= 1000 && panda.getHero().getSkills().size() >= 10) {
			panda.setState(new MasterPanda());
			System.out.println(panda.getName() + " Enfin un Kung Fu Panda !");
		}
	}
	
	@Override
	public void fight(KongFuPandaAdapter panda) {
		System.out.println(panda.getName() + " Encore un apprenti, il ne peut pas se battre !");
	}
}
