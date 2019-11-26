import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elf extends Enemy
{
    public Elf(Player mainPlayer, Counter counter) {
        super(mainPlayer, counter);
        this.health = 10;
        this.damage = 5;
    }
    
    public void setScaling() {
        GreenfootImage image = getImage();
        image.scale(100, 108);
    }
    
    public void fireProjectile() {}
}
