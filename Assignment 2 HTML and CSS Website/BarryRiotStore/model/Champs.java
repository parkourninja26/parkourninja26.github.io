package model;
import java.util.*;
public class Champs extends Records
{
    private int cost;
    private String name;
    public Champs()
    {
    }
    public void add(Champ champ)
    {
        super.add(champ);
        updateViews();
    }
    public void add(String name, int cost)
    { 
        setName(name);
        setPrice(cost);
    }
    public void addChamp()
    {
        Champ champ = new Champ(name,cost);
        add(champ);
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
    public String toString()
    {
        return "\tChampions:\n " + super.toString();
    }
}