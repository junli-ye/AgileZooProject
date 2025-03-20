import hero.Hero;
import hero.Skill;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SkillTest {
    private Skill skill;

    @BeforeEach
    public void setup() {
        skill = new Skill("Death Pulse", 120);
    }

    @Test
    public void testSkillInitialization() {
        assertEquals("Death Pulse", skill.getSkillName());
        assertEquals(120, skill.getDamage());
        assertNull(skill.getHero());
    }

    @Test
    public void testSetHero() {
        Hero hero = new Hero("Invoker", 100);
        skill.setHero(hero);
        assertEquals(hero, skill.getHero());
    }

    @Test
    public void testSetHeroNull() {
        skill.setHero(null);
        assertNull(skill.getHero());
    }
}
