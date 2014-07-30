package poker.model;

import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.Assert.*;

public class DeckTest {

    Predicate<Card> spades = c -> c.getSuit() == Suit.SPADES;

    @Test
    public void testDeckHas52Cards(){
        assertEquals("Deck should have 52 cards",
                52, Deck.standardDeck.size());
    }

    @Test
    public void testEachSuitHas13Cards(){
        for(Suit suit : Suit.values()){
            long count = Deck.standardDeck.stream()
                    .filter(c -> c.getSuit() == suit)
                    .count();
            assertEquals("count of '" + suit.getLabel() + "' expected to be 13", 13, count);
        }
    }

    @Test
    public void testEachRankHas4Cards(){
        for(Rank rank : Rank.values()){
            long count = Deck.standardDeck.stream()
                    .filter(c -> c.getRank() == rank)
                    .count();
            assertEquals("count of '" + rank.getLabel() + "' expected to be 4", 4, count);
        }
    }

}