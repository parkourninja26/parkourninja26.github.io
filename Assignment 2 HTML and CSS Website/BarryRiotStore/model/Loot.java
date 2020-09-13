package model;
import java.util.*;
public class Loot extends Record
{   
    public int cost;
    public Loot(String name, int cost)
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