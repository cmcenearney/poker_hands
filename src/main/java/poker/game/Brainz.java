package poker.game;

import poker.model.Hand;
import poker.model.hands.PokerHands;

public class Brainz {

    Brainz(){}

    public PokerHands evaluateHand(Hand hand){
        for(PokerHands pokerHand : PokerHands.highestToLowest()){
            //System.out.println(pokerHand.ordinal() + " " + pokerHand.name());
            if (pokerHand.test.apply(hand)){
                return pokerHand;
            }
        }
        return PokerHands.values()[0];
    }

    public Hand compareTwoHands(Hand handOne, Hand handTwo){
        PokerHands handOneRank = evaluateHand(handOne);
        PokerHands handTwoRank = evaluateHand(handTwo);
        if (handOneRank.equals(handTwoRank)){
            //each hand has custom comparator for this situation ?
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
