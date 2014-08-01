package poker;

import poker.game.Poker;
import poker.model.Hand;
import poker.utils.Utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

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
        Hand[] hands = Utils.parseEulerLine(line);
        if (hands == null){
            throw new IllegalArgumentException("could not parse: " + line);
        }
        Hand winner = Poker.compareTwoHands(hands[0], hands[1]);
        if (winner != null) {
            if (winner.equals(hands[0]))
                playerOneWins++;
        }
    }

}
