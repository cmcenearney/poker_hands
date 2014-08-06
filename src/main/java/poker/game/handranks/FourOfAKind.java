package poker.game.handranks;

import poker.model.Hand;
import poker.model.Rank;

import java.util.TreeSet;

public class FourOfAKind implements HandEvaluator {


    public static boolean test(Hand hand){
        return hand.ranksByCount(4).size() == 1;
    }

    public  int compareTwoHands(Hand one, Hand two){
        TreeSet<Rank> handOneThreeRanksSet = one.ranksByCount(4);
        Rank[] handOneThreeRanks =  handOneThreeRanksSet.toArray(new Rank[handOneThreeRanksSet.size()]);
        Rank handOneHighThreeRank = handOneThreeRanks[handOneThreeRanksSet.size() - 1];

        TreeSet<Rank> handTwoThreeRanksSet = two.ranksByCount(4);
        Rank[] handTwoThreeRanks =  handTwoThreeRanksSet.toArray(new Rank[handTwoThreeRanksSet.size()]);
        Rank handTwoHighThreeRank = handTwoThreeRanks[handTwoThreeRanksSet.size() - 1];

        if ( handOneHighThreeRank.position() > handTwoHighThreeRank.position() ) return 1;
        if ( handOneHighThreeRank.position() < handTwoHighThreeRank.position() ) return -1;

        return 0;
    }
}
