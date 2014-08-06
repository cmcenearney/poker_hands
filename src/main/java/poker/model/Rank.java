package poker.model;

/*
Ranks are hierarchical,
hierarchy defined  either by their position in the class declaration
or by including a value
- which is better?
 */
public enum Rank {

    TWO("Two", "2"),
    THREE("Three", "3"),
    FOUR("Four", "4"),
    FIVE("Five", "5"),
    SIX("Six", "6"),
    SEVEN("Seven", "7"),
    EIGHT("Eight", "8"),
    NINE("Nine", "9"),
    TEN("Ten", "T"),
    JACK("Jack", "J"),
    QUEEN("Queen", "Q"),
    KING("King", "K"),
    ACE("Ace", "A");

    private String label;
    private String abbrev;

    Rank(String label, String abbrev) {
        this.label = label;
        this.abbrev = abbrev;
    }

    public String getLabel() {
        return this.label;
    }

    public String getAbbrev() {
        return this.abbrev;
    }

    public Integer position() {
        return this.ordinal();
    }

    public static Rank getByAbbrev(String abbrev) {
        for (Rank rank : Rank.values()) {
            if (rank.getAbbrev().equals(abbrev))
                return rank;
        }
        throw new IllegalArgumentException("Invalid abbreviation for Rank: " + abbrev);
    }

}
