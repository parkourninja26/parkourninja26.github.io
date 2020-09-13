import java.awt.*;
import javax.swing.*;
import model.*;
import java.awt.event.*;
import java.util.*;
public class AddPanel extends CustomPanel 
{
    private Cinema cinema;
    public AddPanel(Cinema cinema)
    {  
        addTitle("Add");
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
        add(new MoviePanel(cinema)); 
        add(new TheatrePanel(cinema));
        add(new SessionPanel(cinema));
    }
    public void close()
    {
        setVisible(false);
    }
    private class MoviePanel extends CustomPanel implements MyObserver
    {
        private Cinema cinema;
        private JLabel Title = new JLabel("          Add a Movie          ");
        private JTextField name = new JTextField(10);
        private JTextField cost = new JTextField(10);
        private JLabel resultLabel = new JLabel("");
        //add button
        public MoviePanel(Cinema cinema)
        {
            this.cinema = cinema;
            cinema.attach(this);
            build();
        }
        private void build()
        {
            add(Title);
            addPair("Name", name);
            addPair("Cost", cost);
            MovieListener listener = new MovieListener();
            addButton("     Add     ",listener);
            add(resultLabel);
        }
        public String name()
        {
            return name.getText();
        }
        public double cost()
        {
            return Double.parseDouble(cost.getText());
        }
        public void update()
        {
            resultLabel.setText("Movie has been added!");
        }
        private class MovieListener implements ActionListener
        {
            public MovieListener()
            {
            }
            public void actionPerformed(ActionEvent e)
            {
                cinema.movies().add(name(),cost());
                update();
            }
        }
    }
    private class TheatrePanel extends CustomPanel implements MyObserver
    {
        private Cinema cinema;
        private JLabel title = new JLabel("           Add a Theatre           ");
        private JTextField name = new JTextField(8);
        private JTextField gold = new JTextField(4);
        private JTextField regular = new JTextField(4);
        private JLabel TheatreLabel = new JLabel("");
        //add button
        public TheatrePanel(Cinema cinema)
        {
            this.cinema = cinema;
            cinema.attach(this);
            build();
        }
        private void build()
        {
            add(title);
            addPair("Name", name);
            addPair("Gold Seats", gold);
            addPair("Regular Seats", regular);
            TheatreListener listener = new TheatreListener();
            addButton("     Add     ",listener);
            add(TheatreLabel);
        }
        public String name()
        {
            return name.getText();
        }
        public int gold()
        {
            return Integer.parseInt(gold.getText());
        }
        public int regular()
        {
            return Integer.parseInt(regular.getText());
        }
        public void update(String s)
        {
            TheatreLabel.setText(s);
        }
        private class TheatreListener implements ActionListener
        {
            public TheatreListener()
            {
            }
            public void actionPerformed(ActionEvent e)
            {
                cinema.theatres().add(name(),gold(),regular());
                update("Theatre has been added");
            }
        }
    }
    private class SessionPanel extends CustomPanel implements MyObserver
    {
        private Cinema cinema;
        private JLabel title = new JLabel("     Add a Session     ");
        private JTextField movieID  = new JTextField(2);
        private JTextField theatreID = new JTextField(2);
        private JTextField name = new JTextField(7);
        private JTextField time = new JTextField(7);
        private JLabel MovieLabel = new JLabel("");
        public SessionPanel(Cinema cinema)
        {
            this.cinema = cinema;
            cinema.attach(this);
            build();
        }
        private void build()
        {
            add(title);
            addPair("Session Name", name);
            addPair("Movie ID", movieID);
            addPair("Theatre ID", theatreID);
            addPair("Theatre Time", time);
            SessionListener listener = new SessionListener(cinema);
            addButton("Add",listener);
            add(MovieLabel);
        }
        public String name()
        {
            return name.getText();
        }
        public int movieId()
        {
            return Integer.parseInt(movieID.getText());
        }
        public int theatreId()
        {
            return Integer.parseInt(theatreID.getText());
        }
        public int time()
        {
            return Integer.parseInt(time.getText());
        }
        public void update(String s)
        {       
            MovieLabel.setText(s);
        }
        private class SessionListener implements ActionListener
        {
            private Cinema cinema;
            public SessionListener(Cinema cinema)
            {
                this.cinema = cinema;
            }
            public void actionPerformed(ActionEvent e)
            {
                Theatre theatre = cinema.theatres().find(theatreId());
                Movie movie = cinema.movies().find(movieId());
                if(movie != null)
                {
                    if(theatre != null)
                    { 
                        cinema.sessions().setupSession(movie,theatre,name(),time(),theatre.goldSeats(),theatre.regularSeats());
                        String s = ("Session has successfully been added!");
                        update(s);
                    }
                    else
                    {
                        String s = ("Theatre does not exist");
                        update(s);
                    }
                }
                else
                {
                    String s = ("Movie does not exist");
                    update(s);
                }
            }
        }
    }
}
