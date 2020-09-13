import model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ShowPanel extends CustomPanel
{   
    private Cinema cinema;
    public ShowPanel(Cinema cinema)
    {   
        this.cinema = cinema;
        cinema.attach(this);
        setup();
        build();
        setVisible(true);
    }
    private void setup()
    {
        setSize(600,500);
        setLayout(new GridLayout(2,1));
    }
    private void build()
    {     
        add(new Balance (cinema));
    }
    public void close()
    {
        setVisible(false);
    }
    private class Balance extends CustomPanel implements MyObserver
    {
        private Cinema Cinema;
        private JLabel balance = new JLabel();
        public Balance (Cinema cinema)
        {
            this.Cinema = cinema;
            cinema.attach(this);
            build();
        }
        public void build()
        {
            add(balance);
            Listener listener = new Listener();
            addButton("Check balance", listener);
        }
        public void update(String s)
        {
            balance.setText(s);
        }
        private class Listener implements ActionListener
        {
            public Listener()
            {
            }
            public void actionPerformed(ActionEvent e)
            {
                update("Current balance: " + cinema.balance());
            }
        }
    }
}