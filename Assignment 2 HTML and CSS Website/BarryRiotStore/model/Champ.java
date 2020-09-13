package model;
import java.util.*;
public class Champ extends Record
{   
    public int cost;
    public Champ(String name, int cost)
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