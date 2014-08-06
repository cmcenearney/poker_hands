package poker.game.handranks;

import poker.model.Hand;

public class Straight implements HandEvaluator {

    public static boolean test(Hand hand){
        return hand.isAStraight();
    }

}
