package poker;

import poker.game.Brainz;
import poker.model.Card;
import poker.model.Hand;
import poker.utils.HandBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Euler {

    static final String eulerHandsFileDefault = "src/main/resources/euler_hands.txt";
    static int playerOneWins = 0;

    public static void main(String[] args){
        String file  = (args.length == 0) ? eulerHandsFileDefault : args[0];
        Stream<String> lines;
        try {
            Files.lines(Paths.get(file),Charset.defaultCharset())
                    .forEach(line -> evaluateEuler(line));
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(playerOneWins);
    }

    static void evaluateEuler(String line){
        Hand[] hands = HandBuilder.parseEulerLine(line);
        if (hands == null){
            System.out.println(line);
        }
        Hand winner = Brainz.compareTwoHands(hands[0], hands[1]);
        if (winner != null) {
            if (winner.equals(hands[0]))
                playerOneWins++;
        }
    }

}
