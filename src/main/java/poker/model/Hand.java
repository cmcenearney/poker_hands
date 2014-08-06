package poker.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Hand {

    TreeSet<Card> cards = new TreeSet<>();
    HashMap<Integer, Set<Rank>> ranksByCountHash = new HashMap<>();

    public Hand (){}

    public Hand (List<Card> cards){
        try {
            this.cards.addAll(cards);
        } catch (IllegalArgumentException e){
            System.out.println("could not add all cards to the set of cards in this hand");
            e.printStackTrace();
        }
        initRanksByCountHash();
    }

    public void initRanksByCountHash(){
        IntStream.rangeClosed(1, 4)
                .forEach(i -> ranksByCountHash.put(i, ranksByCount(i)));
    }

    public HashMap<Integer, Set<Rank>> getRanksByCountHash() {
        return ranksByCountHash;
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
        return new TreeSet<>(
            countedRanks().entrySet().stream()
                .filter(e -> e.getValue().equals(count))
                .map(e -> e.getKey())
                .collect(Collectors.toSet())
        );
    }

    public Integer totalCardsInRanksByCount(){
        Integer total = ranksByCountHash.entrySet().stream()
                .map(e -> e.getValue().size())
                .reduce(0, (a,b) -> a + b);
        return total;
    }

    public TreeSet<Rank> ranks(){
        return new TreeSet<>(
            countedRanks().keySet()
        );
    }

    public boolean isOfAKind(int n){
        return !ranksByCount(n).isEmpty();
    }

    public boolean isAllOneSuit(){
        return (cards.stream()
                .map(c -> c.getSuit())
                .distinct()
                .count()
                == 1);
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
        if(totalCardsInRanksByCount() != cards.size()){
            initRanksByCountHash();
        }
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

    @Override
    public String toString() {
        return "Hand{" +
                "cards=" + cards +
                '}';
    }
}
