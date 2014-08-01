package poker.game;

import poker.model.Hand;
import poker.model.PokerHand;

import java.util.List;

public class Poker {

    Poker(){}

    public static PokerHand evaluateHand(Hand hand){
        for(PokerHand pokerHand : PokerHand.highestToLowest()){
            if (pokerHand.test.apply(hand)){
                return pokerHand;
            }
        }
        throw new IllegalArgumentException("This hand could not be evaluated: " + hand.toString());
    }

    public static Hand compareTwoHands(Hand handOne, Hand handTwo){
        PokerHand handOneRank = evaluateHand(handOne);
        PokerHand handTwoRank = evaluateHand(handTwo);
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
