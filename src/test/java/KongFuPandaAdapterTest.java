import hero.Skill;
import kungfu.KongFuPandaAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KongFuPandaAdapterTest {

    private KongFuPandaAdapter panda;

    @BeforeEach
    void setUp() {
        System.out.println("BeforeEach is running...");
        // Default mock: XP +10, always learn skill
        panda = new KongFuPandaAdapter("Po", 5, getFixedRandom(9, true));
    }

    private Random getFixedRandom(int xpValue, boolean learnSkill) {
        return new Random() {
            private int skillIndex = 0; // optional for skills
            @Override
            public int nextInt(int bound) {
                if (bound == 30) {
                    return xpValue; // XP increase = xpValue + 1
                } else {
                    return skillIndex++ % bound; // Avoid same skill each time
                }
            }

            @Override
            public boolean nextBoolean() {
                return learnSkill;
            }
        };
    }

    @Test
    void shouldCreateKongFuPandaAdapterCorrectly() {
        assertEquals("Po", panda.getName());
        assertEquals(5, panda.getAge());
        assertEquals(100, panda.getHeroXp());
        assertTrue(panda.getHeroSkills().isEmpty());
    }

    @Test
    void shouldIncreaseXpAndLearnSkillWhenExercise() {
        int initialXp = panda.getHeroXp();
        int initialSkillCount = panda.getHeroSkills().size();

        panda.exercise();

        assertEquals(initialXp + 10, panda.getHeroXp()); // XP +10
        assertEquals(initialSkillCount + 1, panda.getHeroSkills().size());
        assertEquals("Coup de Poing Rapide", panda.getHeroSkills().get(0).getName());
    }

    @Test
    void shouldNotLearnSkillWhenRandomBooleanIsFalse() {
        // Mock: XP +5, do not learn skill
        panda = new KongFuPandaAdapter("Li", 3, getFixedRandom(4, false));

        int initialXp = panda.getHeroXp();

        panda.exercise();

        assertEquals(initialXp + 5, panda.getHeroXp());
        assertEquals(0, panda.getHeroSkills().size());
    }

    @Test
    void shouldBecomeKungFuPanda() {
        // Add 9 skills
        for (int i = 1; i <= 10; i++) {
            panda.getHeroSkills().add(new Skill("Skill" + i, 100));
        }

        // Mock: XP +30, always learn skill
        panda = new KongFuPandaAdapter("Po", 5, getFixedRandom(29, true));

        // Increase XP to >=970
        while (panda.getHeroXp() < 970) {
            panda.exercise();
        }

        // One more exercise to reach 1000 XP & 10+ skills
        panda.exercise();

        assertTrue(panda.getHeroXp() >= 1000);
        assertTrue(panda.getHeroSkills().size() >= 10);
    }

    @Test
    void shouldNotBecomeKungFuPandaIfXpOrSkillsNotEnough() {
        // Mock: XP +1, do not learn skill
        panda = new KongFuPandaAdapter("Po", 5, getFixedRandom(0, false));

        while (panda.getHeroXp() < 999) {
            panda.exercise();
        }

        // Add 10 skills
        for (int i = 0; i < 10; i++) {
            panda.getHeroSkills().add(new Skill("Skill" + i, 100));
        }

        assertTrue(panda.getHeroXp() < 1000);
        assertTrue(panda.getHeroSkills().size() >= 10);
    }

    @Test
    void shouldPerformIntensiveTraining() {
        int initialXp = panda.getHeroXp();
        int initialSkillCount = panda.getHeroSkills().size();

        panda.intensiveTraining();

        assertEquals(initialXp + 50, panda.getHeroXp()); // +10 XP ×5
        assertEquals(initialSkillCount + 5, panda.getHeroSkills().size());
    }

    @Test
    void shouldHandleMultipleXpValues() {
        // Mock: XP increases {1,6,16,30}, no skill learning
        Random multiRandom = new Random() {
            private int[] xpValues = {0, 5, 15, 29};
            private int index = 0;

            @Override
            public int nextInt(int bound) {
                return xpValues[index++];
            }

            @Override
            public boolean nextBoolean() {
                return false;
            }
        };

        KongFuPandaAdapter panda = new KongFuPandaAdapter("Mei", 4, multiRandom);
        int xp = panda.getHeroXp();

        for (int i = 0; i < 4; i++) {
            panda.exercise();
            assertEquals(xp + (i == 0 ? 1 : (i == 1 ? 6 : (i == 2 ? 16 : 30))), panda.getHeroXp());
            xp = panda.getHeroXp();
        }
    }
}