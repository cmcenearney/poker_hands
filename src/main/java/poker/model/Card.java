package poker.model;

public class Card implements Comparable{

    Rank rank;
    Suit suit;

    public Card (Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }

    public Card (String abbrev){
        String[] chars = abbrev.split("");
        this.rank = Rank.getByAbbrev(chars[0]);
        this.suit = Suit.getByAbbrev(chars[1]);
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public int compareTo(Object o){
        Card otherCard = (Card) o;
        if (rank.position() == otherCard.getRank().position()){
            if (suit.equals(otherCard.getSuit())){
                return 0;
            } else {
                return suit.ordinal() - otherCard.getSuit().ordinal();
            }
        }
        return rank.position() - otherCard.getRank().position();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (rank != card.rank) return false;
        if (suit != card.suit) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rank.hashCode();
        result = 31 * result + suit.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit=" + suit +
                '}';
    }
}
