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
    {   setSize(600, 200);
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
            RiotStore store = new RiotStore();
            add("Champion", new ChampPanel(store));
            add("Skins", new SkinPanel(store));
            add("TFT", new TFTPanel(store));
            add("Loot", new LootPanel(store));
            add("Accessories", new AccessoryPanel(store));
            add("Add RP", new BalancePanel(store));
            add("View Purchases", new PurchasePanel(store));
        }
    }
}