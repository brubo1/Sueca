package bruno.sueca.Team.Player;

import java.util.HashSet;
import java.util.Iterator;

import bruno.sueca.Card.Card;

/**
 * This class represents a hand of cards.
 * Created by God Bruno on 10/11/2015.
 */
public class Hand {

    private HashSet<Card> aCards;

    /**
     * Constructor of a Hand
     */
    public Hand(){
        aCards = new HashSet<>();
    }

    /**
     * Play the card requested
     * @param pCard Card to be removed from the hand.
     */
    public void playCard(Card pCard){
        this.aCards.remove(pCard);
    }

    /**
     * Clears the hand of all its cards.
     */
    public void clear(){
        this.aCards.clear();
    }

    /**
     * gets the number of cards
     * @return The number of cards in the hand.
     */
    public int size(){
        return this.aCards.size();
    }

    /**
     * Draw a card from the deck.
     * @param pCard Card drawn from the deck.
     */
    public void DrawCard(Card pCard) {
        this.aCards.add(pCard);
    }

    /**
     * Describes the Hand.
     * @return The description of the hand.
     */
    public String toString(){
        String result = "[";
        for ( Iterator<Card> card = this.aCards.iterator(); card.hasNext() ; ){
            result = result + " " + card.toString();
        }
        result = result + "]";
        return result;
    }

}
