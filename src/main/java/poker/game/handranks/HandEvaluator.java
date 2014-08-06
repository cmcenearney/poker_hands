package poker.game.handranks;

import poker.model.Hand;
import poker.model.Rank;

import java.util.TreeSet;

public interface HandEvaluator {

    static boolean test(Hand hand) {return false;}

    //default to basic high card comparison
    default int compareTwoHands(Hand one, Hand two){
        if ( one.getHighestCard().getRank().position() > two.getHighestCard().getRank().position() ) return 1;
        if ( one.getHighestCard().getRank().position() < two.getHighestCard().getRank().position() ) return -1;
        return 0;
    }

    default int compareRemainingRanks(TreeSet<Rank> one, TreeSet<Rank> two){
        if (one.size() == 1 && two.size() == 1){
            return one.last().position() - two.last().position();
        }
        Rank oneHighest = one.pollLast();
        Rank twoHighest = two.pollLast();
        if (oneHighest != twoHighest){
            return oneHighest.position() - twoHighest.position();
        } else {
            return compareRemainingRanks(one, two);
        }
    }

}
