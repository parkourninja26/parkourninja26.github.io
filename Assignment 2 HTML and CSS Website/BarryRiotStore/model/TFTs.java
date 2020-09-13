package model;
import java.util.*;
public class TFTs extends Records
{
    private int cost;
    private String name;
    public TFTs()
    {
    }
    public void add(TFT tft)
    {
        super.add(tft);
        updateViews();
    }
    public void add(String name, int cost)
    { 
        setName(name);
        setPrice(cost);
    }
    public void addTFT()
    {
        TFT tft = new TFT(name,cost);
        add(tft);
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
        return "\tTFT Loot:\n " + super.toString();
    }
}