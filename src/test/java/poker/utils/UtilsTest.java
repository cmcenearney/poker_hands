package poker.utils;

import org.junit.Before;
import org.junit.Test;
import poker.model.Card;
import poker.model.Hand;

import static org.junit.Assert.*;

public class UtilsTest {

    Hand handSimpleThreeOfAKind;

    @Before
    public void setup(){
        handSimpleThreeOfAKind = new Hand();
        handSimpleThreeOfAKind.addCard(new Card("2H"));
        handSimpleThreeOfAKind.addCard(new Card("2D"));
        handSimpleThreeOfAKind.addCard(new Card("4S"));
        handSimpleThreeOfAKind.addCard(new Card("4C"));
        handSimpleThreeOfAKind.addCard(new Card("4D"));
    }

    @Test
    public void testParseEulerFormat(){
        String euler = "2H 2D 4C 4D 4S";
        Hand hand = Utils.parseEulerFormat(euler);
        assert(hand.getCards().size() == 5);
        assertEquals(hand.getCards(), handSimpleThreeOfAKind.getCards());
    }

    @Test
    public void testParseEulerLine(){
        String line = "AD QH TH 9D 8H TS 6D 3S AS AC";
        Hand[] parsed = Utils.parseEulerLine(line);
        assert(parsed[0].getCards().size() == 5);
        assert(parsed[1].getCards().size() == 5);
    }

}