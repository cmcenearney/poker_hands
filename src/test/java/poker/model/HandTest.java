package poker.model;

import org.junit.Before;
import org.junit.Test;
import poker.PokerTest;
import poker.utils.HandBuilder;

import java.util.*;

import static org.junit.Assert.*;

public class HandTest extends PokerTest{

    Hand handSimpleThreeOfAKindAddOneAtATime;

    @Before
    public void setup(){
        handSimpleThreeOfAKindAddOneAtATime = new Hand();
        handSimpleThreeOfAKindAddOneAtATime.addCard(new Card("2D"));
        handSimpleThreeOfAKindAddOneAtATime.addCard(new Card("4S"));
        handSimpleThreeOfAKindAddOneAtATime.addCard(new Card("4C"));
        handSimpleThreeOfAKindAddOneAtATime.addCard(new Card("4D"));
        handSimpleThreeOfAKindAddOneAtATime.addCard(new Card("2H"));
    }

    @Test
    public void testOrderingOfCards(){
        TreeSet<Card> cards = handSimpleThreeOfAKindAddOneAtATime.getCards();
        assertEquals(Rank.FOUR, cards.last().getRank());
        assertEquals(Rank.TWO, cards.first().getRank());
        assertEquals(5, cards.size());
    }

    @Test
    public void testHandCardsSetEquality(){
        String euler = "2H 2D 4C 4D 4S";
        Hand hand = HandBuilder.parseEulerFormat(euler);
        assertEquals(hand.getCards(), handSimpleThreeOfAKindAddOneAtATime.getCards());
    }

    @Test
    public void testCountedRanks(){
        HashMap<Rank, Integer> countedRanks = handSimpleThreeOfAKind.countedRanks();
        assert(2 == countedRanks.get(Rank.TWO));
        assert(3 == countedRanks.get(Rank.FOUR));
        assertNull(countedRanks.get(Rank.ACE));
        assertNull(countedRanks.get(Rank.JACK));
    }

    @Test
    public void testRanksByCountSimplePair(){
        Set<Rank> expected = EnumSet.of(Rank.TWO);
        assertEquals(expected, handSimplePair.ranksByCount(2));
    }

    @Test
    public void testRanksByCountTwoPair(){
        Set<Rank> expected = EnumSet.of(Rank.TWO, Rank.FOUR);
        assertEquals(expected, handSimpleTwoPair.ranksByCount(2));
    }

    @Test
    public void testRanksByCountThreeOfAKind(){
        Set<Rank> expected = EnumSet.of(Rank.FOUR);
        assertEquals(expected, handSimpleThreeOfAKind.ranksByCount(3));
    }

    @Test
    public void testRanksByCountFourOfAKind(){
        Set<Rank> expected = EnumSet.of(Rank.SIX);
        assertEquals(expected, handSimpleFourOfAKind.ranksByCount(4));
    }

}