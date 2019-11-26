import greenfoot.*;

public interface IProjectileMoveStrategy  
{
    /**
     * sets the projectile on which strategy needs to be applied.
     */
    public void setProjectile(Projectile projectile);
    
    /**
     * moves the projectile
     */
    public void moveProjectile();
    
    /**
     * rotates the projectile
     */
    public void rotateProjectile();
    
    /**
     * chages the moving speed of projectile
     */
    public void changeSpeed(int speed);
}