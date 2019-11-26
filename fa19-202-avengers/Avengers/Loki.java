import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Loki here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Loki extends Enemy
{
     public Loki(Player mainPlayer, Counter counter) {
        super(mainPlayer, counter);
        this.health = 40;
        this.damage = 25;
    }
    
    public void setScaling() {
        GreenfootImage image = getImage();
        image.scale(140, 140);
    } 
    
    public void fireProjectile() {        
        getWorld().addObject(new KnifeProjectile(getX() < player.getX() ? -1 : 1), getX(), getY());
    }
}
