package poker.model;

import org.junit.Before;
import org.junit.Test;
import poker.Euler;

import java.util.*;

import static org.junit.Assert.*;

public class HandTest {

    Hand handSimplePair = Euler.parseEulerFormat("2H 2D 4C 5D 7S");
    Hand handSimpleTwoPair = Euler.parseEulerFormat("2H 2D 4C 4D 8S");
    Hand handSimpleThreeOfAKind = Euler.parseEulerFormat("2H 2D 4C 4D 4S");
    Hand handSimpleStraight = Euler.parseEulerFormat("2H 3D 4C 5D 6S");
    Hand handSimpleFlush = Euler.parseEulerFormat("2H KH 8H 4H JH");
    Hand handSimpleFullHouse = Euler.parseEulerFormat("2H 2D 4C 4D 4S");
    Hand handSimpleFourOfAKind = Euler.parseEulerFormat("2H 6H 6C 6D 6S");
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
        Hand hand = Euler.parseEulerFormat(euler);
        assertEquals(hand.getCards(), handSimpleThreeOfAKindAddOneAtATime.getCards());
    }

//    @Test
//    public void testCountedRanks(){
//        HashMap<Rank, Integer> countedRanks = handSimpleThreeOfAKind.countedRanks();
//        assert(2 == countedRanks.get(Rank.TWO));
//        assert(3 == countedRanks.get(Rank.FOUR));
//        assertNull(countedRanks.get(Rank.ACE));
//        assertNull(countedRanks.get(Rank.JACK));
//    }

    @Test
    public void testRanksByCountSimplePair(){
        Set<Rank> expected = EnumSet.of(Rank.TWO);
        assertEquals(expected, handSimplePair.getRanksByCount(2));
    }

    @Test
    public void testRanksByCountTwoPair(){
        Set<Rank> expected = EnumSet.of(Rank.TWO, Rank.FOUR);
        assertEquals(expected, handSimpleTwoPair.getRanksByCount(2));
    }

    @Test
    public void testRanksByCountThreeOfAKind(){
        Set<Rank> expected = EnumSet.of(Rank.FOUR);
        assertEquals(expected, handSimpleThreeOfAKind.getRanksByCount(3));
    }

    @Test
    public void testRanksByCountFourOfAKind(){
        Set<Rank> expected = EnumSet.of(Rank.SIX);
        assertEquals(expected, handSimpleFourOfAKind.getRanksByCount(4));
    }

    @Test
    public void testInitRanksByCount(){
        //full house
        assertEquals(0,handSimpleFullHouse.ranksByCountHash.get(1).size());
        assertEquals(1,handSimpleFullHouse.ranksByCountHash.get(2).size());
        assertEquals(1,handSimpleFullHouse.ranksByCountHash.get(3).size());
        assertEquals(0,handSimpleFullHouse.ranksByCountHash.get(4).size());
        //straight
        assertEquals(5,handSimpleStraight.ranksByCountHash.get(1).size());
        assertEquals(0,handSimpleStraight.ranksByCountHash.get(2).size());
        assertEquals(0,handSimpleStraight.ranksByCountHash.get(3).size());
        assertEquals(0,handSimpleStraight.ranksByCountHash.get(4).size());
        //flush
        assertEquals(5,handSimpleFlush.ranksByCountHash.get(1).size());
        assertEquals(0,handSimpleFlush.ranksByCountHash.get(2).size());
        assertEquals(0,handSimpleFlush.ranksByCountHash.get(3).size());
        assertEquals(0,handSimpleFlush.ranksByCountHash.get(4).size());
        //two pair
        assertEquals(1,handSimpleTwoPair.ranksByCountHash.get(1).size());
        assertEquals(2,handSimpleTwoPair.ranksByCountHash.get(2).size());
        assertEquals(0,handSimpleTwoPair.ranksByCountHash.get(3).size());
        assertEquals(0,handSimpleTwoPair.ranksByCountHash.get(4).size());
    }

    @Test
    public void testInitRanksByCountWithIncrementalCardAdditions(){
        Hand h = new Hand();
        assertNull(h.ranksByCountHash.get(1));
        h.addCard(new Card("2D"));
        h.addCard(new Card("4S"));
        h.addCard(new Card("4C"));
        assertEquals(1,h.ranksByCountHash.get(1).size());
        assertEquals(1,h.ranksByCountHash.get(2).size());
        h.addCard(new Card("4D"));
        assertEquals(0,h.ranksByCountHash.get(2).size());
        assertEquals(1,h.ranksByCountHash.get(3).size());
        h.addCard(new Card("AD"));
        assertEquals(2,h.ranksByCountHash.get(1).size());
    }
}