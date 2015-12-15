package bruno.sueca.Model;

/**
 * Game observers
 * Created by Bruno on 11/12/2015.
 */
public interface GameObserver {

    /**
     * notify the observer of a finished set.
     */
    void notifyFinishedGame( Team pFirstTeam, Team pSecondTeam);
}
