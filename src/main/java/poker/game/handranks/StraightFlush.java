package poker.game.handranks;

import poker.model.Hand;

public class StraightFlush implements HandEvaluator {

    public static boolean test(Hand hand){
        return hand.isAStraight() && hand.isAllOneSuit();
    }

}
