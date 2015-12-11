package bruno.sueca.Model;

/**
 * Created by God Bruno on 11/12/2015.
 */
public interface GameObserver {

    /**
     * notify the observer of a finished set.
     */
    void notifyFinishedSet( Team pFirstTeam, Team pSecondTeam);
}
