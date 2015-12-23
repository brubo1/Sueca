package bruno.sueca.Core;

import android.util.Log;

import junit.framework.TestCase;

import bruno.sueca.Model.Core.Card;
import bruno.sueca.Model.Core.Rank;
import bruno.sueca.Model.Core.Suit;
import bruno.sueca.Model.Core.Team;
import bruno.sueca.Model.Player.AI;
import bruno.sueca.Model.Player.EasyAI;

/**
 * Created by Bruno on 18/12/2015.
 */
public class TestPlayer extends TestCase {

    private static final String TAG = "AI";

    /**
     * The easy ai does not care about the team and the best card.
     */
    public void testEasyAI (){

        AI ez = new EasyAI();
        ez.drewFromDeck( new Card(Rank.ACE, Suit.HEARTS));
        ez.drewFromDeck(new Card(Rank.THREE, Suit.HEARTS));
        ez.drewFromDeck(new Card(Rank.FIVE, Suit.HEARTS));
        ez.drewFromDeck(new Card(Rank.SEVEN, Suit.HEARTS));
        ez.drewFromDeck(new Card(Rank.ACE, Suit.CLUBS));
        ez.drewFromDeck(new Card(Rank.THREE, Suit.CLUBS));
        ez.drewFromDeck(new Card(Rank.FIVE, Suit.SPADES));
        ez.drewFromDeck(new Card(Rank.SEVEN, Suit.SPADES));
        ez.drewFromDeck(new Card(Rank.ACE, Suit.DIAMONDS));

        Log.d(TAG, ez.toString()); //initial hand

        Card card = ez.play( Suit.HEARTS, new Card(Rank.FOUR, Suit.CLUBS), new Team() );

        Log.d( TAG, card.toString() ); // card removed

        Log.d( TAG, ez.toString()); // final hand


        assertTrue( true );
    }

}
