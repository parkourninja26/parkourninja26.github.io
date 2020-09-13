package model;
import java.util.*;
/**
 * class Theatres 
 */
public class Theatres extends Records
{
    public Theatres()
    {
    }
    public void add(Theatre theatre)
    {
        records.add(theatre);
        updateViews();
    }
    public void add(String name, int gold, int regular)
    {   
        System.out.println("Add a Theatre");
        Theatre theatre = new Theatre(++id, name, gold, regular);
        add(theatre);
        updateViews();
    }
    public Theatre find(int id)
    {   
        return (Theatre) super.find(id);   
    }
}