//package poker.model;
//
//import org.junit.Test;
//import poker.PokerTest;
//import poker.model.hands.PokerHands;
//
//import static org.junit.Assert.assertEquals;
//
//public class PokerHandTest extends PokerTest{
//
////test hand 'test' functions
//    @Test
//    public void testSimpleHighCard(){
//        assertEquals(true, PokerHands.HIGH_CARD.test.apply(handSimpleHighCard));
//        assertEquals(false, PokerHands.TWO_PAIR.test.apply(handSimpleThreeOfAKind));
//        assertEquals(false, PokerHands.TWO_PAIR.test.apply(handSimplePair));
//    }
//
//    @Test
//    public void testSimpleTwoPair(){
//        assertEquals(true, PokerHands.TWO_PAIR.test.apply(handSimpleTwoPair));
//        assertEquals(false, PokerHands.TWO_PAIR.test.apply(handSimpleThreeOfAKind));
//        assertEquals(false, PokerHands.TWO_PAIR.test.apply(handSimplePair));
//    }
//
//    @Test
//    public void testSimpleThreeOfAKind(){
//        assertEquals(true, PokerHands.THREE_OF_A_KIND.test.apply(handSimpleThreeOfAKind));
//        assertEquals(false, PokerHands.THREE_OF_A_KIND.test.apply(handSimplePair));
//        assertEquals(false, PokerHands.THREE_OF_A_KIND.test.apply(handSimpleTwoPair));
//        assertEquals(false, PokerHands.THREE_OF_A_KIND.test.apply(handSimpleFourOfAKind));
//    }
//
//    @Test
//    public void testSimpleStraight(){
//        assertEquals(true, PokerHands.STRAIGHT.test.apply(handSimpleStraight));
//    }
//
//    @Test
//    public void testSimpleFlush(){
//        assertEquals(true, PokerHands.FLUSH.test.apply(handSimpleFlush));
//    }
//
//    @Test
//    public void testSimpleFullHouse(){
//        assertEquals(true, PokerHands.FULL_HOUSE.test.apply(handSimpleFullHouse));
//    }
//
//    @Test
//    public void testSimpleFourOfAKind(){
//        assertEquals(true, PokerHands.FOUR_OF_A_KIND.test.apply(handSimpleFourOfAKind));
//    }
//
//    @Test
//    public void testSimpleStraightFlush(){
//        assertEquals(true, PokerHands.STRAIGHT_FLUSH.test.apply(handSimpleStraightFlush));
//    }
//
//    @Test
//    public void testSimpleRoyalFlush(){
//        assertEquals(true, PokerHands.ROYAL_FLUSH.test.apply(handSimpleRoyalFlush));
//    }
//
//}