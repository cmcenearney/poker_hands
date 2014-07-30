package poker.game;

import org.junit.Before;
import org.junit.Test;
import poker.PokerTest;
import poker.model.Hand;
import poker.model.PokerHand;
import poker.utils.HandBuilder;

import static org.junit.Assert.*;
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
    public void testTwoPairComparison() {
        Hand winner = brainz.compareTwoHands(handTwoPairKingQueen, handTwoPairKingFour);
        assertEquals(handTwoPairKingQueen, winner);
    }

    @Test
    public void testFullHouseComparison() {
        Hand winner = brainz.compareTwoHands(handFullHouseAceTwo, handFullHouseAceThree);
        assertEquals(handFullHouseAceThree, winner);
    }

}