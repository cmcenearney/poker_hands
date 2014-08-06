package poker.game;

import poker.game.handranks.*;

import java.util.*;
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
public enum PokerHandRanks {

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


    public final Class<? extends HandEvaluator> evaluator;

    PokerHandRanks(Class<? extends HandEvaluator> c){
        this.evaluator = c;
    }

    public static List<PokerHandRanks> highestToLowest(){
        List<PokerHandRanks> ordinalOrder = Arrays.asList(PokerHandRanks.values());
        //Collections.reverse(ordinalOrder);
        //reverse is great but today we use streams!
        List<PokerHandRanks> highestToLowest = ordinalOrder.stream()
                .sorted(Comparator.<PokerHandRanks>naturalOrder().reversed())
                .collect(Collectors.toList());
        return highestToLowest;
    }

}


