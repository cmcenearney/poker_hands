package poker.game.handranks;

import poker.model.Hand;
import poker.model.Rank;

import java.util.TreeSet;

public class ThreeOfAKind implements HandEvaluator {

    public static boolean test(Hand hand){
        return (hand.isOfAKind(3) && (hand.ranksByCount(3).size() == 1));
    }

    public int compareTwoHands(Hand one, Hand two){
        TreeSet<Rank> handOneThreeRanksSet = one.ranksByCount(3);
        Rank[] handOneThreeRanks =  handOneThreeRanksSet.toArray(new Rank[handOneThreeRanksSet.size()]);
        Rank handOneHighThreeRank = handOneThreeRanks[handOneThreeRanksSet.size() - 1];

        TreeSet<Rank> handTwoThreeRanksSet = two.ranksByCount(3);
        Rank[] handTwoThreeRanks =  handTwoThreeRanksSet.toArray(new Rank[handTwoThreeRanksSet.size()]);
        Rank handTwoHighThreeRank = handTwoThreeRanks[handTwoThreeRanksSet.size() - 1];

        if ( handOneHighThreeRank.position() > handTwoHighThreeRank.position() ) return 1;
        if ( handOneHighThreeRank.position() < handTwoHighThreeRank.position() ) return -1;

        TreeSet<Rank> oneRemainder = one.ranks();
        oneRemainder.removeAll(handOneThreeRanksSet);
        TreeSet<Rank> twoRemainder = two.ranks();
        twoRemainder.removeAll(handTwoThreeRanksSet);

        return compareRemainingRanks(oneRemainder, twoRemainder);

    }
}
