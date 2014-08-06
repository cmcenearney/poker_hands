package poker.game;

import poker.model.Hand;
import poker.model.Rank;

import java.util.TreeSet;

public class PokerHandComparators {

    //comparators
    public static int compareByHighCard(Hand one, Hand two){
        if ( one.getHighestCard().getRank().position() > two.getHighestCard().getRank().position() ) return 1;
        if ( one.getHighestCard().getRank().position() < two.getHighestCard().getRank().position() ) return -1;
        return 0;
    }

    public static int compareRemainingRanks(TreeSet<Rank> one, TreeSet<Rank> two){
        if (one.size() == 1 && two.size() == 1){
            return one.last().position() - two.last().position();
        }
        Rank oneHighest = one.pollLast();
        Rank twoHighest = two.pollLast();
        if (oneHighest != twoHighest){
            return oneHighest.position() - twoHighest.position();
        } else {
            return compareRemainingRanks(one, two);
        }
    }

    public static int compareOnePairHands(Hand one, Hand two){
        TreeSet<Rank> handOnePairRanksSet = one.getRanksByCount(2);
        Rank[] handOnePairRanks =  handOnePairRanksSet.toArray(new Rank[handOnePairRanksSet.size()]);
        Rank handOneHighPairRank = handOnePairRanks[handOnePairRanksSet.size() - 1];

        TreeSet<Rank> handTwoPairRanksSet = two.getRanksByCount(2);
        Rank[] handTwoPairRanks =  handTwoPairRanksSet.toArray(new Rank[handTwoPairRanksSet.size()]);
        Rank handTwoHighPairRank = handTwoPairRanks[handTwoPairRanksSet.size() - 1];

        if ( handOneHighPairRank.position() > handTwoHighPairRank.position() ) return 1;
        if ( handOneHighPairRank.position() < handTwoHighPairRank.position() ) return -1;

        TreeSet<Rank> oneRemainder = one.ranks();
        oneRemainder.removeAll(handOnePairRanksSet);
        TreeSet<Rank> twoRemainder = two.ranks();
        twoRemainder.removeAll(handTwoPairRanksSet);

        return compareRemainingRanks(oneRemainder, twoRemainder);
    }

    public static int compareTwoPairHands(Hand one, Hand two){

        TreeSet<Rank> handOnePairRanksSet = one.getRanksByCount(2);
        Rank[] handOnePairRanks =  handOnePairRanksSet.toArray(new Rank[handOnePairRanksSet.size()]);
        Rank handOneHighPairRank = handOnePairRanks[handOnePairRanksSet.size() - 1];
        Rank handOneLowPairRank = handOnePairRanks[handOnePairRanksSet.size() - 2];
        TreeSet<Rank> handTwoPairRanksSet = two.getRanksByCount(2);
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


    public static int compareThreeOfAKindHands(Hand one, Hand two){
        TreeSet<Rank> handOneThreeRanksSet = one.getRanksByCount(3);
        Rank[] handOneThreeRanks =  handOneThreeRanksSet.toArray(new Rank[handOneThreeRanksSet.size()]);
        Rank handOneHighThreeRank = handOneThreeRanks[handOneThreeRanksSet.size() - 1];

        TreeSet<Rank> handTwoThreeRanksSet = two.getRanksByCount(3);
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

    public static int compareFourOfAKindHands(Hand one, Hand two){
        TreeSet<Rank> handOneThreeRanksSet = one.getRanksByCount(4);
        Rank[] handOneThreeRanks =  handOneThreeRanksSet.toArray(new Rank[handOneThreeRanksSet.size()]);
        Rank handOneHighThreeRank = handOneThreeRanks[handOneThreeRanksSet.size() - 1];

        TreeSet<Rank> handTwoThreeRanksSet = two.getRanksByCount(4);
        Rank[] handTwoThreeRanks =  handTwoThreeRanksSet.toArray(new Rank[handTwoThreeRanksSet.size()]);
        Rank handTwoHighThreeRank = handTwoThreeRanks[handTwoThreeRanksSet.size() - 1];

        if ( handOneHighThreeRank.position() > handTwoHighThreeRank.position() ) return 1;
        if ( handOneHighThreeRank.position() < handTwoHighThreeRank.position() ) return -1;

        return 0;
    }

    public static int compareFullHouseHands(Hand one, Hand two){
        Rank handOneThreeCardRank = (Rank) one.getRanksByCount(3).toArray()[0];
        Rank handTwoThreeCardRank = (Rank) two.getRanksByCount(3).toArray()[0];
        if ( handOneThreeCardRank.position() > handTwoThreeCardRank.position() ) return 1;
        if ( handOneThreeCardRank.position() < handTwoThreeCardRank.position() ) return -1;
        if ( handOneThreeCardRank.position() == handTwoThreeCardRank.position() ) {
            Rank handOneTwoCardRank = (Rank) one.getRanksByCount(2).toArray()[0];
            Rank handTwoTwoCardRank = (Rank) two.getRanksByCount(2).toArray()[0];
            if ( handOneTwoCardRank.position() > handTwoTwoCardRank.position() ) return 1;
            if ( handOneTwoCardRank.position() < handTwoTwoCardRank.position() ) return -1;
        }
        return 0;
    }

}
