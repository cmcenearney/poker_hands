package poker.game;

import org.junit.Before;
import org.junit.Test;
import poker.PokerTest;
import poker.model.Hand;
import poker.model.PokerHand;
import poker.utils.HandBuilder;

import static org.junit.Assert.assertEquals;

public class BrainzTest extends PokerTest {

    Brainz brainz;

    @Before
    public void setUp() {
        brainz = new Brainz();
    }

    @Test
    public void basicTest() {
        Hand handSimpleThreeOfAKind = HandBuilder.parseEulerFormat("2H 2D 4C 4D 4S");
        brainz.evaluateHand(handSimpleThreeOfAKind);
    }

    //correct evaluation - hands of different types
    @Test
    public void testOnePairBeatsHighCard() {
        Hand winner = brainz.compareTwoHands(handSimplePair, handSimpleHighCard);
        assertEquals(handSimplePair, winner);
    }

    @Test
    public void testThreeOfAKindBeatsHighCard() {
        Hand winner = brainz.compareTwoHands(handSimpleHighCard, handSimpleThreeOfAKind);
        assertEquals(handSimpleThreeOfAKind, winner);
    }

    @Test
    public void testTwoPairBeatsOnePair() {
        Hand winner = brainz.compareTwoHands(handSimplePair, handSimpleTwoPair);
        assertEquals(handSimpleTwoPair, winner);
    }

    @Test
    public void testThreeOfAKindBeatsTwoPair() {
        Hand winner = brainz.compareTwoHands(handSimpleTwoPair, handSimpleThreeOfAKind);
        assertEquals(handSimpleThreeOfAKind, winner);
    }

    @Test
    public void testFourOfAKindEvaluates() {
        assertEquals(PokerHand.FOUR_OF_A_KIND, brainz.evaluateHand(handSimpleFourOfAKind));
    }

    @Test
    public void testFourOfAKindBeatsTwoPair() {
        Hand winner = brainz.compareTwoHands(handSimpleTwoPair, handSimpleFourOfAKind);
        assertEquals(handSimpleFourOfAKind, winner);
    }

    //hands of the same type
    @Test
    public void testOnePairComparison() {
        Hand winner = brainz.compareTwoHands(handOnePairJack, handOnePairNine);
        assertEquals(handOnePairJack, winner);
    }

    @Test
    public void testTwoPairComparison() {
        Hand winner = brainz.compareTwoHands(handTwoPairKingQueen, handTwoPairKingFour);
        assertEquals(handTwoPairKingQueen, winner);
    }

    @Test
    public void testThreeOfAKindComparison() {
        Hand winner = brainz.compareTwoHands(handThreeOfAKindQueen, handThreeOfAKindFour);
        assertEquals(handThreeOfAKindQueen, winner);
    }

    //expect this to work fine with default - highcard - comparison
    @Test
    public void testStraightComparison() {
        Hand winner = brainz.compareTwoHands(handStraightSix, handStraightTen);
        assertEquals(handStraightTen, winner);
    }

    //expect this to work fine with default - highcard - comparison
    @Test
    public void testFlushComparison() {
        Hand winner = brainz.compareTwoHands(handFlushAce, handFlushNine);
        assertEquals(handFlushAce, winner);
    }

    @Test
    public void testFullHouseComparison() {
        Hand winner = brainz.compareTwoHands(handFullHouseAceTwo, handFullHouseAceThree);
        assertEquals(handFullHouseAceThree, winner);
    }

    @Test
    public void testFourOfAKindComparison() {
        Hand winner = brainz.compareTwoHands(handFourOfAKindFour, handFourOfAKindQueen);
        assertEquals(handFourOfAKindQueen, winner);
    }

    //expect this to work fine with default - highcard - comparison
    @Test
    public void testStraightFlushComparison() {
        Hand winner = brainz.compareTwoHands(handStraightFlushJack, handStraightFlushNine);
        assertEquals(handStraightFlushJack, winner);
    }

    //any two Royal Flushes are a tie
    @Test
    public void testRoyalFlushComparison() {
        Hand winner = brainz.compareTwoHands(handRoyalFlushClubs, handRoyalFlushHearts);
        assertEquals(null, winner);
    }

    @Test
    public void testWeirdBug(){
        String line = "AD QH TH 9D 8H TS 6D 3S AS AC";
        Hand[] parsed = HandBuilder.parseEulerLine(line);
    }

    @Test
    public void testPairTieJudgedCorrectly(){
        Hand winner = Brainz.compareTwoHands(tieHandPairTwoHighCardAceToEight, tieHandPairTwoHighCardAceToSeven);
        assertEquals(tieHandPairTwoHighCardAceToEight, winner);
    }

    @Test
    public void testTwoPairTieJudgedCorrectly(){
        Hand winner = Brainz.compareTwoHands(tieHandTwoPairTwoHighCardSeven, tieHandTwoPairTwoHighCardEight);
        assertEquals(tieHandTwoPairTwoHighCardEight, winner);
    }

    @Test
    public void testThreeOfAKindTieJudgedCorrectly(){
        Hand winner = Brainz.compareTwoHands(tieHandThreeOfAKindEight, tieHandThreeOfAKindSeven);
        assertEquals(tieHandThreeOfAKindEight, winner);
    }

    @Test
    public void testTrueTieHasNoWinner(){
        Hand winner = Brainz.compareTwoHands(trueTieHandPair, trueTieHandPair2);
        assertEquals(null, winner);
    }

}