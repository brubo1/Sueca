package bruno.sueca.Model.Core;

import bruno.sueca.Model.Player.Player;

/**
 * Observes each plays.
 * Created by Bruno on 11/12/2015.
 */

public class PlayEnd implements PlayObserver {
    private Suit aTrump;
    private int aCurrentWinner;

    /**
     * Resolves the player who won the play
     * @param pPlayedCards Cards played this current play
     * @return The player who won the play.
     */
    @Override
    public Player notifyPlayEnd(PlayedCards pPlayedCards) {
        int winner = aCurrentWinner;
        reset();
        return pPlayedCards.getPlayer( winner );
    }

    @Override
    public int notifyCardPlayed(PlayedCards pPlayedCards, int pCurrentPlayer) {
        Card BestCard = pPlayedCards.getCard( aCurrentWinner );
        if(aCurrentWinner == -1 ){
            aCurrentWinner = 1;
        }else {

            if (pPlayedCards.getCard(pCurrentPlayer).isTrump(aTrump) && !BestCard.isTrump(aTrump)) {       // trump / not trump
                BestCard = pPlayedCards.getCard(pCurrentPlayer);
                aCurrentWinner = pCurrentPlayer;
            } else if (pPlayedCards.getCard(pCurrentPlayer).isTrump(aTrump) && BestCard.isTrump(aTrump)) {   // trump / trump
                if (BestCard.compareTo(pPlayedCards.getCard(pCurrentPlayer)) > 0) {
                    BestCard = pPlayedCards.getCard(pCurrentPlayer);
                    aCurrentWinner = pCurrentPlayer;
                }
            } else if (!pPlayedCards.getCard(pCurrentPlayer).isTrump(aTrump) && BestCard.isTrump(aTrump)) {// not trump / trump
                //do nothing
            } else {
                if (BestCard.compareTo(pPlayedCards.getCard(pCurrentPlayer)) > 0) {                             // not trump / not trump
                    BestCard = pPlayedCards.getCard(pCurrentPlayer);
                    aCurrentWinner = pCurrentPlayer;
                }
            }
        }
        pPlayedCards.setWinningCard( BestCard );
        return aCurrentWinner;
    }


    /**
     * Sets the Trump suit.
     * @param pTrump The trump card
     */
    @Override
    public void setTrump(Suit pTrump) {
        aTrump = pTrump;
    }

    private void reset(){
        aCurrentWinner = -1;
        aTrump = null;
    }
}
