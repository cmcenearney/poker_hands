package poker.game;

import poker.model.Hand;

import java.util.Collections;
import java.util.List;

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

    public static int compareTwoHands(Hand handOne, Hand handTwo){
        PokerHandTypes handOneRank = evaluateHand(handOne);
        PokerHandTypes handTwoRank = evaluateHand(handTwo);
        if (handOneRank.equals(handTwoRank)){
            //each hand has custom comparator for this situation
            return handOneRank.comparator.compare(handOne, handTwo);
        } else {
            if (handOneRank.ordinal() > handTwoRank.ordinal()){
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static Hand winnerFromList(List<Hand> hands){
        Collections.sort(hands, Poker::compareTwoHands);
        return hands.get(hands.size() - 1);
    }

}
