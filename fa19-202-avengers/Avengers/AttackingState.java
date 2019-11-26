/**
 * Write a description of class AttackingState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AttackingState implements AnimationState
{
    private PlayerStateMachine psm;
    private Player player;
    public AttackingState (PlayerStateMachine psm, Player player)
    {
        this.psm = psm;
        this.player = player;
    }
    public void attack()
    {
        //psm.setAnimationState(new AttackingState(psm, player));
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
        player.setImage(player.getAttackingImage());
        player.fireProjectile();
        psm.setAnimationTime(10);
    }
    public void autoStateChange()
    {
        psm.setAnimationState(new IdleState(psm, player));
    }
}
