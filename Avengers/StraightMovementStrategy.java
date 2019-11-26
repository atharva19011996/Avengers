import greenfoot.*;
/**
 * Straight movement strategy.
 * 
 * @author Atharva Munshi
 */
public class StraightMovementStrategy implements IProjectileMoveStrategy 
{
    private int speed;
    private Projectile projectile;
    private int isReverse;
    public StraightMovementStrategy(int isReverse){
        this.speed = 0-getRandomNumber(2,6);
        this.isReverse = isReverse;
    }
    
    public void setProjectile(Projectile projectile){
        this.projectile = projectile;
    }
    
    public void moveProjectile(){
        this.projectile.move(isReverse * this.speed);
    }
    
    public void rotateProjectile(){
        
    }
    
    public void changeSpeed(int speed){
        this.speed = speed;
    }
    
    private int getRandomNumber(int s,int e)
    {
       int n = Greenfoot.getRandomNumber(e-s+1);
       return n+s;
    }
}
