package bruno.sueca.Model;

/**
 * Observes when a game ends and will award game points to the winner of the play.
 * Created by Bruno on 11/12/2015.
 */
public class GameEnd implements GameObserver {
    private int TWOGAMEPOINTSTHRESHOLD = 90;
    private int ONEGAMEPOINTSTHRESHOLD = 60;
    private int TWOGAMESWON = 2;
    private int GAMEWON = 1;
    @Override
    public Team notifyFinishedGame(Team pFirstTeam, Team pSecondTeam) {
        Team gamewinner;
        int firstteamtricks = pFirstTeam.getTricksGame();
        int secondteamtricks = pSecondTeam.getTricksGame();

        if( firstteamtricks > ONEGAMEPOINTSTHRESHOLD ){ //first team won the play
            if( firstteamtricks > TWOGAMEPOINTSTHRESHOLD ){
                pFirstTeam.addGames( TWOGAMESWON );
            }
            else{
                pFirstTeam.addGames( GAMEWON );
            }
            gamewinner = pFirstTeam;
        }else if( secondteamtricks > ONEGAMEPOINTSTHRESHOLD ){ //second team won
            if( secondteamtricks > TWOGAMEPOINTSTHRESHOLD ){
                pSecondTeam.addGames( TWOGAMESWON );
            }else{
                pSecondTeam.addGames( GAMEWON );
            }
            gamewinner = pSecondTeam;
        }else{
            gamewinner = pFirstTeam;
        }
        return gamewinner;
    }
}
