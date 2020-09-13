package model;
import java.util.*;
public class Skins extends Records
{
    private int cost;
    private String name;
    public Skins()
    {
    }
    public void add(Skin skin)
    {
        super.add(skin);
        updateViews();
    }
    public void add(String name, int cost)
    { 
        setName(name);
        setPrice(cost);
    }
    public void addSkin()
    {
        Skin skin = new Skin(name,cost);
        add(skin);
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
        return "\tSkins:\n " + super.toString();
    }
}