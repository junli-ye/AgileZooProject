import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zoo.Pandas;
import zoo.Zoo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test class ZooTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ZooTest
{
    private Zoo zoo; 
    private Pandas pandas1;
    private Pandas pandas2;
    
    /**
     * Default constructor for test class ZooTest
     */
    public ZooTest()
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
        zoo = new Zoo("zoo.Zoo");
        pandas1 = new Pandas("chutian",24);
        pandas2 = new Pandas("ningxin",23);

        zoo.registerPanda(pandas1);
        zoo.registerPanda(pandas2);
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

//    @Test
//    public void testAddPanda() {
//        List<zoo.Pandas> pandaList = zoo.getPandaList();
//
//        assertEquals(2, pandaList.size());
//
//        assertTrue(pandaList.contains(pandas1));
//        assertTrue(pandaList.contains(pandas2));
//
//        assertEquals(zoo, pandas1.getZoo());
//        assertEquals(zoo, pandas2.getZoo());
//    }

//    @Test
//    public void TestFeedAllPandas() {
//        zoo.feedPandas();
//    }

    @Test
    public void newTestRegisterPanda() {
        Zoo zoo = new Zoo("Dauphine zoo.Zoo");
        Pandas panda = new Pandas("BaoBao", 5);

        zoo.registerPanda(panda);

        // Check that the panda is added to the list
        assertTrue(zoo.getPandaList().contains(panda));

        // Check that the panda know where he is
        assertEquals(zoo, panda.getZoo());
    }
}
