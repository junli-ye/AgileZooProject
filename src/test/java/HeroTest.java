import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import hero.Hero;
import static org.junit.jupiter.api.Assertions.*;
public class HeroTest {
    private Hero hero;

    @BeforeEach
    public void setup() {
        hero = new Hero("NEC", 100);
    }

    // Basic test : Constructor + getters
    @Test
    public void testHeroInitialization() {
        assertEquals("NEC", hero.getName());
        assertEquals(100, hero.getXp());
        assertTrue(hero.getSkills().isEmpty());
    }

    // takeDamage
    @Test
    public void testTakeDamageValid() {
        hero.takeDamage(30);
        hero.takeDamage(20);
        assertEquals(50, hero.getXp());
    }

    // takeDamage boundary value test: error with negative number
    @Test
    public void testTakeDamageNegativeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> hero.takeDamage(-10));
    }

    // levelUp
    @Test
    public void testLevelUp() {
        hero.levelUp(3);
        assertEquals(130, hero.getXp());
    }

    // levelUp boundary value test: error with negative number
    @Test
    public void testLevelUpNegativeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> hero.levelUp(-1));
    }
}
