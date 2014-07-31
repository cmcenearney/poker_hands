package poker.model.hands;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A PokerHand consists of
 *  - NAME
 *  - description
 *  - function which determines whether a Hand of cards is an instance of it (is my hand a Full House?)
 *  - position (implicit, ordinal - derived from the where it is in the Enum definition - this could be made explicit)
 *  - optionally, a comparator to decide the winner when two hands are the same PokerHand (defaults to highest card)
 * To add a new PokerHand, write a suitable test function and add to the list of enum values in the proper position
 */
public enum PokerHands {

    HIGH_CARD(HighCard.class),
    ONE_PAIR(OnePair.class),
    TWO_PAIR(TwoPair.class),
    THREE_OF_A_KIND(ThreeOfAKind.class),
    STRAIGHT(Straight.class),
    FLUSH(Flush.class),
    FULL_HOUSE(FullHouse.class),
    FOUR_OF_A_KIND(FourOfAKind.class),
    STRAIGHT_FLUSH(StraightFlush.class),
    ROYAL_FLUSH(RoyalFlush.class);

    public final Class<? extends PokerHand> handClass;

    PokerHands(Class<? extends PokerHand> handClass){
        this.handClass = handClass;
    }


    public static ArrayList<PokerHands> highestToLowest(){
        //PokerHands[] ordinalOrder = PokerHands.values();
        ArrayList<PokerHands> ordinalOrder = new ArrayList<PokerHands>(Arrays.asList(PokerHands.values()));
        ArrayList<PokerHands> highestToLowest = new ArrayList<PokerHands>();
        for (int i = ordinalOrder.size() - 1; i >= 0; i--){
            highestToLowest.add(ordinalOrder.get(i));
        }
        return highestToLowest;
    }
/*
    //hand tests
    public static boolean isHighCard(Hand hand){
        return true;
    }

    public static boolean isOnePair(Hand hand){
        return hand.ranksByCount(2).size() == 1;
    }

    public static boolean isTwoPair(Hand hand){
        return hand.ranksByCount(2).size() == 2;
    }

    public static boolean isThreeOfAKind(Hand hand){
        return (hand.isOfAKind(3) && (hand.ranksByCount(3).size() == 1));
    }

    public static boolean isStraight(Hand hand){
        return hand.isAStraight();
    }

    public static boolean isFlush(Hand hand){
        return hand.isAllOneSuit();
    }

    public static boolean isFullHouse(Hand hand){
        return hand.ranksByCount(2).size() == 1 && hand.ranksByCount(3).size() == 1;
    }

    public static boolean isFourOfAKind(Hand hand){
        return hand.ranksByCount(4).size() == 1;
    }

    public static boolean isStraightFlush(Hand hand){
        return hand.isAStraight() && hand.isAllOneSuit();
    }

    public static boolean isRoyalFlush(Hand hand){
        return hand.isAStraight() && hand.isAllOneSuit() && hand.getHighestCard().getRank().equals(Rank.ACE);
    }

    //comparators
    public static int compareByHighCard(Hand one, Hand two){
        if ( one.getHighestCard().getRank().position() > two.getHighestCard().getRank().position() ) return 1;
        if ( one.getHighestCard().getRank().position() < two.getHighestCard().getRank().position() ) return -1;
        return 0;
    }

    public static int compareTwoPairHands(Hand one, Hand two){
        if (!isTwoPair(one) && !isTwoPair(two)){
            throw new IllegalArgumentException();
        }
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
        return 0;
    }

    public static int compareFullHouseHands(Hand one, Hand two){
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
*/
}


