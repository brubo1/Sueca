package bruno.sueca.Card;

import android.support.annotation.NonNull;

/**This class represents a card.
 * Created by God Bruno on 10/11/2015.
 */
public class Card implements Comparable<Card>{
    private final Rank aRank;
    private final Suit aSuit;

    /**
     * Creates a card
     * @param pRank rank of the card
     * @param pSuit suit of the card
     */
    public Card(Rank pRank, Suit pSuit){
        aRank = pRank;
        aSuit = pSuit;
    }
    public Card(int pRank, int pSuit){
        Rank Ranks[] = Rank.values();
        Suit Suits[] = Suit.values();

        aRank = Ranks[pRank];
        aSuit = Suits[pSuit];
    }

    public Rank getRank(){
        return aRank;
    }
    public Suit getSuit(){
        return aSuit;
    }

    /**
     * Description of the card
     * @return the card in the form of a string
     */
    public String toString(){
        return aRank + " of " + aSuit;
    }

    /**
     * check if two cards are identical
     * @param pCard card to be compared
     * @return true if identical
     */
    public boolean equals(Card pCard){
       return  ( this.compareTo(pCard) == 0 );
    }
    /**
     * Compares 2 cards to check if they are identical
     * @param pCard  is the card to be compared to
     * @return true if identical
     */
    public int compareTo(@NonNull Card pCard ){
        int difference = this.getRank().ordinal() - pCard.getRank().ordinal();

        if( difference == 0) //identical rank
        { 						//then return suits difference
            return this.getSuit().ordinal() - pCard.getSuit().ordinal(); //if zero they are identical otherwise they have different suit.
        }
        else
        {						//card have different ranks
            return difference;
        }
    }

    /**
     * Checks if the card is a trump card
     * @param pSuit Suit that defines trump cards
     * @return True if it is a trump card
     */
    public boolean isTrump(Suit pSuit) {
        int difference = this.aSuit.ordinal() - pSuit.ordinal();
        return (difference == 0);
    }
    /**
     * The hashcode for a card is the suit*10 + that of the rank (perfect hash).
     * @return the hashcode of the card
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        return this.getSuit().ordinal() * Rank.values().length + this.getRank().ordinal();
    }
}
