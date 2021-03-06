package bruno.sueca.Model.Core;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * This class represents a hand of cards.
 * Created by Bruno on 10/11/2015.
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
        this.aCards.remove( pCard );
    }

    /**
     * Clears the hand of all its cards.
     */
    public void clear() {
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
    public void drawCard(Card pCard) {
        this.aCards.add(pCard);
    }

    /**
     * Check if the hand has a card of suit pPlaySuit
     * @param pPlaySuit The suit in play
     * @return true if the hand has a cord of the suit pPlaySuit
     */
    public boolean hasSuit( Suit pPlaySuit){
        for(Card card : this.aCards){
            if(card.getSuit().equals(pPlaySuit)){
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the list of cards for the AI to play.
     * @return the list of cards.
     */
    public  ArrayList<Card> getCards(){
        ArrayList<Card> cards = new  ArrayList<Card>();
        int i = 0;
        for ( Card card : aCards){
            cards.add( card );
            i++;
        }
        return cards;
    }

    /**
     * Gets the list of cards that has the suit pPlaySuit
     * @param pPlaySuit
     * @return a list of cards with suit pPlaySuit.
     */
    public ArrayList<Card> getCards(Suit pPlaySuit){
        ArrayList<Card> cards = new ArrayList<Card>();
        int i = 0;
        for ( Card card : aCards){
            if( card.getSuit().equals(pPlaySuit)){
                cards.add( card );
            }
            i++;
        }
        return cards;
    }

    /**
     * Check if the current hand has the card
     * @param pCard a Card
     * @return true if the card is in the hand
     */
    public boolean contain( Card pCard ){

        for ( Card card : aCards ){
            if( card.equals( pCard )){
                return true;
            }
        }
        return false;
    }

    /**
     * Describes the Hand.
     * @return The description of the hand.
     */
    public String toString(){
        String result = "[";
        for ( Card card : this.aCards ){
            result = result + " " + card.toString() + ",";
        }
        result = result.substring(0, result.lastIndexOf(","));
        result = result + " ]";
        return result;
    }

}
