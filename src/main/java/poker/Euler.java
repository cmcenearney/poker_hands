package poker;

import poker.game.Poker;
import poker.model.Card;
import poker.model.Hand;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Euler {

    static final String eulerHandsFileDefault = "src/main/resources/euler_hands.txt";
    static int playerOneWins = 0;

    public static void main(String[] args){
        String file  = (args.length == 0) ? eulerHandsFileDefault : args[0];
        try {
            Files.lines(Paths.get(file),Charset.defaultCharset())
                    .forEach(line -> evaluateEuler(line));
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(playerOneWins);
    }

    static void evaluateEuler(String line){
        Hand[] hands = parseEulerLine(line);
        if (hands == null){
            throw new IllegalArgumentException("could not parse: " + line);
        }
        int winner = Poker.compareTwoHands(hands[0], hands[1]);
        if (winner > 0) {
                playerOneWins++;
        }
    }

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
