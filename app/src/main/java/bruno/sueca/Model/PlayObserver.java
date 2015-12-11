package bruno.sueca.Model;

import bruno.sueca.Model.Card.Card;
import bruno.sueca.Model.Card.Suit;

/**
 * Created by God Bruno on 11/12/2015.
 */
public interface PlayObserver {


    void notifyFinishedPlay(Card[] pCards, int pFirstCard);
    void setTrump(Suit pTrump);
}
