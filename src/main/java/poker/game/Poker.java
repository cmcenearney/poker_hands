package poker.game;

import poker.game.handranks.HandEvaluator;
import poker.model.Hand;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

public class Poker {

    public static final String TOO_MANY_CARDS_ERROR = "Hold yer horses pard. 7 cards is the max round here.";
    public static final int MAX_CARDS = 7;

    public static PokerHandRanks evaluateHand(Hand hand)  {
        for(PokerHandRanks pokerHandType : PokerHandRanks.highestToLowest()){
            try {
                Class<? extends HandEvaluator> c = pokerHandType.evaluator;
                Method testMethod = pokerHandType.evaluator.getMethod("test", Hand.class);
                Boolean testResult = (Boolean) testMethod.invoke(c, hand);
                if (testResult) {
                    return pokerHandType;
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        throw new IllegalArgumentException("This hand could not be evaluated: " + hand.toString());
    }

    public static int compareTwoHands(Hand handOne, Hand handTwo){
        PokerHandRanks handOneRank = evaluateHand(handOne);
        PokerHandRanks handTwoRank = evaluateHand(handTwo);
        if (handOneRank.equals(handTwoRank)){
            //each hand has custom comparator for this situation
            try {
                HandEvaluator i = (HandEvaluator) handOneRank.evaluator.newInstance();
                return i.compareTwoHands(handOne, handTwo);
            } catch (Exception e){
                e.printStackTrace();
            }

        } else {
            if (handOneRank.ordinal() > handTwoRank.ordinal()){
                return 1;
            } else {
                return -1;
            }
        }
        throw new IllegalArgumentException("Error evaluating these hands: " + handOne.toString() + " " + handTwo.toString());
    }

    public static Hand winnerFromList(List<Hand> hands){
        Collections.sort(hands, Poker::compareTwoHands);
        return hands.get(hands.size() - 1);
    }

}
