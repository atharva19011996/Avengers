import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TrackingWeb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrackingWeb extends SuperProjectile
{
    private Enemy target;
    public TrackingWeb(Enemy target)
    {
        this.target = target;
        GreenfootImage up = new GreenfootImage("./images/trackweb.png");
        up.scale(80,80);
        setImage(up);
        setRotation(90);
    }
    public void act() 
    {
        if (target.getWorld() != null)
            turnTowards(target.getX(), target.getY());
        move(10);
        if (isAtEdge()) getWorld().removeObject(this);
    }
}
