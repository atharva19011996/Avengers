import greenfoot.*;
/**
 * Sinusoidal movement strategy.
 * 
 * @author Atharva Munshi
 */
public class SinusoidalMovementStrategy implements IProjectileMoveStrategy 
{
    private int changemovementafterstep =50;
    private int step =1;
    private int toggler =1;
    private int speed;
    private Projectile projectile;
    private int isReverse;

    public SinusoidalMovementStrategy(int isReverse){
        this.speed = 0-getRandomNumber(3,4);
        this.isReverse = isReverse;
    }
    

    public void setProjectile(Projectile projectile){
        this.projectile = projectile;
        this.projectile.setRotation(-45);
    }
    

    public void moveProjectile(){
        this.projectile.move(isReverse * this.speed);
        rotateProjectile();
    }
    

    public void rotateProjectile(){
        if(step % changemovementafterstep ==0){
            this.projectile.turn(90*toggler);
            toggler *= -1;
        }
        step++;
    }
    
    /**
     * chages the moving speed of actor
     */
    public void changeSpeed(int speed){
        this.speed = speed;
    }
    
    private int getRandomNumber(int s,int e)
    {
       int normal = Greenfoot.getRandomNumber(e-s+1);
       return normal+s;
    }
}