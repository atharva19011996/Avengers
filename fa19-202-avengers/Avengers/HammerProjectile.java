import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HammerProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HammerProjectile extends HeroProjectile
{
    
    public HammerProjectile(int facing) 
    {
        super(facing);
        GreenfootImage up = new GreenfootImage("./images/thor_hammer.png");
        if (facing == -1)
            up.mirrorHorizontally();
        this.speed = 4;
        this.damage = 15;
        up.scale(40,40);
        setImage(up);
    }    
}
