package poker.game;

import combinatrix.Combinatrix;
import poker.game.handranks.HandEvaluator;
import poker.model.Card;
import poker.model.Hand;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        List<Hand> handsCopy = hands.stream().collect(Collectors.toList());
        Collections.sort(handsCopy, Poker::compareTwoHands);
        return handsCopy.get(handsCopy.size() - 1);
    }

    public static Hand showdown(List<Card> board, List<Hand> players){
        List<Hand> bestHands = players.stream()
                .map(p -> bestHandFromBoard(board, p))
                .collect(Collectors.toList());
        Hand winner = winnerFromList(bestHands);
        return players.get(bestHands.indexOf(winner));
    }

    private static Hand bestHandFromBoard(List<Card> board, Hand hand){
        Set<List<Card>> combos = new Combinatrix<>(5,3,board).hurtMe();
        List<Hand> hands = new ArrayList<>();
        for (List<Card> comboFromBoard : combos){
            Hand copy = new Hand(hand.getCards());
            comboFromBoard.stream().forEach(c -> copy.addCard(c));
            hands.add(copy);
        }
        return winnerFromList(hands);
    }

}
