import kungfu.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class PandaStateTest {
    private KongFuPandaAdapter panda;

    @BeforeEach
    void setUp() {
        System.out.println("BeforeEach is running...");
        // XP +30, always learn skill
        panda = new KongFuPandaAdapter("Po", 5, getFixedRandom(29, true));
        panda.setState(new ApprenticePanda());
    }

    // Mock Random: control XP and skill learning
    private Random getFixedRandom(int xpValue, boolean learnSkill) {
        return new Random() {
            private int skillIndex = 0;
            @Override
            public int nextInt(int bound) {
                if (bound == 30) {
                    return xpValue;
                } else {
                    return skillIndex++ % bound;
                }
            }

            @Override
            public boolean nextBoolean() {
                return learnSkill;
            }
        };
    }

    @Test
    void testApprenticePandaWithoutUpgrade() {
        for (int i = 0; i < 5; i++) {
            panda.exercise();
        }

        assertInstanceOf(ApprenticePanda.class, panda.getState());
        assertTrue(panda.getHeroXp() < 1000);
        assertTrue(panda.getHeroSkills().size() < 10);
    }

    @Test
    void testApprenticePandaWithUpgrade() {
        // Quick training
        while (panda.getHeroXp() < 970) {
            panda.exercise();
        }

        while (panda.getHeroSkills().size() < 9) {
            panda.exercise();
        }

        // One more training to upgrade
        panda.exercise();

        assertInstanceOf(MasterPanda.class, panda.getState());
        assertTrue(panda.getHeroXp() >= 1000);
        assertTrue(panda.getHeroSkills().size() >= 10);
    }

    @Test
    void testMasterPandaBehavior() {
        panda.setState(new MasterPanda());

        int initialXp = panda.getHeroXp();
        int initialSkillCount = panda.getHeroSkills().size();

        panda.exercise();

        assertInstanceOf(MasterPanda.class, panda.getState());
        assertTrue(panda.getHeroXp() > initialXp);
        assertTrue(panda.getHeroSkills().size() > initialSkillCount);
    }
}
