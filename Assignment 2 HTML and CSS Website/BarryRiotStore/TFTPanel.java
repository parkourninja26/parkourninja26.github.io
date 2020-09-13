import java.awt.*;
import javax.swing.*;
import model.*;
import java.awt.event.*;
import java.util.*;
public class TFTPanel extends CustomPanel 
{
    private RiotStore store;
    public TFTPanel(RiotStore store)
    {  
        addTitle("Buy TFT Loot");
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
        add(new TheTFTPanel(store)); 
    }
    public void close()
    {
        setVisible(false);
    }
    private class TheTFTPanel extends CustomPanel implements MyObserver
    {
        private RiotStore store;
        private JTextField Title = new JTextField(16);
        private JTextField cost = new JTextField(16);
        private JLabel label = new JLabel("");
        private JLabel rpStatus = new JLabel("");
        public TheTFTPanel(RiotStore store)
        {
            this.store = store;
            store.attach(this);
            build();
        }
        private void build()
        {
            addPair("TFT Loot", Title);
            addPair("TFT Loot Cost", cost);
            ChampListener listener = new ChampListener();
            addButton("Purchase", listener);
            UpdateListener update = new UpdateListener();
            addButton("Update RP", update);
            add(label);
            add(rpStatus);
        }
        public String name()
        {
            return Title.getText();
        }
        public int cost()
        {
            return Integer.parseInt(cost.getText());
        }
        public void purchased()
        {
            label.setText("");
            label.setText(name() + " has been Purchased");
        }
        public void fail()
        {
            label.setText("");
            label.setText("Not enough RP");
        }
        public void remaining()
        {
            rpStatus.setText("You have " + store.getRP() + "RP         ");
        }
        private class ChampListener implements ActionListener
        {
            public ChampListener()
            {
            }
            public void actionPerformed(ActionEvent e)
            {
                store.tfts().add(name(),cost());
                store.buyTFT();
                if (store.getCredit() == false)
                    label.setText("Not enough RP");
                else
                    purchased();
                    remaining();
            }
        }
        private class UpdateListener implements ActionListener
        {
            public UpdateListener()
            {
            }
            public void actionPerformed(ActionEvent e)
            {
                remaining();
            }
        }
    }
}