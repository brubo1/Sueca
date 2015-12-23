package bruno.sueca.Model.Core;

import java.util.ArrayList;

import bruno.sueca.Model.Player.Player;

/**
 * Tracks the cards played in a play. It will link the played card to the player.
 * Created by Bruno on 15/12/2015.
 */
public class PlayedCards {

    private ArrayList<Card> aPlayedCards;
    private ArrayList<Player> aPlayers;
    private int aWinner;

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

    /**
     * Clear the played cards and the players.
     */
    public void clear(){
        aPlayedCards.clear();
        aPlayers.clear();
    }
    public Card getCard(int index){
        return aPlayedCards.get( index );
    }
    public Player getPlayer(int index){
        return aPlayers.get( index );
    }

    public Suit getPlaySuit(){
        if(this.aPlayedCards.isEmpty()){
            return null;
        }else{
            return this.aPlayedCards.get(0).getSuit();
        }
    }

    public void setWinningCard( Card pCard ){
        aWinner = aPlayedCards.indexOf( pCard );
    }
    public Card getWinningCard(){
        return this.aPlayedCards.get( aWinner );
    }

    public Player getPlayer(){
        return this.getPlayer( aWinner );
    }

    public ArrayList<Card> getCards(){
        return aPlayedCards;
    }
}
