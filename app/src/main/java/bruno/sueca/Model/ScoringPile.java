package bruno.sueca.Model;

import java.util.ArrayList;
import java.util.Stack;

import bruno.sueca.Model.Card.Card;
import bruno.sueca.Model.Card.TricksCalculator;

/**
 * Pile of cards held by a team which needs to have the points counted.
 * Created by Bruno on 21/11/2015.
 */
public class ScoringPile {

    private int aTricks;             //Score held by the Scoring Pile
    private Stack<Card> aPile;      //cards won during game
    private TricksCalculator aTricksCalculator;

    /**
     * Constructor of a ScoringPile.
     */
    public ScoringPile(){
        aTricks = 0;
        aPile = new Stack<>();
        aTricksCalculator = new TricksCalculator();
    }

    /**
     * Add points from Game.
     * @param pTricks The points to be added to the current team vasa.
     */
    public void addTricks(int pTricks){
        aTricks += pTricks;
    }

    /**
     * Get the score from Round
     * @return number of points in the scoring pile.
     */
    public int getScore(){
        return this.aTricks;
    }

    /**
     * Clears the scoring pile
     */
    public void clear(){
        this.aPile.clear();
        this.aTricks = 0;
    }

    /**
     * Add cards to the scoring pile
     * @param pCards The cards to be added.
     */
    public void addCards( ArrayList<Card> pCards){
        for( Card card : pCards ){
            this.addTricks( this.aTricksCalculator.getValue(card) );
            aPile.push( card );
        }
    }
}
