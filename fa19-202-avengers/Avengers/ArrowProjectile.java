import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ArrowProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArrowProjectile extends HeroProjectile
{
    
    
    public ArrowProjectile(int facing) 
    {
        super(facing);
        GreenfootImage up = new GreenfootImage("./images/arrow.png");
        if (facing == -1)
            up.mirrorHorizontally();
        this.speed = 6;
        this.damage = 20;
        up.scale(80,40);
        setImage(up);
    }   
        
}
