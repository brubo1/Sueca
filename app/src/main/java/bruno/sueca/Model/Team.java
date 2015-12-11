package bruno.sueca.Model;


import java.util.ArrayList;

import bruno.sueca.Model.Player.Player;

/**
 * A team in the game. It contains 2 players.
 * Created by God Bruno on 20/11/2015.
 */
public class Team {

    private ArrayList<Player> aPlayers;
    private ScoringPile aScoringPile;
    private int aGames; //Score of the team

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
     * Add points to the current Vasa.
     * @param pTricks The number of points gained.
     */
    public void addTricksGame(int pTricks){
        this.aScoringPile.addPoints(pTricks);
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
     * Clear the team's points from finished vasa.
     * pre-condition The players have empty hands.
     */
    public void clearRound(){
        this.aScoringPile.clear();
        this.aGames = 0;
    }

    public void clearGame(){
        this.aPlayers.clear();
        aGames = 0;
        this.clearRound();
    }
    /**
     * Check if the team won.
     * @param pPoints The number of points needed to win the game.
     */
    public boolean isGameWon(int pPoints){

        if (aGames >= pPoints){
            return true;
        }
        return false;
    }
}
