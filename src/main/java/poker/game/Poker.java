package poker.game;

import poker.model.Hand;

public class Poker {

    Poker(){}

    public static PokerHandTypes evaluateHand(Hand hand){
        for(PokerHandTypes pokerHandTypes : PokerHandTypes.highestToLowest()){
            if (pokerHandTypes.test.apply(hand)){
                return pokerHandTypes;
            }
        }
        throw new IllegalArgumentException("This hand could not be evaluated: " + hand.toString());
    }

    public static Hand compareTwoHands(Hand handOne, Hand handTwo){
        PokerHandTypes handOneRank = evaluateHand(handOne);
        PokerHandTypes handTwoRank = evaluateHand(handTwo);
        if (handOneRank.equals(handTwoRank)){
            //each hand has custom comparator for this situation
            int comparison = handOneRank.comparator.compare(handOne, handTwo);
            if (comparison > 0){
                return handOne;
            } else if (comparison < 0){
                return handTwo;
            }
        } else {
            if (handOneRank.ordinal() > handTwoRank.ordinal()){
                return handOne;
            } else {
                return handTwo;
            }
        }
        return null;
    }

}
