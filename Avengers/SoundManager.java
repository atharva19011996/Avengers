import greenfoot.*; 

/**
 * Write a description of class SoundManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoundManager 
{
    private static SoundManager manager = null;
    private GreenfootSound sound;
    
    private SoundManager()
    {
        sound = new GreenfootSound ("title.mp3");
    }
    
    
    public synchronized static SoundManager getInstance() {
        if (manager == null) {
            manager = new SoundManager();
        }
        return manager;
    }

    public void setNewSound(String src) {
        sound = new GreenfootSound(src + ".mp3");
    }
    
    public GreenfootSound getSound() {
        return sound;
    }
    
    public void playSound() {
        sound.play();
        sound.setVolume(40);
    }
    
    public void stopSound() {
        sound.stop();
    }
    
    public void playStaticSound(String str) {
        Greenfoot.playSound(str);
    }
    
    
}
