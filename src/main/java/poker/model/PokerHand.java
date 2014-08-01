package poker.model;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A PokerHand consists of
 *  - NAME
 *  - description
 *  - test - a function which determines whether a Hand of cards is an instance of this PokerHand
 *  - position (implicit, ordinal - derived from the where it is in the Enum definition - this could be made explicit)
 *  - optionally, a comparator to decide the winner when two hands are the same PokerHand (defaults to highest card)
 * To add a new PokerHand, write a suitable test function and add to the list of enum values in the proper position
 */
public enum PokerHand {

    HIGH_CARD("Highest value card", PokerHand::isHighCard),
    ONE_PAIR("Two cards of the same value", PokerHand::isOnePair, PokerHand::compareOnePairHands),
    TWO_PAIR("Two different pairs", PokerHand::isTwoPair, PokerHand::compareTwoPairHands),
    THREE_OF_A_KIND("Three cards of the same value", PokerHand::isThreeOfAKind, PokerHand::compareThreeOfAKindHands),
    STRAIGHT("All cards are consecutive values", PokerHand::isStraight),
    FLUSH("All cards of the same suit", PokerHand::isFlush),
    FULL_HOUSE("Three of a kind and a pair", PokerHand::isFullHouse, PokerHand::compareFullHouseHands),
    FOUR_OF_A_KIND("Four cards of the same value", PokerHand::isFourOfAKind, PokerHand::compareFourOfAKindHands),
    STRAIGHT_FLUSH("All cards are consecutive values of same suit", PokerHand::isStraightFlush),
    ROYAL_FLUSH(" Ten, Jack, Queen, King, Ace, in same suit", PokerHand::isRoyalFlush);

    public final String description;
    public final Function<Hand, Boolean> test;
    public final Comparator<Hand> comparator;

    PokerHand(String description, Function<Hand, Boolean> test){
        this.description = description;
        this.test = test;
        this.comparator = PokerHand::compareByHighCard;
    }

    PokerHand(String description, Function<Hand, Boolean> test, Comparator<Hand> comp){
        this.description = description;
        this.test = test;
        this.comparator = comp;
    }

    public static List<PokerHand> highestToLowest(){
        List<PokerHand> ordinalOrder = Arrays.asList(PokerHand.values());
        //Collections.reverse(ordinalOrder);
        //reverse is great but today we use streams!
        List<PokerHand> highestToLowest = ordinalOrder.stream()
                .sorted(Comparator.<PokerHand>naturalOrder().reversed())
                .collect(Collectors.toList());
        return highestToLowest;
    }

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
        TreeSet<Rank> handOnePairRanksSet = one.ranksByCount(2);
        Rank[] handOnePairRanks =  handOnePairRanksSet.toArray(new Rank[handOnePairRanksSet.size()]);
        Rank handOneHighPairRank = handOnePairRanks[handOnePairRanksSet.size() - 1];

        TreeSet<Rank> handTwoPairRanksSet = two.ranksByCount(2);
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
        TreeSet<Rank> oneRemainder = one.ranks();
        oneRemainder.removeAll(handOnePairRanksSet);
        TreeSet<Rank> twoRemainder = two.ranks();
        twoRemainder.removeAll(handTwoPairRanksSet);

        return compareRemainingRanks(oneRemainder, twoRemainder);
    }


    public static int compareThreeOfAKindHands(Hand one, Hand two){
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

    public static int compareFourOfAKindHands(Hand one, Hand two){
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

}

