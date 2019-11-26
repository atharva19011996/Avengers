import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends MyWorld
{
    int currentLevel = 3;
    /**
     * Constructor for objects of class Level3.
     * 
     */
    public Level3(Player player)
    {    
        super(player);
        this.setBackground( new GreenfootImage("./images/TimeStoneLevel.jpg"));
        SoundManager manager = SoundManager.getInstance();
        manager.stopSound();
        manager.setNewSound("lvl3");
        manager.playSound();
    }
    public void spawnEnemies () {
        if (count % spawnSpeed == 0)
        {
            randomSpawn = Greenfoot.getRandomNumber(8);
            switch (randomSpawn) {
                case 0: addObject(new Elf(mainPlayer, counter), getWidth(), 0); break;
                case 1: addObject(new Ultron(mainPlayer, counter), getWidth(), getHeight() / 4); break;
                case 2: addObject(new Loki(mainPlayer, counter), getWidth(), getHeight() / 2); break;
                case 3: addObject(new GreenGoblin(mainPlayer, counter), getWidth(), 3 *getHeight() / 4); break;
                case 4: addObject(new Loki(mainPlayer, counter), getWidth(), getHeight()); break;
                case 5: addObject(new Ultron(mainPlayer, counter), 0, getHeight() / 2); break;
                case 6: addObject(new GreenGoblin(mainPlayer, counter), 0, 3 *getHeight() / 4); break;
                case 7: addObject(new Loki(mainPlayer, counter), 0, getHeight() / 2); break;
            }            
        }
    }
    
    public void nextLevelTransition(){
        Greenfoot.setWorld(new Level4(mainPlayer));
    }
    public void nextLevelProgressCheck(){
        if(counter.score == 30){
            // Need to change subsequent levels when world class is changed.
            mainPlayer.levelComplete(3);
        }
    }
    
    public void act() {
        count++;
        spawnEnemies();
        nextLevelProgressCheck();
    }
}
