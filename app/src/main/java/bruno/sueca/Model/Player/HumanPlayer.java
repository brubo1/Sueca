package bruno.sueca.Model.Player;

import bruno.sueca.Model.Card.Card;
import bruno.sueca.Model.Card.Suit;

/**
 * A human player of the game.
 * Created by God Bruno on 21/11/2015.
 */
public class HumanPlayer implements Player{

    private Hand aHand;             //hand of the player

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
    public void playCard(Card pCard, Suit pVasaSuit) {
        aHand.playCard(pCard);
    }
}
