package model;
import java.util.*;
/**
 * class Cinema 
 */
public class Cinema extends Updater
{
    private final String NAME = "MyCinema";
    private double balance = 100000.00;
    private double profit;
    private Movies movies = new Movies();
    private Theatres theatres = new Theatres();
    private Sessions sessions = new Sessions();
    public Cinema()
    {
    }
    public void addSession(String name, int movieId, int theatreId, int time, int gold, int regular)
    {   
        System.out.println("Add a Session");
        Movie movie = movies.find(movieId);
        Theatre theatre = theatres.find(theatreId);  
        if(isValid(movie, theatre))
        {
            sessions.setupSession(movie, theatre, name, time, gold, regular);
            System.out.println("Session Added");
        }
    }
    public boolean isValid(Movie movie, Theatre theatre)
    {
        return movie != null && theatre != null;
    }
    public void hireTheatre(Theatre theatre, int time, double amount)
    { 
        System.out.println("Hire a Theatre");
        if(theatre.vacant(time))
        {
            balance += amount;
            System.out.println("Theatre hired");
        }
    }  
    public double income()
    {
        return sessions.income();
    }
    public double cost()
    {
        return sessions.cost();
    }
    public void profit()
    { 
        double profit = income() - cost();
        setProfit(profit);
    }
    public void setProfit(double profit)
    {
        this.profit = profit;
    }
    public double showProfit()
    {
        return profit;
    }
    public double balance()
    { 
        profit();
        double newBalance = balance + profit;
        setBalance(newBalance);
        return newBalance;
    }
    public void setBalance(double balance)
    {
        this.balance = balance;
    }
    public void cinemaReport()
    {   
        movies.show();
        theatres.show();
        sessions.show();
        System.out.println(toString());
    } 
    public Sessions sessions()
    {
       return sessions;
    }
    public Theatres theatres()
    {
       return theatres;
    }
    public Movies movies()
    {
       return movies;
    }
    public void show()
    {   
        System.out.println(toString()); 
    }                
    public String toString()
    {   String s = "Cinema:";
        s += " cost = $" + cost();
        s += " income = $" + income();
        s += " profit = $" + showProfit();
        s+= " balance = $" + balance();
        return s;   
    }
}