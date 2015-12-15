package bruno.sueca.Model.Card;

import java.util.ArrayList;

/**
 * The use of tuple would be better.
 * Created by Bruno on 15/12/2015.
 */
public class TricksCalculator {

    private ArrayList<Rank> aValuableRanks;
    private ArrayList<Integer> aValues;
    private int NO_POINTS = 0;

    public TricksCalculator(){
        aValuableRanks = new ArrayList<Rank>();
        aValues = new ArrayList<Integer>();

        aValuableRanks.add( Rank.QUEEN);
        aValuableRanks.add( Rank.JACK);
        aValuableRanks.add( Rank.KING);
        aValuableRanks.add( Rank.SEVEN);
        aValuableRanks.add( Rank.ACE);
        aValues.add( 2 );
        aValues.add( 3 );
        aValues.add( 4 );
        aValues.add( 10 );
        aValues.add( 11 );
    }

    public int getValue( Card pCard) {
        if (aValuableRanks.contains(pCard.getRank())) {
            return aValues.get(aValuableRanks.indexOf(pCard.getRank()));
        }else{
            return NO_POINTS ;
        }
    }
}
