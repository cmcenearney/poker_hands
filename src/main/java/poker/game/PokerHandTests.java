package poker.game;

import poker.model.Hand;
import poker.model.Rank;

public class PokerHandTests {

    public static boolean isHighCard(Hand hand){
        return true;
    }

    public static boolean isOnePair(Hand hand){
        return hand.numberOfRanksWithCount(2) == 1;
    }

    public static boolean isTwoPair(Hand hand){
        return hand.numberOfRanksWithCount(2) == 2;
    }

    public static boolean isThreeOfAKind(Hand hand){
        return (hand.isOfAKind(3) && (hand.numberOfRanksWithCount(3) == 1));
    }

    public static boolean isStraight(Hand hand){
        return hand.isAStraight();
    }

    public static boolean isFlush(Hand hand){
        return hand.isAllOneSuit();
    }

    public static boolean isFullHouse(Hand hand){
        return hand.numberOfRanksWithCount(2) == 1 && hand.numberOfRanksWithCount(3) == 1;
    }

    public static boolean isFourOfAKind(Hand hand){
        return hand.numberOfRanksWithCount(4) == 1;
    }

    public static boolean isStraightFlush(Hand hand){
        return hand.isAStraight() && hand.isAllOneSuit();
    }

    public static boolean isRoyalFlush(Hand hand){
        return hand.isAStraight() && hand.isAllOneSuit() && hand.getHighestCard().getRank().equals(Rank.ACE);
    }

}
