import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{ 
    int count = 0;
    int spawnSpeed = 125;
    int randomSpawn;
    public Player mainPlayer;
    Counter counter = new Counter();
    HealthBar healthbar;
    SuperPowerBar superbar;
    PlayerStateMachine psm;
    NextLevel nextLevel = new NextLevel();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld(Player player)
    { 
        super(1200, 800, 1); 
        this.mainPlayer = player;
        healthbar = new HealthBar(mainPlayer.getHealth());
        mainPlayer.registerScoreBoardHealthObserver(healthbar);
        superbar = new SuperPowerBar(player);
        psm = new PlayerStateMachine(player);
        this.setBackground( new GreenfootImage("./images/ThorSpaceImage.png"));
        
        SoundManager manager = SoundManager.getInstance();
        manager.stopSound();
        manager.setNewSound("lvl1");
        manager.playSound();
       
        addObject(mainPlayer, 100, getHeight() / 2);
        addObject(psm, 0, 0);
        addObject(counter, 100, 80);
        addObject(healthbar, 1100, 80);
        addObject(superbar, 1000,90);
    }
    
    public Player getPlayer()
    {
        return mainPlayer;
    }
    
    public void spawnEnemies () {
        if (count % spawnSpeed == 0)
        {
            randomSpawn = Greenfoot.getRandomNumber(5);
            switch (randomSpawn) {
                case 0: addObject(new Elf(mainPlayer, counter), getWidth(), 0); break;
                case 1: addObject(new Ultron(mainPlayer, counter), getWidth(), getHeight() / 4); break;
                case 2: addObject(new Elf(mainPlayer, counter), getWidth(), getHeight() / 2); break;
                case 3: addObject(new Ultron(mainPlayer, counter), getWidth(), 3 *getHeight() / 4); break;
                case 4: addObject(new Elf(mainPlayer, counter), getWidth(), getHeight()); break;
            }            
        }
    }

    public void nextLevelProgressCheck(){
        if(counter.score == 10){
            // Need to change subsequent levels when world class is changed.
            mainPlayer.levelComplete(1);
            
        }
    }
    
    public void nextLevelTransition(){
        Greenfoot.setWorld(new Level2(mainPlayer));
    }
    
    public void act() {
        count++;
        spawnEnemies();
        nextLevelProgressCheck();
        //Greenfoot.start();
            
    }
}
