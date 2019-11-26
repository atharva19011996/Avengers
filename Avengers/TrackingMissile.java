import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TrackingMissile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrackingMissile extends SuperProjectile
{
    private Enemy target;
    public TrackingMissile(Enemy target)
    {
        this.target = target;
        GreenfootImage up = new GreenfootImage("./images/rocket.png");
        up.scale(80,80);
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
