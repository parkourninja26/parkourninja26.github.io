import model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class SellPanel extends CustomPanel
{   
    private Cinema cinema;
    public SellPanel(Cinema cinema)
    {
        addTitle("Sell");
        setup();
        this.cinema = cinema;
        cinema.attach(this);
        build();
        setVisible(true);
    }
    public void setup()
    {
        setSize(600,500);
        setLayout(new GridLayout(2,1));
    }
    public void build()
    {
        SellSessionPanel session = new SellSessionPanel(cinema);
        add(session);
        add(new SeatPanel(cinema,session));
        add(new DetailPanel(cinema,session));
    }
    public void close()
    {
        setVisible(false);
    }
    private class SellSessionPanel extends CustomPanel implements MyObserver
    {
        private Cinema cinema;
        private JTextField sessionId = new JTextField(3);
        private JLabel movieName = new JLabel("Movie in selected session");
        public SellSessionPanel(Cinema cinema)
        {
            this.cinema = cinema;
            cinema.attach(this);
            build();
        }
        public void build()
        {
            addPair("Session ID", sessionId);
            add(movieName);
            SellListener listener = new SellListener();
            addButton("Check", listener);
        }
        public int sessionID()
        {
            return Integer.parseInt(sessionId.getText());
        }
        public void update(String msg)
        {
            movieName.setText("Movie name is " + msg);
        }
        private class SellListener implements ActionListener
        {
            public SellListener()
            {
            }
            public void actionPerformed(ActionEvent e)
            {
                Session session = cinema.sessions().find(sessionID());
                if(session!=null)
                {
                    String msg = session.movie().name();
                    update(msg);
                }
                else
                {
                    movieName.setText("Movie not found!");
                }
            }
        }
    }
    private class DetailPanel extends CustomPanel implements MyObserver
    {
        private Cinema cinema;
        private SellSessionPanel session;
        private JLabel label = new JLabel();
        public DetailPanel(Cinema cinema, SellSessionPanel session)
        {
            this.cinema = cinema;
            this.session = session;
            cinema.attach(this);
            build();
        }
        public void build()
        {
            SellListener listener = new SellListener();
            addButton("Ticketing Details", listener);
            add(label);
        }
        public int id()
        {
            return session.sessionID();
        }
        public void update(String msg)
        {
            label.setText(msg);
        }
        private class SellListener implements ActionListener
        {
            public SellListener()
            {
            }
            public void actionPerformed(ActionEvent e)
            {
                Session session = cinema.sessions().find(id());
                if(session != null)
                {
                    String msg = ("ticketing details are given");
                    update(msg);
                    session.show();
                }
                else
                {
                    String msg = ("error");
                    update(msg);
                }
            }
        }
    }
    private class SeatPanel extends CustomPanel implements MyObserver
    {
        private Cinema cinema;
        private SellSessionPanel session;
        private int id;
        private JTextField reg = new JTextField(3);
        private JTextField gold = new JTextField(3);
        private JLabel regLabel = new JLabel("Regular Seats");
        private JLabel goldLabel = new JLabel("Golden Seats");
        private JLabel status = new JLabel();
        public SeatPanel(Cinema cinema, SellSessionPanel session)
        {
            this.cinema = cinema;
            this.session = session;
            cinema.attach(this);
            build();
        }
        public void build()
        {
            add(regLabel);
            add(reg);
            add(goldLabel);
            add(gold);
            SellListener listener = new SellListener();
            addButton("Sell",listener);
            add(status);
        }
        public int id()
        {
            return session.sessionID();
        }
        public int gold()
        {
            return Integer.parseInt(gold.getText());
        }
        public int regular()
        {
            return Integer.parseInt(reg.getText());
        }
        public void update(String s)
        {
            status.setText(s);
        }
        private class SellListener implements ActionListener
        {
            public SellListener()
            {
            }
            public void actionPerformed(ActionEvent e)
            {
                Session session = cinema.sessions().find(id());
                if (session != null)
                {
                    if(cinema.sessions().canSell(id(),gold(),regular())==true)
                    {
                        cinema.sessions().sellTickets(id(),gold(),regular());
                        update("Tickets sold");
                    }
                    else
                    {
                        update("Seats are already sold");
                    }
                }
                else
                {
                    update("Error");
                }
            }
        }
    }
}