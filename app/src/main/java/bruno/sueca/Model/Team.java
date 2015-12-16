package bruno.sueca.Model;


import java.util.ArrayList;

import bruno.sueca.Model.Card.Card;
import bruno.sueca.Model.Player.Player;

/**
 * A team in the game. It contains 2 players.
 * Created by God Bruno on 20/11/2015.
 */
public class Team {

    private ArrayList<Player> aPlayers;
    private ScoringPile aScoringPile;
    private int aGames; //Score of the team
    private final int GAMESTOWIN = 4;

    public Team(){
        aPlayers = new ArrayList<Player>();
        aScoringPile = new ScoringPile();
        aGames = 0;
    }

    /**
     * Adds the team's players
     * @param pPlayer1 The first player of the team
     * @param pPlayer2 The second player of the team
     */
    public void addPlayers( Player pPlayer1, Player pPlayer2 ){
        aPlayers.add(pPlayer1);
        aPlayers.add(pPlayer2);
    }

    /**
     * Gets the trick won in this game
     * @return The tricks won in this game.
     */
    public int getTricksGame(){
        return this.aScoringPile.getScore();
    }
    /**
     * Add points gained from the finished Game.
     * @param pGames The number of points won.
     */
    public void addGames(int pGames){
        aGames += pGames;
    }

    /**
     * Clear the team's points from finished game.
     * pre-condition The players have empty hands.
     */
    public void clearGame(){
        this.aScoringPile.clear();
    }
    /**
     * Check if the team won.
     */
    public boolean isGameWon(){

        if (aGames >= GAMESTOWIN){
            return true;
        }
        return false;
    }

    /**
     * Check if team has pPlayer
     * @param pPlayer the player to check
     * @return true if player is in the team
     */
    public boolean contain( Player pPlayer ){
        return aPlayers.contains( pPlayer );
    }

    /**
     * Add cards to the scoring pile
     * @param pCards The cards to be added.
     */
    public void addScoringPile( ArrayList<Card> pCards){
        aScoringPile.addCards(pCards);
    }

}
