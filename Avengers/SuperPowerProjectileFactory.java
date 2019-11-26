/**
 * Write a description of class SuperPowerProjectileFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SuperPowerProjectileFactory  
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class SuperPowerProjectileFactory
     */
    public SuperPowerProjectileFactory()
    {
    }
    public SuperProjectile getSuperProjectile(String superprojName, Enemy target){
        if(superprojName == null){
            return null;
        }
        SuperProjectile returnproj = null;
        switch (superprojName.toUpperCase())
        {
            case "WEB" : returnproj = new TrackingWeb (target); break;
            case "MISSILE" : returnproj = new TrackingMissile (target); break;
            case "LIGHTNING" : returnproj = new LightningBall (); break;
            case "ARROW" : returnproj = new Arrow (target); break;
            case "CRACK" : returnproj = new SpaceCrack (); break;
        }
        return returnproj;
    }
}
