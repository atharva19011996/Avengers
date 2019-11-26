import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrow extends SuperProjectile
{
    private Enemy target;
    public Arrow(Enemy target)
    {
        this.target = target;
        GreenfootImage up = new GreenfootImage("./images/arrow.png");
        up.scale(80,40);
        setRotation(0);
        setImage(up);
    }
    public void act() 
    {
        if (target.getWorld() != null)
            turnTowards(target.getX(), target.getY());
        move(10);
        if (isAtEdge()) getWorld().removeObject(this);
    }
}
