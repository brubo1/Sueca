package bruno.sueca.Model.Core;

import bruno.sueca.Model.Player.Player;

/**
 * Observes each play.
 * Created by Bruno on 11/12/2015.
 */
public interface PlayObserver {
    Player notifyPlayEnd(PlayedCards pPlayedCards);
    int notifyCardPlayed(PlayedCards pPlayedCards, int pCurrentPlayer);
    void setTrump(Suit pTrump);
}
