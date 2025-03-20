import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zoo.Panda;
import zoo.Zoo;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test class PandasTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PandasTest
{
    private Panda pandas;
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
        pandas = new Panda("Po", 5);
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
        assertEquals("Po", pandas.getName(), "getName() failed");
    }
    
    @Test
    public void testSetName() {
        pandas.setName("Bamboo");
        assertEquals("Bamboo", pandas.getName(), "setName() failed");
    }
    
    @Test
    public void testGetAge() {
        assertEquals(5, pandas.getAge(), "getAge() failed");
    }
    
    @Test
    public void testSetAge() {
        pandas.setAge(6);
        assertEquals(6, pandas.getAge(), "setAge() failed");
    }
    
    @Test
    public void testMakeSound() {
        assertEquals("Po squeaks!", pandas.makeSound(), "makeSound() failed");
    }

    @Test
    public void testSetAndGetZoo() {
        assertNull(pandas.getZoo());
        Zoo testZoo = new Zoo("testZoo");
        pandas.setZoo(testZoo);
        assertEquals(testZoo, pandas.getZoo(), "getZoo() failed");
    }

    @Test
    public void testPandaIsHungry() {
        Panda panda = new Panda("LingLing", 4);
        assertTrue(panda.isHungry());
        panda.eat();
        assertFalse(panda.isHungry());
    }

}
