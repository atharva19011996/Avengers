import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level4 extends MyWorld
{
    int currentLevel = 4;
    Thanos thanos;
    ThanosHealthBar thealthbar = new ThanosHealthBar();
    public Level4(Player player)
    {
        
        super(player);
        thanos = new Thanos(player, counter);
        setBackground( new GreenfootImage("./images/PowerStoneLevel.jpg"));
        thanos.registerScoreBoardHealthObserver(thealthbar);
        addObject(thealthbar, 600, 780);
        SoundManager manager = SoundManager.getInstance();
        manager.stopSound();
        manager.setNewSound("lvl4");
        manager.playSound();
    }
    
    public void spawnEnemies () {
        addObject(thanos, getWidth() / 4, getHeight() / 4);
    }

    public void nextLevelProgressCheck(){
        if(counter.score == 10){
            // Need to change subsequent levels when world class is changed.
            // Greenfoot.setWorld(new Level3(mainPlayer));
            mainPlayer.levelComplete(4);
        }
    }
    
    public void act() {
        count++;
        spawnEnemies();
        nextLevelProgressCheck();
    }
}
