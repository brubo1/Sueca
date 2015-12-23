package bruno.sueca.Core;

import junit.framework.TestCase;

import bruno.sueca.Model.Core.Card;
import bruno.sueca.Model.Core.Rank;
import bruno.sueca.Model.Core.Suit;

/**
 * Created by Bruno on 18/12/2015.
 */
public class TestCard extends TestCase {

    protected Card aWithInts;
    protected Card aWithRankSuit;

    /*
    Build a king of hearts
     */
    public void testContruction(){

        aWithInts = new Card( 7, 3);
        aWithRankSuit = new Card(Rank.KING, Suit.HEARTS);
        assertTrue( aWithInts.equals( aWithRankSuit) );

    }

    public void testCompareTo(){
        aWithInts = new Card( 7, 3);
        aWithRankSuit = new Card(Rank.KING, Suit.HEARTS);
        assertTrue( aWithInts.compareTo( aWithRankSuit ) == 0 );
    }

    /**
     *PlayEnd was fixed accordingly
     */
    public void testCompateTo(){
        aWithInts = new Card( 7, 3);
        aWithRankSuit = new Card(Rank.KING, Suit.HEARTS);
        assertTrue( aWithRankSuit.compareTo( new Card (Rank.SEVEN , Suit.HEARTS) ) == -1 );
    }
}
