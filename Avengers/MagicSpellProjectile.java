import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MagicSpellProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagicSpellProjectile extends HeroProjectile
{
    public MagicSpellProjectile(int facing) 
    {
        super(facing);
        GreenfootImage up = new GreenfootImage("./images/spell.png");
        if (facing == -1)
            up.mirrorHorizontally();
        this.speed = 5;
        this.damage = 25;
        up.scale(60,60);
        setImage(up);
    }   
}
