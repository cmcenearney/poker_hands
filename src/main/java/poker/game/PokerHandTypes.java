package poker.game;

import poker.model.Hand;
import poker.model.Rank;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A PokerHand consists of
 *  - NAME
 *  - description
 *  - test - a function which determines whether a Hand of cards is an instance of this PokerHand
 *  - position (atm ordinal - derived from the where it is in the Enum definition - this could be made explicit)
 *  - optionally, a comparator to decide the winner when two hands are the same PokerHand (defaults to highest card)
 * To add a new PokerHand, write a suitable test function and add to the list of enum values in the proper position
 */
public enum PokerHandTypes {

    HIGH_CARD("Highest value card",
            PokerHandTests::isHighCard),
    ONE_PAIR("Two cards of the same value",
            PokerHandTests::isOnePair,
            PokerHandComparators::compareOnePairHands),
    TWO_PAIR("Two different pairs",
            PokerHandTests::isTwoPair,
            PokerHandComparators::compareTwoPairHands),
    THREE_OF_A_KIND("Three cards of the same value",
            PokerHandTests::isThreeOfAKind,
            PokerHandComparators::compareThreeOfAKindHands),
    STRAIGHT("All cards are consecutive values",
            PokerHandTests::isStraight),
    FLUSH("All cards of the same suit",
            PokerHandTests::isFlush),
    FULL_HOUSE("Three of a kind and a pair",
            PokerHandTests::isFullHouse,
            PokerHandComparators::compareFullHouseHands),
    FOUR_OF_A_KIND("Four cards of the same value",
            PokerHandTests::isFourOfAKind,
            PokerHandComparators::compareFourOfAKindHands),
    STRAIGHT_FLUSH("All cards are consecutive values of same suit",
            PokerHandTests::isStraightFlush),
    ROYAL_FLUSH(" Ten, Jack, Queen, King, Ace, in same suit",
            PokerHandTests::isRoyalFlush);

    public final String description;
    public final Function<Hand, Boolean> test;
    public final Comparator<Hand> comparator;

    PokerHandTypes(String description, Function<Hand, Boolean> test){
        this.description = description;
        this.test = test;
        this.comparator = PokerHandComparators::compareByHighCard;
    }

    PokerHandTypes(String description, Function<Hand, Boolean> test, Comparator<Hand> comp){
        this.description = description;
        this.test = test;
        this.comparator = comp;
    }

    public static List<PokerHandTypes> highestToLowest(){
        List<PokerHandTypes> ordinalOrder = Arrays.asList(PokerHandTypes.values());
        //Collections.reverse(ordinalOrder);
        //reverse is great but today we use streams! ("aggregate operations")
        List<PokerHandTypes> highestToLowest = ordinalOrder.stream()
                .sorted(Comparator.<PokerHandTypes>naturalOrder().reversed())
                .collect(Collectors.toList());
        return highestToLowest;
    }

}


