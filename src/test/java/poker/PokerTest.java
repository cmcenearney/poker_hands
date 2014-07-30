package poker;

import poker.model.Hand;
import poker.utils.HandBuilder;

public class PokerTest {

    public Hand handSimpleHighCard = HandBuilder.parseEulerFormat("2H 5D 7C 9D AS");
    public Hand handSimplePair = HandBuilder.parseEulerFormat("2H 2D 4C 5D 7S");
    public Hand handSimpleTwoPair = HandBuilder.parseEulerFormat("2H 2D 4C 4D 8S");
    public Hand handSimpleThreeOfAKind = HandBuilder.parseEulerFormat("2H 2D 4C 4D 4S");
    public Hand handSimpleStraight = HandBuilder.parseEulerFormat("2H 3D 4C 5D 6S");
    public Hand handSimpleFlush = HandBuilder.parseEulerFormat("2H KH 8H 4H JH");
    public Hand handSimpleFullHouse = HandBuilder.parseEulerFormat("2H 2D 4C 4D 4S");
    public Hand handSimpleFourOfAKind = HandBuilder.parseEulerFormat("2H 6H 6C 6D 6S");
    public Hand handSimpleStraightFlush = HandBuilder.parseEulerFormat("7C 8C 4C 5C 6C");
    public Hand handSimpleRoyalFlush = HandBuilder.parseEulerFormat("AD JD QD KD TD");

    public Hand handTwoPairKingQueen = HandBuilder.parseEulerFormat("QD QS 3C KS KH");
    public Hand handTwoPairKingFour = HandBuilder.parseEulerFormat("KD KC AH 4D 4S");

    public Hand handFullHouseAceTwo = HandBuilder.parseEulerFormat("AD AS AC 2S 2H");
    public Hand handFullHouseAceThree = HandBuilder.parseEulerFormat("AD AC AH 3D 3S");

    public PokerTest(){}

}
