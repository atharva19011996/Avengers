/**
 * Write a description of class IScoreBoardHealthSubject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IScoreBoardHealthSubject  
{
    public void registerScoreBoardHealthObserver(IScoreBoardHealthObserver observer);
    public void unregisterScoreBoardHealthObserver(IScoreBoardHealthObserver observer);
    public void notifyScoreBoardForHealthUpdate(int health);
}
