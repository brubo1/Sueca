package bruno.sueca.Model.Player;

import java.util.ArrayList;
import java.util.Random;

import bruno.sueca.Model.Core.Card;
import bruno.sueca.Model.Core.Hand;
import bruno.sueca.Model.Core.Suit;
import bruno.sueca.Model.Core.Team;

/**
 * This AI will play legal cards randomly.
 * A legal card is a card that satisfies the suit in play.
 * Created by Bruno on 15/12/2015.
 */
public class EasyAI extends AI {
    Hand aHand;
    private Card aTrumpCard;

    public EasyAI(){
        aHand = new Hand();
    }

    @Override
    Card decideCard(Suit pPlaySuit, Card pWinningCard, Team pWinningTeam) {

        ArrayList<Card> cards;
        Card cardtoplay;
        Random number = new Random();
        int randomnumber;

        if( !this.aHand.hasSuit(pPlaySuit) || pPlaySuit == null ){ //the hand does not have the suit or he is the first player.
            cards = aHand.getCards();
            randomnumber = number.nextInt( cards.size() );
            cardtoplay = cards.get( randomnumber);
        }else{
            cards = aHand.getCards(pPlaySuit);
            randomnumber = number.nextInt(cards.size());
            cardtoplay = cards.get( randomnumber );
        }

        playCard( cardtoplay, pPlaySuit );

        return cardtoplay;
    }

    @Override
    public boolean Deal() {
        return new Random().nextBoolean();
    }

    @Override
    public void drewFromDeck(Card pCard) {
        aHand.DrawCard(pCard);
    }

    /**
     * For the AI it will be assumed that the card played is legal.
     * @param pCard Card played.
     * @param pPlaySuit Suit which must be played
     */
    @Override
    public void playCard(Card pCard, Suit pPlaySuit) {
        aHand.playCard(pCard);
    }

    @Override
    public void setTrumpCard(Card pTrumpCard) {
        aTrumpCard = pTrumpCard;
    }
}
