package bruno.sueca.Model;

import java.util.ArrayList;
import java.util.Random;

import bruno.sueca.Model.Card.Card;
import bruno.sueca.Model.Card.Deck;
import bruno.sueca.Model.Player.EasyAI;
import bruno.sueca.Model.Player.HumanPlayer;
import bruno.sueca.Model.Player.Player;
/**
 * Team 1 will contain the human player as player 1.
 *
 * Created by Bruno on 11/12/2015.
 */
public class Engine {
    private final int PLAYERS = 4;
    private final int TEAMS = 2;

    private static Engine ourInstance = new Engine();
    private Deck aDeck;
    private PlayedCards aPlayedCards;
    private int aCurrentPlayer = 1;
    private int aCurrentDealer = 1;
    private int aNumberOfPlays = 0;
    private Difficulty aDifficulty;

    private ArrayList<PlayObserver> aPlayObservers ;
    private ArrayList<GameObserver> aGameObservers;
    private ArrayList<Team> aTeams;
    private ArrayList<Player> aPlayers;


    public static Engine getInstance() {
        return ourInstance;
    }

    private Engine() {
        aDeck = new Deck();
        aDifficulty = Difficulty.Easy;
        aDeck = new Deck();
        aPlayedCards = new PlayedCards();
        aPlayObservers = new ArrayList<PlayObserver>();
        aGameObservers = new ArrayList<GameObserver>();
        aTeams = new ArrayList<Team>();
        aPlayers = new ArrayList<Player>();
    }

    private void nextPlayer(){
        aCurrentPlayer = (aCurrentPlayer + 1) % PLAYERS;

    }


    /**
     * Creates a Game with a Human player
     */
    public void newGame(){

        Team team1 = new Team();
        Team team2 = new Team();

        team1.addPlayers( new HumanPlayer() , new EasyAI());
        team2.addPlayers( new EasyAI() , new EasyAI());
    }

    /**
     * Creates an automatic game
     */
    public void newGameAuto(){

        Team team1 = new Team();
        Team team2 = new Team();

        aTeams.add( team1 );
        aTeams.add( team2 );

        aPlayers.add( new EasyAI() );
        aPlayers.add( new EasyAI() );
        aPlayers.add( new EasyAI() );
        aPlayers.add( new EasyAI() );

        team1.addPlayers( aPlayers.get(0) , aPlayers.get(2) );
        team2.addPlayers( aPlayers.get(1) , aPlayers.get(3) );

        aCurrentDealer = new Random().nextInt(PLAYERS);
        aCurrentPlayer = aCurrentDealer;

        aDeck.reset();
        aPlayers.get(aCurrentDealer).Deal();

        this.nextPlayer();                                          //Player to the right of the dealer

    }

    public void addToScoringPile( ArrayList<Card> pCards, Team pTeam ){
        pTeam.addScoringPile( pCards );
    }

    public Team findTeam( Player pPlayer ){
        for ( Team team : aTeams ){
            if( team.contain( pPlayer ) ){
                return team;
            }
        }
        return null;                                                //should never happen
    }
    /**
     * Notify the end of a play.
     */
    public void notifyPlayEnd(){
        Team TeamWon;
        Player player = aPlayers.get(0);
        for( PlayObserver obs : aPlayObservers ){
            player = obs.notifyFinishedPlay( aPlayedCards );
        }

        TeamWon = this.findTeam( player );

        TeamWon.addScoringPile(aPlayedCards.getCards());
    }

    /**
     * Notify the end of a game.
     */
    public void notifyGameEnd(){
        for( GameObserver obs : aGameObservers){
            obs.notifyFinishedGame( aTeams.get(0) , aTeams.get(1) );
        }
    }

    /**
     * Notify the observers of the game trump card
     * @param pTrump The current trump card
     */
    public void notifyTrump( Card pTrump ){
        for ( PlayObserver obs : aPlayObservers){
            obs.setTrump( pTrump.getSuit() );
        }
    }

    public void dealSelf(){
        for ( int i = 0; i < 9; i++ ){
            aPlayers.get(aCurrentDealer).drewFromDeck( aDeck.draw());
        }
    }

    public void dealOthers(){
        for (int j = 0 ; j < 3 ; j++){
            this.nextPlayer();
            for ( int i = 0; i < 10; i++ ){
                aPlayers.get(aCurrentPlayer).drewFromDeck( aDeck.draw());
            }
            j++;
        }
        this.aCurrentPlayer = aCurrentDealer;
    }

    /**
     * Deal the cards to the players
     *
     */
    public void deal(){
        if( aPlayers.get(aCurrentDealer).Deal() ){
            Card Trump = aDeck.draw();
            aPlayers.get(aCurrentDealer).setTrumpCard( Trump );
            notifyTrump( Trump);
            this.dealSelf();
            dealOthers();
        }else{
            dealOthers();
            this.dealSelf();
            Card Trump = aDeck.draw();
            aPlayers.get(aCurrentDealer).setTrumpCard(Trump);
            notifyTrump( Trump );
        }
    }


    /**
     * Make players play a turn.
     */
    public void play(){



    }
}
