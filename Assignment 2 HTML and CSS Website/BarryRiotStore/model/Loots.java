package model;
import java.util.*;
public class Loots extends Records
{
    private int cost;
    private String name;
    public Loots()
    {
    }
    public void add(Loot loot)
    {
        super.add(loot);
        updateViews();
    }
    public void add(String name, int cost)
    { 
        setName(name);
        setPrice(cost);
    }
    public void addLoot()
    {
        Loot loot = new Loot(name,cost);
        add(loot);
        updateViews();
    }
    public void showPrice()
    {
        returnPrice();
    }
    public void setPrice(int cost)
    {
        this.cost = cost;
    }
    public int returnPrice()
    {
        return cost;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public void show()
    {
        System.out.println(toString());
    }    
    public String toString()
    {
        return "\tLoot:\n " + super.toString();
    }
}