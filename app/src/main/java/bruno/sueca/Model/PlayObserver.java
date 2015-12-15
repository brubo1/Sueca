package bruno.sueca.Model;

import bruno.sueca.Model.Card.Card;
import bruno.sueca.Model.Card.Suit;
import bruno.sueca.Model.Player.Player;

/**
 * Observes each play.
 * Created by Bruno on 11/12/2015.
 */
public interface PlayObserver {
    Player notifyFinishedPlay( PlayedCards pPlayedCards );
    void setTrump(Suit pTrump);
    void notifyCardPlayed( Card pCard );
}
