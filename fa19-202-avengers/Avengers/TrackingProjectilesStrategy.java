import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TrackingProjectilesStrategy implements ISuperPowerStrategy
{
    private Player player;
    private String attacktype;
    public TrackingProjectilesStrategy (Player player, String attacktype)
    {
        this.attacktype = attacktype;
        this.player = player;
    }
    
    public boolean isfiringSuperPower()
    {
        return false;
    }
    public void fireSuperPower()
    {
        SuperPowerProjectileFactory spfactory = new SuperPowerProjectileFactory();
        World world = player.getWorld();
        for (Enemy enemy : world.getObjects(Enemy.class))
        {
            world.addObject(
                spfactory.getSuperProjectile(attacktype, enemy),
                player.getX(), player.getY());
        }
        player.superpowerUsed();
    }
    public void firingSuperpower()
    {
    }
}
