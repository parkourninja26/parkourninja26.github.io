import model.*;
import java.awt.*;
import javax.swing.*;

public class StoreWindow extends JFrame
{
    public StoreWindow()
    {   setup();
        build();
        setVisible(true);   
    }
    private void setup()
    {   setSize(375, 410);
        setDefaultCloseOperation(EXIT_ON_CLOSE);    
    } 
    private void build()
    {   
        add(new Tab()); 
    }
    public class Tab extends JTabbedPane
    {
        public Tab()
        {   
            Cinema cinema = new Cinema();
            add("Add", new AddPanel(cinema));
            add("Sell", new SellPanel(cinema));   
            add("Show", new ShowPanel(cinema));
        }
    }
}
