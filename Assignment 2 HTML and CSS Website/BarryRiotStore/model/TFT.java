package model;
import java.util.*;
public class TFT extends Record
{   
    public int cost;
    public TFT(String name, int cost)
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