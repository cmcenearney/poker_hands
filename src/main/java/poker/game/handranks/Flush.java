package poker.game.handranks;

import poker.model.Hand;

public class Flush implements HandEvaluator {

    public static boolean test(Hand hand){
        return hand.isAllOneSuit();
    }
}
