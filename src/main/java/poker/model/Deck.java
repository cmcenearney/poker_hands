package poker.model;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    static final List<Card> standardDeck = new ArrayList<Card>();

    static {
        for(Rank rank : Rank.values()){
            for(Suit suit : Suit.values())
                standardDeck.add(new Card(rank, suit));
        }
    }

    /*
    Fisher-Yates shuffle algorithm
    http://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#The_modern_algorithm
    */
    static void shuffleDeck(){
        shuffleDeck(standardDeck);
    }

    static void shuffleDeck(List<Card> deck){
        for (int i = deck.size()-1; i > 0; i--){
            int random_index = (int) Math.floor((Math.random()*i)+0);
            Card tmp = deck.get(random_index);
            deck.set(random_index,deck.get(i));
            deck.set(i, tmp);
        }
    }

}
