/**
 * Write a description of class PlayerFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerFactory  
{

    /**
     * Constructor for objects of class PlayerFactory
     */
    public PlayerFactory()
    {
    }

    public IPlayer getPlayer(String playerName){
        if(playerName == null){
            return null;
         }		
         if(playerName.equalsIgnoreCase("THOR")){
            return new Thor();
            
         } else if(playerName.equalsIgnoreCase("IRONMAN")){
            return new IronMan();
            
         } else if(playerName.equalsIgnoreCase("DrStrange")){
            return new DocStrange();
         }
         else if(playerName.equalsIgnoreCase("HAWKEYE")){
            return new HawkEye();
         }
         else if(playerName.equalsIgnoreCase("CAPTAINAMERICA")){
            return new CapAmerica();
         }
         else if(playerName.equalsIgnoreCase("SPIDERMAN")){
            return new SpiderMan();
         }
         
         return null;
    }

}
