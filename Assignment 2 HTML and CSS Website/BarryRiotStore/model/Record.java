package model;
public class Record extends Updater 
{
    protected String name;
    public Record(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public boolean matches(String name)
    {
        return this.name == name;
    }
    public void show()
    {   
        System.out.println(toString()); 
    }  
    public String toString()
    {
        return name;
    }
}