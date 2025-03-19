
/**
 * Write a description of class Zoo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.List;

public class Zoo
{
    private String name;
    private List<Pandas> pandaList;

    /**
     * Constructor for objects of class Zoo
     */
    public Zoo(String name)
    {
        this.name = name;
        this.pandaList = new ArrayList<>();
    }
    
    public String getName(){
        return name;
    }

    public List<Pandas> getPandaList() {
        return pandaList;
    }

    public void registerPanda(Pandas panda) {
        if (!isPandaRegisted(panda)) {
            register(panda);
        }
    }

    private void register(Pandas panda) {
        pandaList.add(panda);
        panda.setZoo(this);
    }

    private boolean isPandaRegisted(Pandas panda) {
        return pandaList.contains(panda);
    }

    public void feedPandas() {
        if (pandaList.size() == 0) System.err.println("The zoo is empty.");
        System.out.println("The zookeeper is feeding the pandas at " + name + "...");
        for (Pandas pandas : pandaList) {
            pandas.eat(); 
        }
    }
    
    
}
