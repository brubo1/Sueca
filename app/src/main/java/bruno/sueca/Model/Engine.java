package bruno.sueca.Model;

import java.util.ArrayList;
import java.util.Random;

import bruno.sueca.Model.Card.Card;
import bruno.sueca.Model.Card.Deck;
import bruno.sueca.Model.Player.AI;
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
    private ArrayList<Team> aTeams;
    private Player aPlayer;
    private ArrayList<AI> aAIs;

    private ArrayList<PlayObserver> aPlayObservers ;
    private ArrayList<GameObserver> aGameObservers;



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
        aAIs = new ArrayList<AI>();
    }

    private void nextPlayer(){
        aCurrentPlayer = (aCurrentPlayer + 1) % PLAYERS;

    }

    private void nextDealer(){
        aCurrentDealer = (aCurrentDealer + 1 ) % PLAYERS;
    }

    /**
     * Creates a Game with a Human player
     */
    public void newGame(){

        Team team1 = new Team();
        Team team2 = new Team();

        team1.addPlayers( new HumanPlayer() , new EasyAI());
        team2.addPlayers(new EasyAI(), new EasyAI());
    }

    /**
     * Creates an automatic game
     */
    public void newGameAuto(){

        Team team1 = new Team();
        Team team2 = new Team();

        aTeams.add( team1 );
        aTeams.add( team2 );

        aAIs.add(new EasyAI());
        aAIs.add(new EasyAI());
        aAIs.add(new EasyAI());
        aAIs.add(new EasyAI());

        team1.addPlayers(aAIs.get(0), aAIs.get(2));
        team2.addPlayers(aAIs.get(1), aAIs.get(3));

        aCurrentDealer = new Random().nextInt(PLAYERS);

        playAuto();

    }

    /**
     * Play an automatic game.
     */
    public String playAuto(){
        boolean GameWon = false;
        Team GameWinner;
        while( !GameWon ){
            aCurrentPlayer = aCurrentDealer;
            aDeck.reset();
            aAIs.get(aCurrentDealer).Deal();
            this.nextPlayer();                                          //Player to the right of the dealer
            for( aNumberOfPlays = 0 ; aNumberOfPlays < 10 ; aNumberOfPlays++) {
                for (AI ai : aAIs) {
                    Player winningplayer = aPlayedCards.getPlayer();
                    Team winningTeam = new Team();
                    for(Team team: aTeams){
                        if(team.contain( winningplayer )){
                            winningTeam = team;
                        }
                    }
                    Card cardplayed = ai.play( this.aPlayedCards.getPlaySuit(), this.aPlayedCards.getWinningCard(), winningTeam );
                    this.playCard( cardplayed );
                    notifyCardPlayed();
                    nextPlayer();
                }
                Player player = notifyEndOfPlay();
                reorderPlayers( player );
                aPlayedCards.clear();
            }
            nextDealer();
            GameWon = notifyGameEnd();
            for( Team team : aTeams ){
                team.clearGame();
            }
        }
        return "Game Ended";
    }

    /**
     * Finds the team which pPlayer is part of.
     * @param pPlayer The player to search for
     * @return The team which pPlayer is part of.
     */
    public Team findTeam( Player pPlayer ){
        Team playerteam = new Team();
        for ( Team team : aTeams ){
            if( team.contain( pPlayer ) ){
                playerteam = team;
            }
        }
        return playerteam;
    }

    /**
     * Deal card to the dealer
     */
    public void dealSelf(){
        for ( int i = 0; i < 9; i++ ){
            if( aCurrentPlayer == 0 && this.aAIs.size() < 4 ){
                this.aPlayer.drewFromDeck( aDeck.draw() );
            }else{
                this.aAIs.get( aCurrentPlayer ).drewFromDeck( aDeck.draw() );
            }
        }
    }

    /**
     * Deal cards to the other players.
     */
    public void dealOthers(){
        for (int j = 0 ; j < 3 ; j++){
            this.nextPlayer();
            for ( int i = 0; i < 10; i++ ){
                if( aCurrentPlayer == 0 && this.aAIs.size() < 4 ) {
                    aPlayer.drewFromDeck(aDeck.draw());
                }else{
                    this.aAIs.get( aCurrentPlayer ).drewFromDeck( aDeck.draw() );
                }
            }
        }
        this.aCurrentPlayer = aCurrentDealer;
    }

    /**
     * When the dealer decides to deal itself first
     */
    public void dealSelfFirst(){
        Card Trump = aDeck.draw();
        aAIs.get(aCurrentDealer).setTrumpCard(Trump);
        notifyTrump(Trump);
        this.dealSelf();
        dealOthers();
    }

    /**
     * When the dealer decides to deal itself last
     */
    public void dealSelfLast(){
        dealOthers();
        this.dealSelf();
        Card Trump = aDeck.draw();
        aAIs.get(aCurrentDealer).setTrumpCard(Trump);
        notifyTrump(Trump);
    }

    /**
     * Deal the cards to the players
     */
    public void AIdeal(){
        if( aAIs.get(aCurrentDealer).Deal() ){
            dealSelfFirst();
        }else{
            dealSelfLast();
        }
    }

    public void reorderPlayers( Player pPlayer ){
        int winner;
        ArrayList<AI> AIs = new ArrayList<AI>();
        if( this.aAIs.size() < 4){
            //there is a human player
        }else{
            winner = aAIs.indexOf( pPlayer );
            for( int i = 0; i < 4; i++){
                AIs.add(aAIs.get(winner));
                winner = (winner + 1) % 4;
            }
        }
    }

    /**
     * Put cards in played cards.
     * @param pCard The card to be played
     */
    public void playCard( Card pCard ){
        if( aCurrentPlayer == 0 && this.aAIs.size() < 4 ) {
            this.aPlayedCards.addCards( pCard, aPlayer );
        }else{
            this.aPlayedCards.addCards( pCard, this.aAIs.get( aCurrentPlayer ));
        }
        this.nextPlayer();
        notifyCardPlayed();
    }

    /**
     * Notify the end of a play.
     */
    public Player notifyEndOfPlay(){
        Team TeamWon;
        Player player = aPlayer;
        for( PlayObserver obs : aPlayObservers ){
            player = obs.notifyPlayEnd(aPlayedCards);
        }

        TeamWon = this.findTeam( player );

        TeamWon.addScoringPile(aPlayedCards.getCards());

        return player;
    }

    public void notifyCardPlayed(){
        int winner;
        for( PlayObserver obs : aPlayObservers ){
            winner = obs.notifyCardPlayed( aPlayedCards, aCurrentPlayer );
        }
    }

    /**
     * Notify the end of a game.
     */
    public boolean notifyGameEnd(){
        Team winner = new Team();
        for( GameObserver obs : aGameObservers){
            winner = obs.notifyFinishedGame( aTeams.get(0) , aTeams.get(1) );
        }
        return winner.isGameWon();
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
}
