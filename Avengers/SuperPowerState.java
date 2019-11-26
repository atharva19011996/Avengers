/**
 * Write a description of class SuperPowerState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SuperPowerState implements AnimationState
{
    private PlayerStateMachine psm;
    private Player player;
    public SuperPowerState (PlayerStateMachine psm, Player player)
    {
        this.psm = psm;
        this.player = player;
    }
    public void attack()
    {
        psm.setAnimationState(new AttackingState(psm, player));
    }
    public void flipHorizontally()
    {
    }
    public void superPower()
    {
        if (player.isSuperPowerReady())
            psm.setAnimationState(new SuperPowerState(psm, player));
    }
    public void initAnimation()
    {
        player.setImage(player.getSuperPowerImage());
        player.fireSuperPower();
        psm.setAnimationTime(player.getSuperDuration());
    }
    public void autoStateChange()
    {
        psm.setAnimationState(new IdleState(psm, player));
    }
}
