package poker.game;

import org.junit.Before;
import org.junit.Test;
import poker.Euler;
import poker.model.Card;
import poker.model.Hand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TexasHoldEmShowdownTest {

    /*
    test case taken from http://en.wikipedia.org/wiki/Texas_hold_%27em
    the best hand should playerThree with a Full house, kings full of fours
     */
    Hand playerOne = Euler.parseEulerFormat("4D AC");
    Hand playerTwo = Euler.parseEulerFormat("9S AS");
    Hand playerThree = Euler.parseEulerFormat("KD KH");
    Hand playerFour = Euler.parseEulerFormat("5D 6D");
    List<Card> board = new ArrayList<Card>(Arrays.asList(
            new Card("4C"), new Card("KS"), new Card("4H"), new Card("8S"), new Card("7S")
    ));
    List<Hand> players;

    @Before
    public void setUp(){
        players = new ArrayList<>(Arrays.asList(playerOne, playerTwo, playerThree, playerFour));
    }

    @Test
    public void testWeCanAddCardsToHandsWithLessThanFiveCards(){
        playerOne.addCard(new Card("TH"));
    }

    @Test
    public void testShowdown(){
        Hand winner = Poker.showdown(board, players);
        assertEquals(playerThree, winner);
    }

}
