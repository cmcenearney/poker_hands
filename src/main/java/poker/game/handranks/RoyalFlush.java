package poker.game.handranks;

import poker.model.Hand;
import poker.model.Rank;

public class RoyalFlush implements HandEvaluator {

    public static boolean test(Hand hand){
        return hand.isAStraight() && hand.isAllOneSuit() && hand.getHighestCard().getRank().equals(Rank.ACE);
    }

}
