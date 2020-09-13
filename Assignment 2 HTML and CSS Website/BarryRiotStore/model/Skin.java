package model;
import java.util.*;
public class Skin extends Record
{   
    public int cost;
    public Skin(String name, int cost)
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