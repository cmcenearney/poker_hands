package poker.game.handranks;

import poker.model.Hand;
import poker.model.Rank;

import java.util.TreeSet;

public class TwoPair implements HandEvaluator {

    public static boolean test(Hand hand){
        return hand.ranksByCount(2).size() == 2;
    }

    public int compareTwoHands(Hand one, Hand two){
        TreeSet<Rank> handOnePairRanksSet = one.ranksByCount(2);
        Rank[] handOnePairRanks =  handOnePairRanksSet.toArray(new Rank[handOnePairRanksSet.size()]);
        Rank handOneHighPairRank = handOnePairRanks[handOnePairRanksSet.size() - 1];
        Rank handOneLowPairRank = handOnePairRanks[handOnePairRanksSet.size() - 2];
        TreeSet<Rank> handTwoPairRanksSet = two.ranksByCount(2);
        Rank[] handTwoPairRanks =  handTwoPairRanksSet.toArray(new Rank[handTwoPairRanksSet.size()]);
        Rank handTwoHighPairRank = handTwoPairRanks[handTwoPairRanksSet.size() - 1];
        Rank handTwoLowPairRank = handTwoPairRanks[handTwoPairRanksSet.size() - 2];
        if ( handOneHighPairRank.position() > handTwoHighPairRank.position() ) return 1;
        if ( handOneHighPairRank.position() < handTwoHighPairRank.position() ) return -1;
        if ( handOneHighPairRank.position() == handTwoHighPairRank.position() ) {
            if ( handOneLowPairRank.position() > handTwoLowPairRank.position() ) return 1;
            if ( handOneLowPairRank.position() < handTwoLowPairRank.position() ) return -1;
        }
        TreeSet<Rank> oneRemainder = one.ranks();
        oneRemainder.removeAll(handOnePairRanksSet);
        TreeSet<Rank> twoRemainder = two.ranks();
        twoRemainder.removeAll(handTwoPairRanksSet);

        return compareRemainingRanks(oneRemainder, twoRemainder);
    }
}
