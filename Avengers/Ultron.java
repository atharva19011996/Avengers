import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ultron here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ultron extends Enemy
{
    
    public Ultron(Player mainPlayer, Counter counter) {
        super(mainPlayer, counter);
        this.health = 50;
        this.damage = 10;
    }
    
    public void setScaling() {
        GreenfootImage image = getImage();
        image.scale(120, 120);
    }  
    
    public void fireProjectile() {}
}
