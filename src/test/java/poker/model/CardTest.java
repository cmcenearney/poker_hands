package poker.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void testAbbrevConstructor(){
        Card c = new Card("2H");
        assertEquals(Rank.TWO, c.getRank());
        assertEquals(Suit.HEARTS, c.getSuit());
    }

    @Test
    public void testEquality(){
        Card c1 = new Card("KH");
        Card c2 = new Card("KH");
        assertEquals(c1, c2);
    }

    @Test
    public void testInequality(){
        Card c1 = new Card("KH");
        Card c2 = new Card("KS");
        assertFalse(c1.equals(c2));
    }

}
