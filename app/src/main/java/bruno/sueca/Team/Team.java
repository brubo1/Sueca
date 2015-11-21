package bruno.sueca.Team;


import bruno.sueca.Team.Player.Player;

/**
 * A team in the game. It contains 2 players.
 * Created by God Bruno on 20/11/2015.
 */
public class Team {

    private Player[] aPlayers;
    private ScoringPile aScoringPile;
    private int aPoints; //Points gained from round.

    public Team(){
        aPlayers = new Player[2];
        aScoringPile = new ScoringPile();
    }

    /**
     * Add points to the current Vasa.
     * @param pPointsVasa The number of points gained.
     */
    public void addPointsVasa(int pPointsVasa){
        this.aScoringPile.addPoints(pPointsVasa);
    }

    /**
     * Add points gained from the finished Vasa.
     * @param pPoints The number of points won.
     */
    public void addPoints(int pPoints){
        aPoints += pPoints;
    }

    /**
     * Clear the team's points from finished vasa.
     * pre-condition The players have empty hands.
     */
    public void clear(){
        this.aScoringPile.clear();
        this.aPoints = 0;
    }

    /**
     * Check if the team won.
     */
    public boolean victory(){
        //// TODO: 21/11/2015
        return true;
    }
}
