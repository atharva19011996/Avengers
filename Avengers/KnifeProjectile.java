import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KnifeProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KnifeProjectile extends EnemyProjectile
{
    IProjectileMoveStrategy movementStrategy;
    public KnifeProjectile(int facing)
    {
        super (facing);
        GreenfootImage up = new GreenfootImage("./images/knife.png");
        this.speed = 7;
        this.damage = 15;
        up.scale(80,40);
        setImage(up);        
        if (facing == -1)
            up.mirrorHorizontally();
        this.movementStrategy = new StraightMovementStrategy(facing);
        this.movementStrategy.setProjectile(this);
    }
    
    public void act(){
        this.movementStrategy.moveProjectile();
        this.actorOnEdgeAction();
    }

     public boolean actorOnEdgeAction(){
        if ( this.isAtEdge()){
            getWorld().removeObject(this);
            return true;
        }
        return false;
    }
}