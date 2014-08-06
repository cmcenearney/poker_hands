package poker.game;

import org.junit.Test;
import poker.Euler;
import poker.model.Hand;
import static org.junit.Assert.assertEquals;

public class PokerTest {

    public Hand handSimpleHighCard = Euler.parseEulerFormat("2H 5D 7C 9D AS");
    public Hand handSimplePair = Euler.parseEulerFormat("2H 2D 4C 5D 7S");
    public Hand handSimpleTwoPair = Euler.parseEulerFormat("2H 2D 4C 4D 8S");
    public Hand handSimpleThreeOfAKind = Euler.parseEulerFormat("2H 2D 4C 4D 4S");
    public Hand handSimpleStraight = Euler.parseEulerFormat("2H 3D 4C 5D 6S");
    public Hand handSimpleFlush = Euler.parseEulerFormat("2H KH 8H 4H JH");
    public Hand handSimpleFullHouse = Euler.parseEulerFormat("2H 2D 4C 4D 4S");
    public Hand handSimpleFourOfAKind = Euler.parseEulerFormat("2H 6H 6C 6D 6S");
    public Hand handSimpleStraightFlush = Euler.parseEulerFormat("7C 8C 4C 5C 6C");
    public Hand handSimpleRoyalFlush = Euler.parseEulerFormat("AD JD QD KD TD");

    public Hand handOnePairJack = Euler.parseEulerFormat("2H 7D 4C JD JS");
    public Hand handOnePairNine = Euler.parseEulerFormat("9H 2D 4C 9D AS");

    public Hand handTwoPairKingQueen = Euler.parseEulerFormat("QD QS 3C KS KH");
    public Hand handTwoPairKingFour = Euler.parseEulerFormat("KD KC AH 4D 4S");

    public Hand handThreeOfAKindQueen = Euler.parseEulerFormat("QD QS QC KS 6H");
    public Hand handThreeOfAKindFour = Euler.parseEulerFormat("AD 3C 4H 4D 4S");

    public Hand handStraightTen = Euler.parseEulerFormat("TD 9S 8C 7S 6H");
    public Hand handStraightSix = Euler.parseEulerFormat("2D 3C 4H 5D 6S");

    public Hand handFlushAce = Euler.parseEulerFormat("TD 5D 3D 7D AD");
    public Hand handFlushNine = Euler.parseEulerFormat("2S 3S 9S 5S 6S");

    public Hand handFullHouseAceTwo = Euler.parseEulerFormat("AD AS AC 2S 2H");
    public Hand handFullHouseAceThree = Euler.parseEulerFormat("AD AC AH 3D 3S");

    public Hand handFourOfAKindQueen = Euler.parseEulerFormat("QD QS QC KS QH");
    public Hand handFourOfAKindFour = Euler.parseEulerFormat("AD 4C 4H 4D 4S");

    public Hand handStraightFlushJack = Euler.parseEulerFormat("JD TD 8D 7D 9D");
    public Hand handStraightFlushNine = Euler.parseEulerFormat("5S 6S 7S 8S 9S");

    public Hand handRoyalFlushClubs  = Euler.parseEulerFormat("TC AC JC QC KC");
    public Hand handRoyalFlushHearts = Euler.parseEulerFormat("AH KH QH JH TH");

    public Hand tieHandPairTwoHighCardAceToSeven = Euler.parseEulerFormat("2C 2D AC 9H 7S");
    public Hand tieHandPairTwoHighCardAceToEight = Euler.parseEulerFormat("2S 2H AD 9C 8S");

    public Hand tieHandTwoPairTwoHighCardSeven = Euler.parseEulerFormat("2C 2D AC AH 7S");
    public Hand tieHandTwoPairTwoHighCardEight = Euler.parseEulerFormat("2S 2H AD AS 8S");

    public Hand tieHandThreeOfAKindEight = Euler.parseEulerFormat("2C 2D 2H AH 8S");
    public Hand tieHandThreeOfAKindSeven = Euler.parseEulerFormat("2S 2H 2D AS 7S");

    public Hand trueTieHandPair = Euler.parseEulerFormat("2C 4D 9H 8H 8S");
    public Hand trueTieHandPair2 = Euler.parseEulerFormat("2S 4H 9D 8D 8C");

    //isolate tests from implementation
    public static Hand compareTwoHands(Hand one, Hand two){
        return Poker.compareTwoHands(one, two);
    }

    public static PokerHandTypes evaluateHand(Hand hand){
        return Poker.evaluateHand(hand);
    }

    @Test
    public void basicTest() {
        Hand handSimpleThreeOfAKind = Euler.parseEulerFormat("2H 2D 4C 4D 4S");
        evaluateHand(handSimpleThreeOfAKind);
    }

    //test hand 'test' functions
    @Test
    public void testSimpleHighCard(){
        assertEquals(true, PokerHandTypes.HIGH_CARD.test.apply(handSimpleHighCard));
        assertEquals(false, PokerHandTypes.TWO_PAIR.test.apply(handSimpleThreeOfAKind));
        assertEquals(false, PokerHandTypes.TWO_PAIR.test.apply(handSimplePair));
    }

    @Test
    public void testSimpleTwoPair(){
        assertEquals(true, PokerHandTypes.TWO_PAIR.test.apply(handSimpleTwoPair));
        assertEquals(false, PokerHandTypes.TWO_PAIR.test.apply(handSimpleThreeOfAKind));
        assertEquals(false, PokerHandTypes.TWO_PAIR.test.apply(handSimplePair));
    }

    @Test
    public void testSimpleThreeOfAKind(){
        assertEquals(true, PokerHandTypes.THREE_OF_A_KIND.test.apply(handSimpleThreeOfAKind));
        assertEquals(false, PokerHandTypes.THREE_OF_A_KIND.test.apply(handSimplePair));
        assertEquals(false, PokerHandTypes.THREE_OF_A_KIND.test.apply(handSimpleTwoPair));
        assertEquals(false, PokerHandTypes.THREE_OF_A_KIND.test.apply(handSimpleFourOfAKind));
    }

    @Test
    public void testSimpleStraight(){
        assertEquals(true, PokerHandTypes.STRAIGHT.test.apply(handSimpleStraight));
    }

    @Test
    public void testSimpleFlush(){
        assertEquals(true, PokerHandTypes.FLUSH.test.apply(handSimpleFlush));
    }

    @Test
    public void testSimpleFullHouse(){
        assertEquals(true, PokerHandTypes.FULL_HOUSE.test.apply(handSimpleFullHouse));
    }

    @Test
    public void testSimpleFourOfAKind(){
        assertEquals(true, PokerHandTypes.FOUR_OF_A_KIND.test.apply(handSimpleFourOfAKind));
    }

    @Test
    public void testSimpleStraightFlush(){
        assertEquals(true, PokerHandTypes.STRAIGHT_FLUSH.test.apply(handSimpleStraightFlush));
    }

    @Test
    public void testSimpleRoyalFlush(){
        assertEquals(true, PokerHandTypes.ROYAL_FLUSH.test.apply(handSimpleRoyalFlush));
    }

    //correct evaluation - hands of different types
    @Test
    public void testOnePairBeatsHighCard() {
        Hand winner = compareTwoHands(handSimplePair, handSimpleHighCard);
        assertEquals(handSimplePair, winner);
    }

    @Test
    public void testThreeOfAKindBeatsHighCard() {
        Hand winner = compareTwoHands(handSimpleHighCard, handSimpleThreeOfAKind);
        assertEquals(handSimpleThreeOfAKind, winner);
    }

    @Test
    public void testTwoPairBeatsOnePair() {
        Hand winner = compareTwoHands(handSimplePair, handSimpleTwoPair);
        assertEquals(handSimpleTwoPair, winner);
    }

    @Test
    public void testThreeOfAKindBeatsTwoPair() {
        Hand winner = compareTwoHands(handSimpleTwoPair, handSimpleThreeOfAKind);
        assertEquals(handSimpleThreeOfAKind, winner);
    }

    @Test
    public void testFourOfAKindEvaluates() {
        assertEquals(PokerHandTypes.FOUR_OF_A_KIND, evaluateHand(handSimpleFourOfAKind));
    }

    @Test
    public void testFourOfAKindBeatsTwoPair() {
        Hand winner = compareTwoHands(handSimpleTwoPair, handSimpleFourOfAKind);
        assertEquals(handSimpleFourOfAKind, winner);
    }

    //hands of the same type
    @Test
    public void testOnePairComparison() {
        Hand winner = compareTwoHands(handOnePairJack, handOnePairNine);
        assertEquals(handOnePairJack, winner);
    }

    @Test
    public void testTwoPairComparison() {
        Hand winner = compareTwoHands(handTwoPairKingQueen, handTwoPairKingFour);
        assertEquals(handTwoPairKingQueen, winner);
    }

    @Test
    public void testThreeOfAKindComparison() {
        Hand winner = compareTwoHands(handThreeOfAKindQueen, handThreeOfAKindFour);
        assertEquals(handThreeOfAKindQueen, winner);
    }

    @Test
    public void testStraightComparison() {
        Hand winner = compareTwoHands(handStraightSix, handStraightTen);
        assertEquals(handStraightTen, winner);
    }

    @Test
    public void testFlushComparison() {
        Hand winner = compareTwoHands(handFlushAce, handFlushNine);
        assertEquals(handFlushAce, winner);
    }

    @Test
    public void testFullHouseComparison() {
        Hand winner = compareTwoHands(handFullHouseAceTwo, handFullHouseAceThree);
        assertEquals(handFullHouseAceThree, winner);
    }

    @Test
    public void testFourOfAKindComparison() {
        Hand winner = compareTwoHands(handFourOfAKindFour, handFourOfAKindQueen);
        assertEquals(handFourOfAKindQueen, winner);
    }

    @Test
    public void testStraightFlushComparison() {
        Hand winner = compareTwoHands(handStraightFlushJack, handStraightFlushNine);
        assertEquals(handStraightFlushJack, winner);
    }

    //any two Royal Flushes are a tie
    @Test
    public void testRoyalFlushComparison() {
        Hand winner = compareTwoHands(handRoyalFlushClubs, handRoyalFlushHearts);
        assertEquals(null, winner);
    }


    @Test
    public void testPairTieJudgedCorrectly(){
        Hand winner = compareTwoHands(tieHandPairTwoHighCardAceToEight, tieHandPairTwoHighCardAceToSeven);
        assertEquals(tieHandPairTwoHighCardAceToEight, winner);
    }

    @Test
    public void testTwoPairTieJudgedCorrectly(){
        Hand winner = compareTwoHands(tieHandTwoPairTwoHighCardSeven, tieHandTwoPairTwoHighCardEight);
        assertEquals(tieHandTwoPairTwoHighCardEight, winner);
    }

    @Test
    public void testThreeOfAKindTieJudgedCorrectly(){
        Hand winner = compareTwoHands(tieHandThreeOfAKindEight, tieHandThreeOfAKindSeven);
        assertEquals(tieHandThreeOfAKindEight, winner);
    }

    @Test
    public void testTrueTieHasNoWinner(){
        Hand winner = compareTwoHands(trueTieHandPair, trueTieHandPair2);
        assertEquals(null, winner);
    }

}