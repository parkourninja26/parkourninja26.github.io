package model;
import java.util.*;
/**
 * class Records 
 */
public class Records extends Updater
{
    protected LinkedList<Record> records = new LinkedList<Record>();
    protected int id = 0;
    protected Record find(int id)
    {   
        for(Record record: records)
        {  
            if (record.matches(id))
                return record;  
        }
        return null;    
    }  
    protected void add(Record record)
    {
        records.add(record);
        updateViews();
    }
    public int size()
    {
        return records.size();
    }
    public void show()
    {
        System.out.println(toString());
    }
    public String toString()
    {
        String str = "";
        for(Record record : records)
            str += record.toString() + "\n";
        return str;
    }
}