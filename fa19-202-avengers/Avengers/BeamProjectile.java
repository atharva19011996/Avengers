import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BeamProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BeamProjectile extends HeroProjectile
{
    public BeamProjectile(int facing) 
    {
        super (facing);
        GreenfootImage up = new GreenfootImage("./images/beam.png");
        this.speed = 7;
        this.damage = 18;
        up.scale(60,40);
        setImage(up);
    }   
}
