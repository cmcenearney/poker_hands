package poker.game.handranks;

import poker.model.Hand;
import poker.model.Rank;

import java.util.TreeSet;

public class OnePair implements HandEvaluator {

    public OnePair(){}

    public static boolean test (Hand hand){
        return hand.getRanksByCount(2).size() == 1;
    }

    public int compareTwoHands(Hand one, Hand two){
        TreeSet<Rank> handOnePairRanksSet = one.getRanksByCount(2);
        Rank[] handOnePairRanks =  handOnePairRanksSet.toArray(new Rank[handOnePairRanksSet.size()]);
        Rank handOneHighPairRank = handOnePairRanks[handOnePairRanksSet.size() - 1];

        TreeSet<Rank> handTwoPairRanksSet = two.getRanksByCount(2);
        Rank[] handTwoPairRanks =  handTwoPairRanksSet.toArray(new Rank[handTwoPairRanksSet.size()]);
        Rank handTwoHighPairRank = handTwoPairRanks[handTwoPairRanksSet.size() - 1];

        if ( handOneHighPairRank.position() > handTwoHighPairRank.position() ) return 1;
        if ( handOneHighPairRank.position() < handTwoHighPairRank.position() ) return -1;

        TreeSet<Rank> oneRemainder = one.getRanks();
        oneRemainder.removeAll(handOnePairRanksSet);
        TreeSet<Rank> twoRemainder = two.getRanks();
        twoRemainder.removeAll(handTwoPairRanksSet);

        return compareRemainingRanks(oneRemainder, twoRemainder);
    }

}
