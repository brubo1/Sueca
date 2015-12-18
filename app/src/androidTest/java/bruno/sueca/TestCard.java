package bruno.sueca;

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
    public void testconstruction(){

        aWithInts = new Card( 7, 3);
        aWithRankSuit = new Card(Rank.KING, Suit.HEARTS);
        assertSame( aWithInts, aWithRankSuit);

    }

}
