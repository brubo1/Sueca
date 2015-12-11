package bruno.sueca.Model;

/**
 * Created by Bruno on 11/12/2015.
 */
public class GameEnd implements GameObserver {
    private int TWOGAMEPOINTSTHRESHOLD = 90;
    private int ONEGAMEPOINTSTHRESHOLD = 60;
    private int TWOGAMESWON = 2;
    private int GAMEWON = 1;
    @Override
    public void notifyFinishedSet(Team pFirstTeam, Team pSecondTeam) {

        int firstteamtricks = pFirstTeam.getTricksGame();
        int secondteamtricks = pSecondTeam.getTricksGame();

        if( firstteamtricks > ONEGAMEPOINTSTHRESHOLD ){ //first team won the play
            if( firstteamtricks > TWOGAMEPOINTSTHRESHOLD ){
                pFirstTeam.addGames( TWOGAMESWON );
            }
            else{
                pFirstTeam.addGames( GAMEWON );
            }
        }else if( secondteamtricks > ONEGAMEPOINTSTHRESHOLD ){ //second team won
            if( secondteamtricks > TWOGAMEPOINTSTHRESHOLD ){
                pSecondTeam.addGames( TWOGAMESWON );
            }else{
                pSecondTeam.addGames( GAMEWON );
            }
        }else{
            //null game
        }
    }
}
