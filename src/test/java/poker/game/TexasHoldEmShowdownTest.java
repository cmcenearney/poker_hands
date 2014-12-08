package poker.game;

import org.junit.Test;
import poker.Euler;
import poker.model.Card;
import poker.model.Hand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TexasHoldEmShowdownTest {

    Hand playerOne = Euler.parseEulerFormat("4D AC");
    Hand playerTwo = Euler.parseEulerFormat("9S AS");
    Hand playerThree = Euler.parseEulerFormat("KD KH");
    Hand playerFour = Euler.parseEulerFormat("5D 6D");
    List<Card> board = new ArrayList<Card>(Arrays.asList(
            new Card("4C"), new Card("KS"), new Card("4H"), new Card("8S"), new Card("7S")
    ));


    @Test
    public void testWeCanAddCardsToHandsWithLessThanFiveCards(){
        playerOne.addCard(new Card("TH"));
    }

    

}
