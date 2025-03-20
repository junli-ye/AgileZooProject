package zoo;
/**
 * Write a description of class zoo.Zoo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.List;

public class Zoo
{
    private String name;
    private List<Panda> pandaList;

    /**
     * Constructor for objects of class zoo.Zoo
     */
    public Zoo(String name)
    {
        this.name = name;
        this.pandaList = new ArrayList<>();
    }
    
    public String getName(){
        return name;
    }

    private List<Panda> getPandaList() {
        return pandaList;
    }

//    Encaspulation d'une association
    public int getZooSize() {
        return this.pandaList.size();
    }

    public boolean isPandaInZoo(Panda panda) {
        return this.pandaList.contains(panda);
    }

    public void registerPanda(Panda panda) {
        if (!isPandaRegisted(panda)) {
            register(panda);
        }
    }

    private void register(Panda panda) {
        pandaList.add(panda);
        panda.setZoo(this);
    }

    private boolean isPandaRegisted(Panda panda) {
        return pandaList.contains(panda);
    }

    public void feedPandas() {
        if (pandaList.size() == 0) System.err.println("The zoo is empty.");
        System.out.println("The zookeeper is feeding the pandas at " + name + "...");
        for (Panda pandas : pandaList) {
            pandas.eat(); 
        }
    }
    
    
}
