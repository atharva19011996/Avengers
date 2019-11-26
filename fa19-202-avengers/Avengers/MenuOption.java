import greenfoot.*;

/** Menu Option */
public class MenuOption extends Actor implements IMenuInvoker 
{
    private IMenuCommand cmd ;

    /**
     * Set Command for Menu Option
     * @param c [description]
     */ 
    public void setCommand( IMenuCommand c ) {
        cmd = c ;
    }
    /** Invoke Menu Option */
    public void invoke() 
    {
        cmd.execute() ;
    }
     public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            invoke();
        }
    }    
    
    public void click(){
    }
}