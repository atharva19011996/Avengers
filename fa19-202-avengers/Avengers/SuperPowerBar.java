import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Superpower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SuperPowerBar extends Actor
{
    final int SUPER_POWER_LIMIT = 100;
    final int SLOWDOWN = 20;
    int charge = 90 * SLOWDOWN;
    Player player;
    public SuperPowerBar(Player player)
    {
        setImage(new GreenfootImage(SUPER_POWER_LIMIT + 2,12));
        getImage().drawRect(0,0,SUPER_POWER_LIMIT + 1,11);
        getImage().setColor(Color.BLUE);
        getImage().fillRect(1,1,charge / SLOWDOWN,10);
        this.player = player;
    }
    public void act() 
    {
        setImage(new GreenfootImage(SUPER_POWER_LIMIT + 2,12));
        getImage().drawRect(0,0,SUPER_POWER_LIMIT + 1,11);
        getImage().setColor(Color.BLUE);
        getImage().fillRect(1,1,charge / SLOWDOWN,10);
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        setLocation(1100,100);
        useSuper();
    }   
    public void useSuper()
    {
        charge++;
        if (charge > SUPER_POWER_LIMIT * SLOWDOWN)
        {
            charge = 0;
            player.superpowerReady();
        }
    }
}
