import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Starter_Screen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Starter_Screen extends World
{
    Counter counter = new Counter();
    /**
     * Constructor for objects of class Starter_Screen.
     * 
     */
    public Starter_Screen()
    {   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        SoundManager manager = SoundManager.getInstance();
        manager.stopSound();
        manager.setNewSound("title");
        
        manager.playSound();
        counter.score = 0;
        this.setBackground( new GreenfootImage("./images/Starter_Screen.jpg"));
        prepare();
    }
    
    public void prepare(){
        StarterScreenTitle titleScreen = new StarterScreenTitle();
        HelpScreenTitle helpScreen = new HelpScreenTitle();
        addObject(titleScreen, 543, 284);
        addObject(helpScreen, 543, 420);
    }
    public void act(){
    }
    
}
