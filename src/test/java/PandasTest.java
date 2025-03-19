import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test class PandasTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PandasTest
{
    private Pandas po;
    /**
     * Default constructor for test class PandasTest
     */
    public PandasTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        System.out.println("BeforeEach is running...");
        po = new Pandas("Po", 5);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    @Test
    public void testGetName() {
        assertEquals("Po", po.getName(), "getName() failed");
    }
    
    @Test
    public void testSetName() {
        po.setName("Bamboo");
        assertEquals("Bamboo", po.getName(), "setName() failed");
    }
    
    @Test
    public void testGetAge() {
        assertEquals(5, po.getAge(), "getAge() failed");
    }
    
    @Test
    public void testSetAge() {
        po.setAge(6);
        assertEquals(6, po.getAge(), "setAge() failed");
    }
    
    @Test
    public void testMakeSound() {
        assertEquals("Po squeaks!", po.makeSound(), "makeSound() failed");
    }

    @Test
    public void testSetAndGetZoo() {
        assertNull(po.getZoo());
        Zoo testZoo = new Zoo("testZoo");
        po.setZoo(testZoo);
        assertEquals(testZoo, po.getZoo(), "getZoo() failed");
    }

    @Test
    public void testPandaIsHungry() {
        Pandas panda = new Pandas("LingLing", 4);
        assertTrue(panda.isHungry());
        panda.eat();
        assertFalse(panda.isHungry());
    }

}
