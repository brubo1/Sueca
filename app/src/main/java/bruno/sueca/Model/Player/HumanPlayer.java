package bruno.sueca.Model.Player;

import bruno.sueca.Model.Card.Card;
import bruno.sueca.Model.Card.Hand;
import bruno.sueca.Model.Card.Suit;

/**
 * A human player of the game.
 * Created by Bruno on 21/11/2015.
 */
public class HumanPlayer implements Player{

    private Hand aHand;             //hand of the player
    private Card aTrumpCard;
    /**
     * a Human player constructor.
     */
    public HumanPlayer(){
        aHand = new Hand();
    }
    @Override
    public void drewFromDeck(Card pCard) {
        aHand.DrawCard(pCard);
    }

    @Override
    public void playCard(Card pCard, Suit pPlaySuit) {
        if( pPlaySuit == null ) {pPlaySuit = pCard.getSuit();}  //if he is the first player make his suit the play suit.
        if( pCard.getSuit().equals(pPlaySuit)){
            aHand.playCard(pCard);
        }
        else if( !pCard.getSuit().equals(pPlaySuit) && !this.aHand.hasSuit(pPlaySuit) ){
            aHand.playCard( pCard );
        }else{
            //error
        }
    }

    @Override
    public void setTrumpCard(Card pTrumpCard) {
        aTrumpCard = pTrumpCard;
    }

    /**
     * Decide whether deal himself first
     * @return It returns true if he decides to deal himself first.
     */
    @Override
    public boolean Deal() {
        return false;
    }


}
