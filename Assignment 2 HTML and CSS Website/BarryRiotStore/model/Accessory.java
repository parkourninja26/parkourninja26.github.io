package model;
import java.util.*;
public class Accessory extends Record
{   
    public int cost;
    public Accessory(String name, int cost)
    {
        super(name);
        this.cost = cost;  
    }
    public int cost()
    {
        return cost;
    }
    public String name()
    {
        return name;
    }
}