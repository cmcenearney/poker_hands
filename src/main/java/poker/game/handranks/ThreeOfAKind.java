package poker.game.handranks;

import poker.model.Hand;
import poker.model.Rank;

import java.util.TreeSet;

public class ThreeOfAKind implements HandEvaluator {

    public static boolean test(Hand hand){
        return (hand.isOfAKind(3) && (hand.getRanksByCount(3).size() == 1));
    }

    public int compareTwoHands(Hand one, Hand two){
        TreeSet<Rank> handOneThreeRanksSet = one.getRanksByCount(3);
        Rank[] handOneThreeRanks =  handOneThreeRanksSet.toArray(new Rank[handOneThreeRanksSet.size()]);
        Rank handOneHighThreeRank = handOneThreeRanks[handOneThreeRanksSet.size() - 1];

        TreeSet<Rank> handTwoThreeRanksSet = two.getRanksByCount(3);
        Rank[] handTwoThreeRanks =  handTwoThreeRanksSet.toArray(new Rank[handTwoThreeRanksSet.size()]);
        Rank handTwoHighThreeRank = handTwoThreeRanks[handTwoThreeRanksSet.size() - 1];

        if ( handOneHighThreeRank.position() > handTwoHighThreeRank.position() ) return 1;
        if ( handOneHighThreeRank.position() < handTwoHighThreeRank.position() ) return -1;

        TreeSet<Rank> oneRemainder = one.getRanks();
        oneRemainder.removeAll(handOneThreeRanksSet);
        TreeSet<Rank> twoRemainder = two.getRanks();
        twoRemainder.removeAll(handTwoThreeRanksSet);

        return compareRemainingRanks(oneRemainder, twoRemainder);

    }
}
