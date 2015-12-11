package bruno.sueca.Model;

import java.util.ArrayList;

import bruno.sueca.Model.Card.Deck;
//import bruno.sueca.Model.Card.Deck;
/**
 * Team 1 will contain the human player as player 1.
 *
 * Created by Bruno on 11/12/2015.
 */
public class Engine {
    private static int MAXPLAYERS = 4;

    private static Engine ourInstance = new Engine();
    private Deck aDeck;
    private int aCurrentPlayer = 1;
    private Difficulty aDifficulty;

    private ArrayList<PlayObserver> aGameObservers ;
    private ArrayList<GameObserver> aScoreObservers;
    private ArrayList<Team> aTeams;


    public static Engine getInstance() {
        return ourInstance;
    }

    private Engine() {
        aDeck = new Deck();
        aDifficulty = Difficulty.Easy;
    }

    private void nextPlayer(){
        aCurrentPlayer = (aCurrentPlayer + 1) % MAXPLAYERS;
    }

    /**
     * Creates a Game with a Human player
     */
    public void newGame(){

        Team team1 = new Team();
        Team team2 = new Team();

    }

    /**
     * Creates an automatic game
     */
    public void newGameAuto(){

        Team team1 = new Team();
        Team team2 = new Team();
    }
}
