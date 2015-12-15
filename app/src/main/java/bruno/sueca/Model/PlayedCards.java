package bruno.sueca.Model;

import java.util.ArrayList;

import bruno.sueca.Model.Card.Card;
import bruno.sueca.Model.Player.Player;

/**
 * Tracks the cards played in a play. It will link the played card to the player.
 * Created by Bruno on 15/12/2015.
 */
public class PlayedCards {

    private ArrayList<Card> aPlayedCards;
    private ArrayList<Player> aPlayers;

    public PlayedCards(){
        aPlayedCards = new ArrayList<Card>();
        aPlayers = new ArrayList<Player>();
    }
    /**
     *
     * @param pCard Card played
     * @param pPlayer Player who played pCard
     */
    public void addCards( Card pCard, Player pPlayer ){
        aPlayedCards.add( pCard );
        aPlayers.add( pPlayer );
    }

    public Card getCard(int index){
        return aPlayedCards.get( index );
    }
    public Player getPlayer(int index){
        return aPlayers.get( index );
    }

    public ArrayList<Card> getCards(){
        return aPlayedCards;
    }
}
