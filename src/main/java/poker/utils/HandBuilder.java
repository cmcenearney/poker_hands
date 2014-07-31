package poker.utils;

import poker.model.Card;
import poker.model.Hand;

import java.util.Arrays;

public class HandBuilder {

    public static Hand parseEulerFormat(String handString){
        Hand hand = new Hand();
        String[] cardAbbreviations = handString.split(" ");
        for (String cardAbbrev : cardAbbreviations){
            Card card = new Card(cardAbbrev);
            hand.addCard(card);
        }
        return hand;
    }

    public static Hand[] parseEulerLine(String line){
        String[] items = line.split(" ");
        if (items.length != 10){
            throw new IllegalArgumentException("expecting ten cards per line in format: 8C TS KC 9H 4S 7D 2S 5D 3S AC");
        }
        String[] playerOneCards = Arrays.copyOfRange(items, 0, 5);
        Hand playerOneHand = new Hand();
        for (String cardString : playerOneCards){
            Card card = new Card(cardString);
            playerOneHand.addCard(card);
        }
        String[] playerTwoCards = Arrays.copyOfRange(items, 5, 10);
        Hand playerTwoHand = new Hand();
        for (String cardString : playerTwoCards){
            Card card = new Card(cardString);
            playerTwoHand.addCard(card);
        }
        Hand[] hands = new Hand[2];
        hands[0] = playerOneHand;
        hands[1] = playerTwoHand;
        return hands;
    }

}
