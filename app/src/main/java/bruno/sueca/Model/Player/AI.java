package bruno.sueca.Model.Player;
import bruno.sueca.Model.Core.Card;
import bruno.sueca.Model.Core.Suit;
import bruno.sueca.Model.Core.Team;

/**
 * Created by Bruno on 15/12/2015.
 */
public abstract class AI implements Player {

    abstract Card decideCard(Suit pPlaySuit, Card pWinningCard, Team pWinningTeam);

    /**
     * The behavior of the AI
     * @param pPlaySuit The suit in play
     * @param pWinningCard The current winning card.
     * @param pWinningTeam The current winning team.
     */
    public Card play( Suit pPlaySuit, Card pWinningCard, Team pWinningTeam ){
        return decideCard( pPlaySuit, pWinningCard, pWinningTeam );
    }
}
