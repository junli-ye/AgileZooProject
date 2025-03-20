import zoo.Hero;
import zoo.Skill;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HeroSkillTest {
    private Hero hero;
    private Skill skill1;
    private Skill skill2;

    @BeforeEach
    public void setup() {
        hero = new Hero("NEC", 522);
        skill1 = new Skill("Death Pulse", 125);
        skill2 = new Skill("Reaper's Scythe", 300);
    }

    @Test
    public void testAddSkillBidirectional() {
        hero.addSkill(skill1);
        assertEquals(hero, skill1.getHero());
        assertTrue(hero.getSkills().contains(skill1));
    }

    @Test
    public void testRemoveSkillBidirectional() {
        hero.addSkill(skill1);
        hero.removeSkill(skill1);
        assertNull(skill1.getHero());
        assertFalse(hero.getSkills().contains(skill1));
    }

    @Test
    public void testCastAllSkills() {
        hero.addSkill(skill1);
        hero.addSkill(skill2);
        assertEquals(425, hero.castAllSkills());
    }

    @Test
    public void testRemoveSkillNotInList() {
        hero.removeSkill(skill1); // skill1未添加
        assertFalse(hero.getSkills().contains(skill1));
        assertNull(skill1.getHero());
    }
}
