package poker;

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

    public static void main(String[] args){
        String file  = (args.length == 0) ? eulerHandsFileDefault : args[0];
        Stream<String> lines;
        try {
            Files.lines(Paths.get(file),Charset.defaultCharset())
                    .forEach(line -> HandBuilder.parseEulerLine(line));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
