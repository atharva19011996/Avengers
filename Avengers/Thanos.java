import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Thanos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Thanos extends Actor implements IScoreBoardHealthSubject
{
    protected int health = 400;
    protected int damage = 10;
    protected Counter counter;
    protected Player player;
    protected int hitImageCounter = 0;
    protected int defaultImageCounter = 1;
    protected int imgNum = 0;
    int randomX, randomY;
    int timer = 0, spaceStoneTimer = 0,warmholeTimer = 0;
    int shootTime = 500;
    Boolean flag = true;
    GreenfootImage wormhole = new GreenfootImage("./images/enemy/thanos/wormhole.jpg");
    private IScoreBoardHealthObserver observer;
    
    public Thanos(Player mainPlayer, Counter counter) {
        this.counter = counter;
        this.player = mainPlayer;
        wormhole.scale(170,120);
        setImage("/enemy/" + this.getClass().getName().toLowerCase() + "/" + "0.png");
    }
    
    public void act(){
        displayInfo();
        timer++;
        warmholeTimer++;
        spaceStoneTimer++;
        changeLocation();
        shootTime--;
        if (shootTime == 0) {
           fireProjectile();
           shootTime = 500;
       }
        moveAround();
        hitByProjectile();
       
    }  
    public void mirrorImage()
    {
        if (getX() < player.getX())
                        getImage().mirrorHorizontally();
    }
    public void moveAround() {
        if (this.hitImageCounter > 0)
            this.hitImageCounter--;
            
        else 
            {
                 if(spaceStoneTimer >= 400 && spaceStoneTimer <= 500)
                    {
                        setImage("/enemy/thanos/t.png");
                         mirrorImage();
                        getImage().scale(200, 250);
                        if(warmholeTimer >= 450 && warmholeTimer <= 500)
                        {
                            getWorld().getBackground().drawImage(wormhole, getX() - 80, getY() + 100);
                            warmholeTimer = 0;
                        }

                    }
                    
                else
                setDefaultImage();
            }
        
        setRotation(0);
    } 
    
    public void setScaling() {
        GreenfootImage image = getImage();
        image.scale(200, 250);
    }
    
    public void fireProjectile() {        
        getWorld().addObject(new ThanosProjectile(player, this.getX(),getX() < player.getX()), getX(), getY());
    }
    
    public void hitByProjectile() {
        
        HeroProjectile projectile = (HeroProjectile) getOneIntersectingObject(HeroProjectile.class);
        Actor superprojectile = getOneIntersectingObject(SuperProjectile.class);
        
        if(projectile != null)
        {
            //health -= projectile.getDamage();
            notifyScoreBoardForHealthUpdate(projectile.getDamage());
            setHitImage();
            getWorld().removeObject(projectile);
        }
        if(superprojectile != null)
        {
            //counter.score++;
            notifyScoreBoardForHealthUpdate(50);
            setHitImage();
            getWorld().removeObject(superprojectile);
            //getWorld().removeObject(this);
        }
        
        if (health <= 0) {
           getWorld().removeObject(this);
        }
        
    }
    
    public void setHitImage() {
        this.hitImageCounter = 50;
        setImage("/enemy/" + this.getClass().getName().toLowerCase() + "/" + "hit.png");
        getImage().mirrorHorizontally();
        setScaling(); 
    }
    
    public void setDefaultImage() {  
             mirrorImage();
             setRandomImage();
             setScaling();
         
    }
    
    public void changeLocation()
    {
        
        if(timer % 500 == 0)
        {
            randomX = Greenfoot.getRandomNumber(900);
            randomY = Greenfoot.getRandomNumber(500);
            if(randomX <= player.getX() - 50 || randomX == player.getX() + 50)
            {
                randomX += 300;
            }
            
            this.setLocation(randomX, randomY);
            spaceStoneTimer = 0;
            getWorld().setBackground("../images/PowerStoneLevel.jpg");
            setRandomImage();
        }
    }
    
    
    public void setRandomImage()
    {
        int randomSpawn = Greenfoot.getRandomNumber(4);
            switch (randomSpawn) {
                case 0: setImage("/enemy/" + this.getClass().getName().toLowerCase() + "/" + "0.png"); break;
                case 1: setImage("/enemy/" + this.getClass().getName().toLowerCase() + "/" + "p1.png"); break;
                case 2: setImage("/enemy/" + this.getClass().getName().toLowerCase() + "/" + "p2.png"); break;
                case 3: setImage("/enemy/" + this.getClass().getName().toLowerCase() + "/" + "p3.png"); break;
                case 4: setImage("/enemy/" + this.getClass().getName().toLowerCase() + "/" + "p1.png"); break;
            }  
             mirrorImage();
    }
    
    
    public void displayInfo() {
        GreenfootImage character = new GreenfootImage("./images/thanos.png");
        character.scale(70,70);
        getWorld().getBackground().drawImage(character, 580, 690 );
        
    }
    
    public void registerScoreBoardHealthObserver(IScoreBoardHealthObserver observer){
        this.observer = observer;
    }
    
    public void unregisterScoreBoardHealthObserver(IScoreBoardHealthObserver observer){
        
    }
    
    public void notifyScoreBoardForHealthUpdate(int damage){
        observer.updateScoreBoardHealth(damage);
    }
    
}
