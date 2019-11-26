import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    public int speed;
    protected int damage;
    protected int facing;
    public Projectile(int facing)
    {
        this.facing = facing;
    }    
    
    public void act() 
    {
        move(facing * speed);
        if (isAtEdge()) getWorld().removeObject(this);
    } 
    
    public int getDamage() {
        return this.damage;
    }   
    
    public int getSpeed() {
        return this.speed;
    }
}
