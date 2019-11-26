import greenfoot.*;

public class InvincibleStrategy implements ISuperPowerStrategy
{
    private int supertimer = 0;
    private boolean firingsuperpower = false;
    private Player player;
    private String attacktype;
    public InvincibleStrategy (Player player, String attacktype)
    {
        this.attacktype = attacktype;
        this.player = player;
    }
    
    public boolean isfiringSuperPower()
    {
        return firingsuperpower;
    }
    public void fireSuperPower()
    {
        firingsuperpower = true;
        player.superpowerUsed();
    }
    public void firingSuperpower()
    {
        if (!firingsuperpower)
            return;
        if (supertimer < 500)
        {
            supertimer++;
        }
        else
        {
            supertimer = 0;
            firingsuperpower = false;
        }
    }
}