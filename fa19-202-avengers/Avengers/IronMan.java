import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IronMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IronMan extends Player implements IPlayer
{
    public IronMan()
    {
        superpowerstrategy = new TrackingProjectilesStrategy(this, "MISSILE");
        this.health = 175;
    }
    public void act() 
    {
        super.act();
    }
    public void displayInfo() {
        String name = this.getClass().getName();
        getWorld().showText(name, 1100, 55);
        GreenfootImage character = new GreenfootImage("./images/iron man.png");
        GreenfootImage health = new GreenfootImage("./images/health.png");
        GreenfootImage superpower = new GreenfootImage("./images/power.png");
        character.scale(70,70);
        health.scale(30,30);
        superpower.scale(30,30);
        getWorld().getBackground().drawImage(character, 950, 45 );
        getWorld().getBackground().drawImage(health, 1020, 65 );
        getWorld().getBackground().drawImage(superpower, 1020, 95 );
        
    }
    public GreenfootImage getSuperPowerImage()
    {
        GreenfootImage spimage = new GreenfootImage("./images/hero/ironman/super.png");
        spimage.scale(150,150);
        if (facing == -1)
            spimage.mirrorHorizontally();
        return spimage;
    }
    public GreenfootImage getAttackingImage()
    {
        GreenfootImage attimage = new GreenfootImage("./images/hero/ironman/shoot.png");
        attimage.scale(150,150);
        if (facing == -1)
            attimage.mirrorHorizontally();
        return attimage;
    }
    public GreenfootImage getIdleImage()
    {
        GreenfootImage idleimage = new GreenfootImage("./images/hero/ironman/idle.png");
        idleimage.scale(100,150);
        if (facing == -1)
            idleimage.mirrorHorizontally();
        return idleimage;
    }
    public void fireProjectile()
    {
        getWorld().addObject(new BeamProjectile(facing), getX(), getY() - 40);
    }
}
