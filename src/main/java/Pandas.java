
/**
 * Write a description of class Pandas here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pandas
{
    private String name;
    private int age;
    private Zoo zoo;
    private boolean isHungry;

    public Pandas(String name, int age) {
        this.name = name;
        this.age = age;
        this.zoo = null;
        this.isHungry = true;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public Zoo getZoo() { return this.zoo; }

    public boolean isHungry() { return this.isHungry; }

    public void setAge(int age) {
        this.age = age;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    public void eat() {
        this.isHungry = false;
        System.out.println(name + " is eating bamboo.");
    }

    public void sleep() {
        this.isHungry = true;
        System.out.println(name + " is sleeping in the trees.");
    }

    public String makeSound() {
        return name + " squeaks!";
    }
}
