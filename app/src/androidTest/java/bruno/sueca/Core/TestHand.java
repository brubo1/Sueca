package bruno.sueca.Core;

import android.util.Log;

import junit.framework.TestCase;

import bruno.sueca.Model.Core.Card;
import bruno.sueca.Model.Core.Hand;
import bruno.sueca.Model.Core.Rank;
import bruno.sueca.Model.Core.Suit;

/**
 * Created by Bruno on 18/12/2015.
 */
public class TestHand extends TestCase {

    protected Hand aHand;

    private static final String TAG = "Hand";

    public void testToString(){
        aHand = new Hand();

        aHand.drawCard(new Card(Rank.ACE, Suit.HEARTS));
        aHand.drawCard(new Card(Rank.THREE, Suit.HEARTS));
        aHand.drawCard(new Card(Rank.FIVE, Suit.HEARTS));
        aHand.drawCard(new Card(Rank.SEVEN, Suit.HEARTS));
        aHand.drawCard(new Card(Rank.ACE, Suit.CLUBS));
        aHand.drawCard(new Card(Rank.THREE, Suit.CLUBS));
        aHand.drawCard(new Card(Rank.FIVE, Suit.SPADES));
        aHand.drawCard(new Card(Rank.SEVEN, Suit.SPADES));
        aHand.drawCard(new Card(Rank.ACE, Suit.DIAMONDS));

        Log.d(TAG, aHand.toString());
        assertTrue(true);
    }

    public void testContain(){
        aHand = new Hand();

        Card cardtoremove = new Card(Rank.ACE, Suit.HEARTS);
        aHand.drawCard( cardtoremove );
        aHand.drawCard(new Card(Rank.THREE, Suit.HEARTS));
        aHand.drawCard(new Card(Rank.FIVE, Suit.HEARTS));
        aHand.drawCard(new Card(Rank.SEVEN, Suit.HEARTS));
        aHand.drawCard(new Card(Rank.ACE, Suit.CLUBS));
        aHand.drawCard(new Card(Rank.THREE, Suit.CLUBS));
        aHand.drawCard(new Card(Rank.FIVE, Suit.SPADES));
        aHand.drawCard(new Card(Rank.SEVEN, Suit.SPADES));
        aHand.drawCard(new Card(Rank.ACE, Suit.DIAMONDS));

        assertTrue(!aHand.contain(new Card(Rank.SIX, Suit.HEARTS)));
        assertTrue( aHand.contain( new Card(Rank.THREE, Suit.CLUBS) ) );
    }
}
