package model;
import java.util.*;
public class Accessories extends Records
{
    private int cost;
    private String name;
    public Accessories()
    {
    }
    public void add(Accessory accessory)
    {
        super.add(accessory);
        updateViews();
    }
    public void add(String name, int cost)
    { 
        setName(name);
        setPrice(cost);
    }
    public void addAccessory()
    {
        Accessory accessory = new Accessory(name,cost);
        add(accessory);
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
        return "\tAccessories:\n " + super.toString();
    }
}