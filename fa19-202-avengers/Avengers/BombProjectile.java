import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SphereProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BombProjectile extends EnemyProjectile
{
    private IProjectileMoveStrategy movementStrategy;
    public BombProjectile(int facing)
    {
        super (facing);
        GreenfootImage up = new GreenfootImage("./images/bomb.png");
        this.speed = 5;
        this.damage = 20;
        up.scale(40,40);
        setImage(up);
        this.movementStrategy = new SinusoidalMovementStrategy(facing);
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
