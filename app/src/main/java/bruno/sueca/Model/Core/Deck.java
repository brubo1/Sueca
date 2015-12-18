package bruno.sueca.Model.Core;
import java.util.Collections;
import java.util.Stack;
/**
 * This class represents a deck of cards.
 * Created by Bruno on 10/11/2015.
 */
public class Deck {

    private Stack<Card> aCards;

    /**
     * Create a deck of 40 cards
     */
    public Deck(){
        aCards = new Stack<>();
        reset();
        shuffle();
    }

    /**
     * resets the deck of cards
     */
    public void reset(){
        aCards.clear();
        for( Suit suit : Suit.values() ){
            for( Rank rank : Rank.values()){
                aCards.push( new Card( rank, suit ) );
            }
        }
    }

    /**
     * Shuffles the deck
     */
    public void shuffle(){
        Collections.shuffle(aCards);
    }

    /**
     * Draw card from the deck
     * @return the card drawn
     */
    public Card draw(){
        return aCards.pop();
    }

    /**
     *
     * @return the number of cards left in the deck
     */
    public int size(){
        return aCards.size();
    }
}
