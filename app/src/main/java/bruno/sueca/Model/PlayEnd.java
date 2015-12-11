package bruno.sueca.Model;

import bruno.sueca.Model.Card.Card;
import bruno.sueca.Model.Card.Suit;

/**
 * Created by God Bruno on 11/12/2015.
 */

public class PlayEnd implements PlayObserver {
    private Suit aTrump;

    /**
     * Resolves the player who won the play
     * @param pCards Cards played
     * @param pFirstCard position of the first card played
     */
    @Override
    public void notifyFinishedPlay(Card[] pCards, int pFirstCard) {
        Card BestCard = pCards[pFirstCard];

        for( int i = 0 ; i < 4 ; i++ ){
            if( i != pFirstCard ){

                if( pCards[i].isTrump( aTrump ) && !BestCard.isTrump( aTrump ) ){       // trump / not trump
                    BestCard = pCards[i];
                }else if( pCards[i].isTrump( aTrump ) && BestCard.isTrump( aTrump )){   // trump / trump
                    if( BestCard.compareTo(pCards[i])> 0 ){
                        BestCard = pCards[i];
                    }else{

                    }
                }else if( !pCards[i].isTrump( aTrump )  && BestCard.isTrump( aTrump ) ){// not trump / trump

                }else{
                    if( BestCard.compareTo(pCards[i])> 0 ){                             // not trump / not trump
                        BestCard = pCards[i];
                    }
                }
            }
        }
        //TODO TO TEST
    }

    /**
     * Sets the Trump suit.
     * @param pTrump
     */
    @Override
    public void setTrump(Suit pTrump) {
        aTrump = pTrump;
    }
}
