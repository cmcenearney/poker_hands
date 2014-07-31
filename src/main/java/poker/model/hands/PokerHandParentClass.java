package poker.model.hands;

import poker.model.Hand;

public abstract class PokerHandParentClass {

    PokerHandParentClass(){}

    public abstract boolean test(Hand hand);

    public int compareTwoHands(Hand one, Hand two){
        if ( one.getHighestCard().getRank().position() > two.getHighestCard().getRank().position() ) return 1;
        if ( one.getHighestCard().getRank().position() < two.getHighestCard().getRank().position() ) return -1;
        return 0;
    }
}


//TODO: delete this class? use interface instead?