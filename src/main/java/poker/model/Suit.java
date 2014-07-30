package poker.model;
/*
Suits are not hierarchical
 */
public enum Suit {

    SPADES("Spades", "S"),
    HEARTS("Hearts", "H"),
    DIAMONDS("Diamonds", "D"),
    CLUBS("Clubs", "C");

    private String label;

    private String abbrev;

    Suit(String label, String abbrev) {
        this.label = label;
        this.abbrev = abbrev;
    }

    public String getLabel() {
        return this.label;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public static Suit getByAbbrev(String abbrev){
        for(Suit suit : Suit.values()){
            if (suit.getAbbrev().equals(abbrev))
                return suit;
        }
        throw new IllegalArgumentException("Invalid abbreviation for Suit: " + abbrev);
    }

}
