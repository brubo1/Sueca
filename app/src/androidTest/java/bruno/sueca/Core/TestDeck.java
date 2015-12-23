package bruno.sueca.Core;

import android.util.Log;

import junit.framework.TestCase;

import bruno.sueca.Model.Core.Deck;

/**
 * Created by Bruno on 18/12/2015.
 */
public class TestDeck extends TestCase {

    protected Deck aDeck;

    private static final String TAG = "Deck";


    public void testSize(){
        aDeck = new Deck();
        Integer size = new Integer ( aDeck.size() );
        assertTrue(aDeck.size() == 40);
        Log.d( TAG, size.toString() );
    }
}
