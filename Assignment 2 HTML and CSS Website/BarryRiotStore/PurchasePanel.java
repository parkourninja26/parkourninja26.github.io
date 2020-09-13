import java.awt.*;
import javax.swing.*;
import model.*;
import java.awt.event.*;
import java.util.*;
public class PurchasePanel extends CustomPanel 
{
    private RiotStore store;
    public PurchasePanel(RiotStore store)
    {  
        addTitle("Add RP");
        setup();
        this.store = store;
        store.attach(this);
        build();
        setVisible(true);
    }
    public void setup()
    {  
        setSize(600,500);
        setLayout(new GridLayout(1,2));
    }   
    public void build()
    {   
        add(new ThePurchasePanel(store)); 
    }
    public void close()
    {
        setVisible(false);
    }
    private class ThePurchasePanel extends CustomPanel implements MyObserver
    {
        private RiotStore store;
        private JLabel champ = new JLabel("");
        private JLabel skin = new JLabel("");
        private JLabel tft = new JLabel("");
        private JLabel loot = new JLabel("");
        private JLabel accessory = new JLabel("");
        public ThePurchasePanel(RiotStore store)
        {
            this.store = store;
            store.attach(this);
            build();
        }
        private void build()
        {
            PurchaseListener listener = new PurchaseListener();
            addButton("View Purchases", listener);
            add(champ);
            add(skin);
            add(tft);
            add(loot);
            add(accessory);
        }
        private class PurchaseListener implements ActionListener
        {
            public PurchaseListener()
            {
            }
            public void actionPerformed(ActionEvent e)
            {
                String champmsg = store.champs.toString();
                champ.setText("" + champmsg);
                String skinmsg = store.skins.toString();
                skin.setText("" + skinmsg);
                String tftmsg = store.tfts.toString();
                tft.setText("" + tftmsg);
                String lootmsg = store.loots.toString();
                loot.setText("" + lootmsg);
                String accessorymsg = store.accessories.toString();
                accessory.setText("" + accessorymsg);
            }
        }
    }
}