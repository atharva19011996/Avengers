import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpiderMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpiderMan extends Player implements IPlayer
{
    /**
     * Act - do whatever the SpiderMan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SpiderMan()
    {
        superpowerstrategy = new TrackingProjectilesStrategy(this, "WEB");
        this.health = 110;
    }
    public void act() 
    {
        super.act();
    } 
    public void displayInfo() {
        String name = this.getClass().getName();
        getWorld().showText(name, 1100, 55);
        GreenfootImage character = new GreenfootImage("./images/spiderman.png");
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
        GreenfootImage spimage = new GreenfootImage("./images/hero/spiderman/super.png");
        spimage.scale(150,150);
        if (facing == -1)
            spimage.mirrorHorizontally();
        return spimage;
    }
    public GreenfootImage getAttackingImage()
    {
        GreenfootImage attimage = new GreenfootImage("./images/hero/spiderman/shoot.png");
        attimage.scale(130,130);
        if (facing == -1)
            attimage.mirrorHorizontally();
        return attimage;
    }
    public GreenfootImage getIdleImage()
    {
        GreenfootImage idleimage = new GreenfootImage("./images/hero/spiderman/idle.png");
        idleimage.scale(150,130);
        if (facing == -1)
            idleimage.mirrorHorizontally();
        return idleimage;
    }
    public void fireProjectile()
    {
        getWorld().addObject(new SpiderWebProjectile(facing), getX(), getY()-30);
    }
}
