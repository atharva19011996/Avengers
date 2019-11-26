import greenfoot.*;


public class RotatingMovementStrategy implements IProjectileMoveStrategy 
{
    private int speed;
    private Projectile projectile;
    private int isReverse;
    private int angle = 0;
    
    public RotatingMovementStrategy(int isReverse){
        this.isReverse = isReverse;
    }
    
    public void setProjectile(Projectile projectile){
        this.projectile = projectile;
    }
    
    public void moveProjectile(){
        this.projectile.setRotation(0);
        this.projectile.move(isReverse * this.projectile.getSpeed());
        this.projectile.setRotation(angle%360 +20);
        angle+=10;
    }
    
    public void rotateProjectile(){
        
    }
    
    public void changeSpeed(int speed){
    }
    
    private int getRandomNumber(int s,int e)
    {
       return 0;
    }
}
