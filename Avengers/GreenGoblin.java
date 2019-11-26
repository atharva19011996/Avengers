

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GreenGoblin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GreenGoblin extends Enemy
{
    public GreenGoblin(Player mainPlayer, Counter counter) {
        super(mainPlayer, counter);
        this.health = 30;
        this.damage = 15;
    }  
    
    public void setScaling() {
        GreenfootImage image = getImage();
        image.scale(140, 145);
    }  
    
    public void fireProjectile() {        
        getWorld().addObject(new BombProjectile(getX() < player.getX() ? -1 : 1), getX(), getY());
    }
}
