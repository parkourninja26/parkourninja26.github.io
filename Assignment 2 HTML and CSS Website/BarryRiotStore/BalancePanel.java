import java.awt.*;
import javax.swing.*;
import model.*;
import java.awt.event.*;
import java.util.*;
public class BalancePanel extends CustomPanel 
{
    private RiotStore store;
    public BalancePanel(RiotStore store)
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
        add(new TheBalancePanel(store)); 
    }
    public void close()
    {
        setVisible(false);
    }
    private class TheBalancePanel extends CustomPanel implements MyObserver
    {
        private RiotStore store;
        private JTextField cost = new JTextField(8);
        private JLabel label = new JLabel("");
        private JLabel rpStatus = new JLabel("");
        public TheBalancePanel(RiotStore store)
        {
            this.store = store;
            store.attach(this);
            build();
        }
        private void build()
        {
            addPair("Add RP ", cost);
            ChampListener listener = new ChampListener();
            addButton("Add RP", listener);
            add(label);
            add(rpStatus);
        }
        public int cost()
        {
            return Integer.parseInt(cost.getText());
        }
        public void purchased()
        {
            label.setText("");
            label.setText(cost() + " RP has been added");
        }
        public void fail()
        {
            label.setText("");
            label.setText("Not enough RP");
        }
        public void remaining()
        {
            rpStatus.setText("You now have " + store.getRP() + "RP         ");
        }
        private class ChampListener implements ActionListener
        {
            public ChampListener()
            {
            }
            public void actionPerformed(ActionEvent e)
            {
                store.addRP(cost());
                purchased();
                remaining();
            }
        }
    }
}