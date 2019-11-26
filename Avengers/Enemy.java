import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Enemy extends Actor
{
    protected int health;
    protected int rotation = 0;
    protected Player player;
    protected Counter counter;
    protected int hitImageCounter = 0;
    protected int defaultImageCounter = 1;
    protected int imgNum = 0;
    protected int damage;
    protected int projSpeed;
    protected int projDamage;
    protected int shootTime = 200;
    public Enemy(Player mainPlayer, Counter counter) {
        this.counter = counter;
        player = mainPlayer;        
    }
    
    /**
    * Act - do whatever the Enemy wants to do. This method is called whenever
    * the 'Act' or 'Run' button gets pressed in the environment.
    */
    public void act() 
    {
       shootTime--;
       if(getY() <= 73){
           setLocation(getX(),73);
            }
       else if(getY() > 727){
            setLocation(getX(),727);
            }   
       moveAround();
       if (shootTime == 0) {
           fireProjectile();
           shootTime = 200;
       }
       hitByProjectile();        
    }    
    
    public void moveAround() {
        if (this.hitImageCounter > 0)
            this.hitImageCounter--;
        else 
            setDefaultImage();
        turnTowards(player.getX(), player.getY());
        move(1);
        setRotation(0);
    } 
    
    public void hitByProjectile() {
        
            
        HeroProjectile projectile = (HeroProjectile) getOneIntersectingObject(HeroProjectile.class);
        Actor superprojectile = getOneIntersectingObject(SuperProjectile.class);
        
        if(projectile != null)
        {
            health -= projectile.getDamage();
            setHitImage();
            getWorld().removeObject(projectile);
        }
        if(superprojectile != null)
        {
            counter.score++;
            getWorld().removeObject(superprojectile);
            getWorld().removeObject(this);
        }
        
        if (health <= 0) {
            counter.score++;
           getWorld().removeObject(this);
        }
        
      
        
    }
    
    
    public void setHitImage() {
        this.hitImageCounter = 50;
        setImage("/enemy/" + this.getClass().getName().toLowerCase() + "/" + "hit.png");
        checkFlip();
        setScaling(); 
    }
    
    public void setDefaultImage() {  
        defaultImageCounter--;
        if (defaultImageCounter == 0) {
            defaultImageCounter = 20;
            imgNum =(imgNum + 1) % 2;
            setImage("/enemy/" + this.getClass().getName().toLowerCase() + "/" + imgNum + ".png");
            checkFlip();
        }
        setScaling();
    }
    
    public void checkFlip() {        
         if (getX() < player.getX())
            getImage().mirrorHorizontally();                                                                                                        
    }
    
    public void setScaling() {}
    
    public int getDamage() {
        return this.damage;
    }
    
    public abstract void fireProjectile();
}
