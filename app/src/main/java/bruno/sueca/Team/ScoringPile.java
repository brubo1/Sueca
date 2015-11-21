package bruno.sueca.Team;

import java.util.Stack;

import bruno.sueca.Card.Card;

/**
 * Pile of cards held by a team which needs to have the points counted.
 * Created by God Bruno on 21/11/2015.
 */
public class ScoringPile {

    private int aScore;             //Score held by the Scoring Pile
    private Stack<Card> aPile;      //cards won during Vasa

    /**
     * Constructor of a ScoringPile.
     */
    public ScoringPile(){
        aScore = 0;
        aPile = new Stack<>();
    }

    /**
     * Add points from Vasa.
     * @param pPoints The points to be added to the current team vasa.
     */
    public void addPoints(int pPoints){
        aScore += pPoints;
    }

    /**
     * Get the score from Round
     * @return number of points in the scoring pile.
     */
    public int getScore(){
        return this.aScore;
    }

    /**
     * Clears the scoring pile
     */
    public void clear(){
        this.aPile.clear();
        this.aScore = 0;
    }
}
