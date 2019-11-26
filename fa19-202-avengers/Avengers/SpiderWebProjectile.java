import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpiderWebProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpiderWebProjectile extends HeroProjectile
{
    public SpiderWebProjectile(int facing) 
    {
        super (facing);
        GreenfootImage up = new GreenfootImage("./images/web.png");
        if (facing == -1)
            up.mirrorHorizontally();
        this.speed = 7;
        this.damage = 18;
        up.scale(100,40);
        setImage(up);
    }    
}
