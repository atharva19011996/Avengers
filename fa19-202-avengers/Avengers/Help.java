import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Help here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Help extends World
{

    /**
     * Constructor for objects of class Help.
     * 
     */
    public Help()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        this.setBackground( new GreenfootImage("./images/Help.png"));
    }
    public void act() 
    {
        click();
    }    
    
    public void click() 
    {
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Starter_Screen());
        }
    }
}
