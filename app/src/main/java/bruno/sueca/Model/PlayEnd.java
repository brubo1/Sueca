package bruno.sueca.Model;

import bruno.sueca.Model.Card.Card;
import bruno.sueca.Model.Card.Suit;
import bruno.sueca.Model.Player.Player;

/**
 * Observes each plays.
 * Created by Bruno on 11/12/2015.
 */

public class PlayEnd implements PlayObserver {
    private Suit aTrump;

    /**
     * Resolves the player who won the play
     * @param pPlayedCards Cards played this current play
     * @return The player who won the play.
     */
    @Override
    public Player notifyFinishedPlay( PlayedCards pPlayedCards) {
        Card BestCard = pPlayedCards.getCard( 0 );
        int winner = 0;

        for( int i = 1 ; i < 4 ; i++ ){
            if( pPlayedCards.getCard( i ).isTrump( aTrump ) && !BestCard.isTrump( aTrump ) ){       // trump / not trump
                BestCard = pPlayedCards.getCard( i );
                winner = i;
            }else if( pPlayedCards.getCard( i ).isTrump( aTrump ) && BestCard.isTrump( aTrump )){   // trump / trump
                if( BestCard.compareTo(pPlayedCards.getCard( i ))> 0 ){
                    BestCard = pPlayedCards.getCard( i );
                    winner = i;
                }
            }else if( !pPlayedCards.getCard( i ).isTrump( aTrump )  && BestCard.isTrump( aTrump ) ){// not trump / trump
                //do nothing
            }else{
                if( BestCard.compareTo(pPlayedCards.getCard( i ))> 0 ){                             // not trump / not trump
                    BestCard = pPlayedCards.getCard( i );
                    winner = i;
                }
            }
        }     //TODO TO TEST
        return pPlayedCards.getPlayer( winner );
    }


    /**
     * Sets the Trump suit.
     * @param pTrump The trump card
     */
    @Override
    public void setTrump(Suit pTrump) {
        aTrump = pTrump;
    }

    @Override
    public void notifyCardPlayed(Card pCard) {

    }
}
