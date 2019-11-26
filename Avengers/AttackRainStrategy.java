import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class AttackRainStrategy implements ISuperPowerStrategy
{
    private int supertimer = 0;
    private boolean firingsuperpower = false;
    private Player player;
    private String attacktype;
    public AttackRainStrategy (Player player, String attacktype)
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
        SuperPowerProjectileFactory spfactory = new SuperPowerProjectileFactory();
        if (supertimer < 300)
        {
            if (supertimer % 10 == 0)
            {
                World world = player.getWorld();
                world.addObject(spfactory.getSuperProjectile(attacktype, null), Greenfoot.getRandomNumber(world.getWidth()), 0);
            }
            supertimer++;
        }
        else
        {
            supertimer = 0;
            firingsuperpower = false;
        }
    }
}
