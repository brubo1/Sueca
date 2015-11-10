package bruno.sueca;

import java.util.HashSet;

/**
 * This class represents a hand of cards.
 * Created by God Bruno on 10/11/2015.
 */
public class Hand {

    private HashSet aCards;

    /**
     * Adds a card to the hand.
     */
    public void addCard(Card pCard){
        this.aCards.add(pCard);
    }
    //TODO
}
