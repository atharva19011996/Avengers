import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NextLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NextLevel extends Actor
{
    public NextLevel()
    {   
        setImage(new GreenfootImage("Next Level", 40, Color.WHITE, new Color(0,0,0,0))); 
        
    }
    
    public void act() 
    {   getWorld().getBackground().setColor(Color.RED);
        getWorld().getBackground().drawRect(490,660,220,70);
        setImage(new GreenfootImage("Next Level", 40, Color.WHITE, new Color(0,0,0,0)));
        
        Greenfoot.setWorld(getWorld());
        click();
        
    }    
    
    public void click(){
        if(Greenfoot.mouseClicked(this)){
            //clicked = true;
            //getWorld()
            //Player mainPlayer = (Player)getWorld().getObject(Player.class);
            MyWorld my = (MyWorld)getWorld();
            my.nextLevelTransition();
        }
    }  
}
