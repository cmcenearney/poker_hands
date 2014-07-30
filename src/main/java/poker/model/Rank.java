package poker.model;

/*
Ranks are hierarchical,
hierarchy defined  either by their position in the class declaration
or by including a value
- which is better?
 */
public enum Rank {

    TWO("Two", "2", 0),
    THREE("Three", "3", 1),
    FOUR("Four", "4", 2),
    FIVE("Five", "5", 3),
    SIX("Six", "6", 4),
    SEVEN("Seven", "7", 5),
    EIGHT("Eight", "8", 6),
    NINE("Nine", "9", 7),
    TEN("Ten", "T", 8),
    JACK("Jack", "J", 9),
    QUEEN("Queen", "Q", 10),
    KING("King", "K", 11),
    ACE("Ace", "A", 12);

    private String label;
    private String abbrev;

    Rank(String label, String abbrev, Integer value) {
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
