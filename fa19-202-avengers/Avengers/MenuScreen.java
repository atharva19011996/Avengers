import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuScreen extends World
{

    IMenuInvoker thorMenuOption;
    IMenuInvoker ironManOption;
    IMenuInvoker capMenuOption ;
    IMenuInvoker drStrangeOption ;
    IMenuInvoker spiderManOption ;
    IMenuInvoker hawkEyeOption ;
    PlayerFactory playerFactory;
    
    IMenuCommand thorCommand;
    IMenuCommand ironManCommand;
    IMenuCommand capCommand;
    IMenuCommand drStrangeCommand;
    IMenuCommand spiderManCommand;
    IMenuCommand hawkCommand;
    
     /* Constructor for objects of class MenuScreen.
     * 
     */
    public MenuScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        thorMenuOption = new MenuOption();
        ironManOption = new MenuOption();
        capMenuOption = new MenuOption();
        drStrangeOption = new MenuOption();
        spiderManOption = new MenuOption();
        hawkEyeOption = new MenuOption();

        playerFactory = new PlayerFactory();

        thorCommand = new MenuCommand();
        ironManCommand = new MenuCommand();
        capCommand = new MenuCommand();
        drStrangeCommand = new MenuCommand();
        spiderManCommand = new MenuCommand();
        hawkCommand = new MenuCommand();

        ((Actor)thorMenuOption).setImage("images/MenuThor.jpg");
        ((Actor)ironManOption).setImage("images/MenuIron.jpg");
        ((Actor)capMenuOption).setImage("images/MenuCap.jpg");
        ((Actor)spiderManOption).setImage("images/MenuBlack.jpg");
        ((Actor)drStrangeOption).setImage("images/MenuHulk.jpg");
        ((Actor)hawkEyeOption).setImage("images/MenuHawk.jpg");
        
        thorMenuOption.setCommand(thorCommand);
        ironManOption.setCommand(ironManCommand);
        capMenuOption.setCommand(capCommand);
        drStrangeOption.setCommand(drStrangeCommand);
        spiderManOption.setCommand(spiderManCommand);
        hawkEyeOption.setCommand(hawkCommand);
        
        thorCommand.setReceiver(() -> {
            //get world from factory
            // inside factory get player from another factory
            Greenfoot.setWorld(new MyWorld((Player)playerFactory.getPlayer("THOR")));
        });
        
        ironManCommand.setReceiver(() -> {
            Greenfoot.setWorld(new MyWorld((Player)playerFactory.getPlayer("IRONMAN")));
        });
        
        capCommand.setReceiver(() -> {
            Greenfoot.setWorld(new MyWorld((Player)playerFactory.getPlayer("CAPTAINAMERICA")));
        });
        
        drStrangeCommand.setReceiver(() -> {
            Greenfoot.setWorld(new MyWorld((Player)playerFactory.getPlayer("DrStrange")));
        });
        
        spiderManCommand.setReceiver(() -> {
            Greenfoot.setWorld(new MyWorld((Player)playerFactory.getPlayer("SPIDERMAN")));
        });
        
        hawkCommand.setReceiver(() -> {
            Greenfoot.setWorld(new MyWorld((Player)playerFactory.getPlayer("HAWKEYE")));
        });
        
        displayStats(((Actor)thorMenuOption), 100,60); // Thor
        displayStats(((Actor)ironManOption), 87,72); // ironman
        displayStats(((Actor)capMenuOption),  75,60); //cap
        displayStats(((Actor)drStrangeOption),  40,100); //
        displayStats(((Actor)spiderManOption), 55,72); //
        displayStats(((Actor)hawkEyeOption), 50,80); //
        
        
        addObject((Actor)thorMenuOption, 111, 402);       
        addObject((Actor)ironManOption, 337, 402); 
        addObject((Actor)capMenuOption, 565, 402); 
        addObject((Actor)drStrangeOption, 767, 402); 
        addObject((Actor)spiderManOption, 939, 402); 
        addObject((Actor)hawkEyeOption, 1118, 402); 
        
        
    }
    
    public void displayStats(Actor actor,int herohealth, int projectileDamage)
    {
        
        GreenfootImage health = new GreenfootImage("./images/health.png");
        GreenfootImage superpower = new GreenfootImage("./images/power.png");
        health.scale(30,30);
        superpower.scale(30,30);
        actor.getImage().drawImage(health, 30, 545 );
        actor.getImage().drawImage(superpower, 30, 585 );
        
        
        actor.getImage().setColor(Color.RED);
        actor.getImage().drawRect(60,555,99,11);
        actor.getImage().fillRect(60,555,herohealth,10);
        
        actor.getImage().setColor(Color.BLUE);
        actor.getImage().drawRect(60, 590,99,11);
        actor.getImage().fillRect(60,590,projectileDamage,13);
        
    }
}
