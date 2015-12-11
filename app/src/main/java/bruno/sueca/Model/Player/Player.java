package bruno.sueca.Model.Player;

import bruno.sueca.Model.Card.Card;
import bruno.sueca.Model.Card.Suit;

/**
 * This interface represents the responsibilities of the players.
 * Created by God Bruno on 20/11/2015.
 */
public interface Player {
    /**
     * Player drew card from deck.
     * @param pCard Card drawn from the deck.
     */
    void drewFromDeck(Card pCard);

    /**
     * Player played a card
     * @param pCard Card played.
     */
    void playCard(Card pCard, Suit pVasaSuit);
}
