import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ThanosHealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThanosHealthBar extends Actor implements IScoreBoardHealthObserver
{
    int health = 400;
    double specificHealth = (double)health;
    public ThanosHealthBar()
    {
        setImage(new GreenfootImage(400,12));
        getImage().drawRect(0,0,399,11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,health,10);
    }
    
    public void act() 
    {
        setImage(new GreenfootImage(400,12));
        getImage().drawRect(0,0,399,11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,health,10);
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;   
    }  
    
    public void loseHealth(int damage)
    {
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        health-= damage;
        
        if(health<-10)
            {
               getWorld().showText("You WIN! \n You survived for " + (myWorld.getPlayer().time/60) + " seconds", getWorld().getWidth()/2, getWorld().getHeight()/2);
               Greenfoot.stop();
            }
    }
    
    public void updateScoreBoardHealth(int damage)
    {
        loseHealth(damage);
    }
}