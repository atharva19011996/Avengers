import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerStateMachine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerStateMachine extends Actor
{
    // instance variables - replace the example below with your own
    private AnimationState current;
    private int timer = 0;
    private int animationtime = 0;
    private boolean timerstart = false;
    private boolean shiftwasdown = false;
    /**
     * Constructor for objects of class PlayerStateMachine
     */
    public PlayerStateMachine(Player player)
    {
        current = new IdleState(this, player);
        current.initAnimation();
    }
    public void attack()
    {
        current.attack();
    }
    public void flipHorizontally()
    {
        current.flipHorizontally();
    }
    public void superPower()
    {
        current.superPower();
    }
    public void setAnimationState(AnimationState newstate)
    {
        current = newstate;
        current.initAnimation();
    }
    public void setAnimationTime(int time){
        timerstart = true;
        timer = 0;
        animationtime = time;
    }
    private void animationTimer()
    {
        if (!timerstart)
            return;
        if (timer >= animationtime)
        {
            current.autoStateChange();
            timerstart = false;
        }
        else
        {
            timer++;
        }
    }
    public void act() 
    {
        animationTimer();
        if(Greenfoot.isKeyDown("space"))
        { 
           attack();
        }
        else if(Greenfoot.isKeyDown("x"))
        { 
           superPower();
        }
        else if (Greenfoot.isKeyDown("shift")){
            if(!shiftwasdown)
            {
               flipHorizontally();
               shiftwasdown = true;
            }
        }
        else {
            shiftwasdown = false;
        }
    }
}
