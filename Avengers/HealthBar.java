import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor implements IScoreBoardHealthObserver
{
    int health = 100;
    int maxHealth = 100;
    double specificHealth = (double)health;
    public HealthBar(int health)
    {
        this.health = health;
        this.maxHealth = health;
        setImage(new GreenfootImage(100,12));
        getImage().drawRect(0,0,99,11);
        getImage().setColor(Color.RED);
        double perc = ((double)health / maxHealth) * 100;
        getImage().fillRect(1,1,(int) perc,10);
    }
    public void act() 
    {
        setImage(new GreenfootImage(100,12));
        getImage().drawRect(0,0,99,11);
        getImage().setColor(Color.RED);
        double perc = ((double)health / maxHealth) * 100;
        getImage().fillRect(1,1,(int) perc,10);
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;   
    }  
    
    public void loseHealth(int damage)
    {
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        health-= damage;
        
        if(health<=0)
            {
               getWorld().showText("You Lose! \n You survived for " + (myWorld.getPlayer().time/60) + " seconds", getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
    
    public void updateScoreBoardHealth(int damage)
    {
        loseHealth(damage);
    }
}
