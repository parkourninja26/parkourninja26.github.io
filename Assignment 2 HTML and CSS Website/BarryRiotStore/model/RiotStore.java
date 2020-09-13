package model;
import java.util.*;
public class RiotStore extends Updater
{
    private final String NAME = "RiotStore";
    private String name;
    private int cost;
    private int rp = 5400;
    private int purchases;
    private int sold = 0;
    private boolean credit = true;
    public Champs champs = new Champs();
    public Skins skins = new Skins();
    public TFTs tfts = new TFTs();
    public Loots loots = new Loots();
    public Accessories accessories = new Accessories();
    public RiotStore()
    {
    }
    public void buyChamp()
    {
        unlockCredit();
        if ((getRP() - champs.returnPrice()) >= 0)
        {
            champs.addChamp();
            setRP(rp - champs.returnPrice());
            updateViews();
        }
        else
        {    
            lockCredit();
        }
    }
    public void buySkin()
    {
        unlockCredit();
        if ((getRP() - skins.returnPrice()) >= 0)
        {
            skins.addSkin();
            setRP(rp - skins.returnPrice());
            updateViews();
        }
        else
        {    
            lockCredit();
        }
    }
    public void buyTFT()
    {
        unlockCredit();
        if ((getRP() - skins.returnPrice()) >= 0)
        {
            tfts.addTFT();
            setRP(rp - tfts.returnPrice());
            updateViews();
        }
        else
        {    
            lockCredit();
        }
    }
    public void buyLoot()
    {
        unlockCredit();
        if ((getRP() - loots.returnPrice()) >= 0)
        {
            loots.addLoot();
            setRP(rp - loots.returnPrice());
            updateViews();
        }
        else
        {    
            lockCredit();
        }
    }
    public void buyAccessory()
    {
        unlockCredit();
        if ((getRP() - accessories.returnPrice()) >= 0)
        {
            accessories.addAccessory();
            setRP(rp - accessories.returnPrice());
            updateViews();
        }
        else
        {    
            lockCredit();
        }
    }
    public int getRP()
    {
        return rp;
    }
    public void setRP(int rp)
    {
        this.rp = rp;
    }
    public void addRP(int rp)
    {
        int addition = getRP() + rp;
        setRP(addition);
    }
    public String report()
    {   
        String str = champs.toString() + "\n"
        + skins.toString() + "\n"
        + tfts.toString() + "\n"
        + loots.toString() + "\n"
        + accessories.toString();
        return str;
    }
    private boolean lockCredit()
    {
        return credit = false;
    }
    private boolean unlockCredit()
    {
        return credit = true;
    }
    public boolean getCredit()
    {
        return credit;
    }
    public Champs champs()
    {
       return champs;
    }
    public Skins skins()
    {
        return skins;
    }
    public TFTs tfts()
    {
        return tfts;
    }
    public Loots loots()
    {
        return loots;
    }
    public Accessories accessories()
    {
        return accessories;
    }
    public void show()
    {   
        System.out.println(toString()); 
    }                
}