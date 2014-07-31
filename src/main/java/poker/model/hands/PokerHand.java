package poker.model.hands;

import poker.model.Hand;

public interface PokerHand {

    static boolean test(Hand hand){
        return false;
    }

    static int compareTwoHands(Hand one, Hand two){
        if ( one.getHighestCard().getRank().position() > two.getHighestCard().getRank().position() ) return 1;
        if ( one.getHighestCard().getRank().position() < two.getHighestCard().getRank().position() ) return -1;
        return 0;
    }
}

