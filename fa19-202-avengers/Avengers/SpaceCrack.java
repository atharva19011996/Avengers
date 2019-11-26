import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpaceCrack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpaceCrack extends SuperProjectile
{
    public SpaceCrack()
    {
        GreenfootImage up = new GreenfootImage("./images/magicball.png");
        up.scale(40,40);
        setImage(up);
        setRotation(90);
    }
    public void act() 
    {
        move(10);
        if (isAtEdge()) getWorld().removeObject(this);
    }  
}
