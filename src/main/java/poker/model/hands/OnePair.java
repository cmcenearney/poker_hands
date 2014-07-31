package poker.model.hands;

import poker.model.Hand;
import poker.model.Rank;

import java.util.TreeSet;

public class OnePair implements PokerHand{

    public static boolean test(Hand hand){
        return hand.ranksByCount(2).size() == 1;
    }

    public static int compareTwoHands(Hand one, Hand two){
        TreeSet<Rank> handOnePairRanksSet = one.ranksByCount(2);
        Rank[] handOnePairRanks =  handOnePairRanksSet.toArray(new Rank[handOnePairRanksSet.size()]);
        Rank handOneHighPairRank = handOnePairRanks[handOnePairRanksSet.size() - 1];
        TreeSet<Rank> handTwoPairRanksSet = two.ranksByCount(2);
        Rank[] handTwoPairRanks =  handTwoPairRanksSet.toArray(new Rank[handTwoPairRanksSet.size()]);
        Rank handTwoHighPairRank = handTwoPairRanks[handTwoPairRanksSet.size() - 1];
        if (handOneHighPairRank.position() > handTwoHighPairRank.position()){ return 1;}
        if (handOneHighPairRank.position() < handTwoHighPairRank.position()){ return -1;}
        return 0;
    }

}
