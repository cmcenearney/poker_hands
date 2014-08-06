package poker.game.handranks;

import poker.model.Hand;
import poker.model.Rank;

public class FullHouse implements HandEvaluator {

    public static boolean test(Hand hand){
        return hand.ranksByCount(2).size() == 1 && hand.ranksByCount(3).size() == 1;
    }

    public int compareTwoHands(Hand one, Hand two){
        Rank handOneThreeCardRank = (Rank) one.ranksByCount(3).toArray()[0];
        Rank handTwoThreeCardRank = (Rank) two.ranksByCount(3).toArray()[0];
        if ( handOneThreeCardRank.position() > handTwoThreeCardRank.position() ) return 1;
        if ( handOneThreeCardRank.position() < handTwoThreeCardRank.position() ) return -1;
        if ( handOneThreeCardRank.position() == handTwoThreeCardRank.position() ) {
            Rank handOneTwoCardRank = (Rank) one.ranksByCount(2).toArray()[0];
            Rank handTwoTwoCardRank = (Rank) two.ranksByCount(2).toArray()[0];
            if ( handOneTwoCardRank.position() > handTwoTwoCardRank.position() ) return 1;
            if ( handOneTwoCardRank.position() < handTwoTwoCardRank.position() ) return -1;
        }
        return 0;
    }


}
