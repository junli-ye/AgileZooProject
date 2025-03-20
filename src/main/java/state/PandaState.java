package state;
import adapter.KongFuPandaAdapter;
public interface PandaState {
	void train(KongFuPandaAdapter panda);
	void fight(KongFuPandaAdapter panda);
}