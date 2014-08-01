package poker.utils;

import poker.model.Card;
import poker.model.Hand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static Hand parseEulerFormat(String handString){
        List<Card> cards = new ArrayList<>();
        List<String> cardAbbrevs = Arrays.asList(handString.split(" "));
        if (cards.size() > 7){
            throw new IllegalArgumentException("Whoa dude - 7 is the max");
        }
        cardAbbrevs.stream()
                .forEach(c -> cards.add(new Card(c)));
        return new Hand(cards);
    }

    public static Hand[] parseEulerLine(String line){
        List<String> cardAbbrevs = Arrays.asList(line.split(" "));

        if (cardAbbrevs.size() != 10){
            throw new IllegalArgumentException("expecting ten cards per line in format: 8C TS KC 9H 4S 7D 2S 5D 3S AC");
        }

        List<Card> cards = new ArrayList<>();
        cardAbbrevs.stream()
                .forEach(c -> cards.add(new Card(c)));

        Hand playerOneHand = new Hand(cards.subList(0,5));
        Hand playerTwoHand = new Hand(cards.subList(5,10));

        Hand[] hands = new Hand[2];
        hands[0] = playerOneHand;
        hands[1] = playerTwoHand;
        return hands;
    }

}
