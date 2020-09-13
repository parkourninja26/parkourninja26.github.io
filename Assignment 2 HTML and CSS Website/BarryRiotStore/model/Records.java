package model;
import java.util.*;
public class Records extends Updater
{
    protected LinkedList<Record> records = new LinkedList<Record>();
    protected Record find(String name)
    {   
        for(Record record: records)
        {  
            if (record.matches(name))
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
