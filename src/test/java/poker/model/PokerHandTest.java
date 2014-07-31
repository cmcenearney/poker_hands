package poker.model;

import org.junit.Test;
import poker.game.PokerTest;

import static org.junit.Assert.assertEquals;

public class PokerHandTest extends PokerTest {

//test hand 'test' functions
    @Test
    public void testSimpleHighCard(){
        assertEquals(true, PokerHand.HIGH_CARD.test.apply(handSimpleHighCard));
        assertEquals(false, PokerHand.TWO_PAIR.test.apply(handSimpleThreeOfAKind));
        assertEquals(false, PokerHand.TWO_PAIR.test.apply(handSimplePair));
    }

    @Test
    public void testSimpleTwoPair(){
        assertEquals(true, PokerHand.TWO_PAIR.test.apply(handSimpleTwoPair));
        assertEquals(false, PokerHand.TWO_PAIR.test.apply(handSimpleThreeOfAKind));
        assertEquals(false, PokerHand.TWO_PAIR.test.apply(handSimplePair));
    }

    @Test
    public void testSimpleThreeOfAKind(){
        assertEquals(true, PokerHand.THREE_OF_A_KIND.test.apply(handSimpleThreeOfAKind));
        assertEquals(false, PokerHand.THREE_OF_A_KIND.test.apply(handSimplePair));
        assertEquals(false, PokerHand.THREE_OF_A_KIND.test.apply(handSimpleTwoPair));
        assertEquals(false, PokerHand.THREE_OF_A_KIND.test.apply(handSimpleFourOfAKind));
    }

    @Test
    public void testSimpleStraight(){
        assertEquals(true, PokerHand.STRAIGHT.test.apply(handSimpleStraight));
    }

    @Test
    public void testSimpleFlush(){
        assertEquals(true, PokerHand.FLUSH.test.apply(handSimpleFlush));
    }

    @Test
    public void testSimpleFullHouse(){
        assertEquals(true, PokerHand.FULL_HOUSE.test.apply(handSimpleFullHouse));
    }

    @Test
    public void testSimpleFourOfAKind(){
        assertEquals(true, PokerHand.FOUR_OF_A_KIND.test.apply(handSimpleFourOfAKind));
    }

    @Test
    public void testSimpleStraightFlush(){
        assertEquals(true, PokerHand.STRAIGHT_FLUSH.test.apply(handSimpleStraightFlush));
    }

    @Test
    public void testSimpleRoyalFlush(){
        assertEquals(true, PokerHand.ROYAL_FLUSH.test.apply(handSimpleRoyalFlush));
    }

}