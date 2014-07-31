package poker.model;

import java.util.*;

public class Hand {

    TreeSet<Card> cards = new TreeSet<>();

    public Hand (){}

    public Hand (List<Card> cards){
        try {
            this.cards.addAll(cards);
        } catch (IllegalArgumentException e){
            System.out.println("could not add all cards to the set of cards in this hand");
            e.printStackTrace();
        }
    }

    public HashMap<Rank, Integer> countedRanks(){
        HashMap<Rank, Integer> ranksWithCounts = new HashMap<>();
        for (Card card : cards){
            Rank rank = card.getRank();
            if (ranksWithCounts.containsKey(rank)){
                Integer count = ranksWithCounts.get(rank);
                count++;
                ranksWithCounts.put(rank, count);
            } else {
                ranksWithCounts.put(rank, 1);
            }
        }
        return ranksWithCounts;
    }

    public TreeSet<Rank> ranksByCount(Integer count){
        TreeSet<Rank> ranks =  new TreeSet<Rank>();
        countedRanks().entrySet().stream()
                .filter(e -> e.getValue().equals(count))
                .forEach(e -> ranks.add(e.getKey()));
        return ranks;
    }

    public TreeSet<Rank> ranks(){
        TreeSet<Rank> ranks = new TreeSet<>();
        ranks.addAll(countedRanks().keySet());
        return ranks;
    }

    public boolean isOfAKind(int n){
        return !ranksByCount(n).isEmpty();
    }

    public boolean isAllOneSuit(){
        Set<Suit> suits = new HashSet<Suit>();
        cards.stream().forEach(c -> suits.add(c.getSuit()));
        return suits.size() == 1;
    }

    public boolean isAStraight(){
        int previousCard = cards.first().getRank().position() - 1;
        for (Card card : cards){
            int currentCard = card.getRank().position();
            if (currentCard - previousCard != 1){
                return false;
            }
            previousCard = currentCard;
        }
        return true;
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public Card getHighestCard(){
        return cards.last();
    }

    public TreeSet<Card> getCards() {
        return cards;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hand hand = (Hand) o;

        if (!cards.equals(hand.cards)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return cards.hashCode();
    }
}
