package poker;

import poker.model.Hand;
import poker.utils.HandBuilder;

import java.util.Collection;

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

    public Hand handOnePairJack = HandBuilder.parseEulerFormat("2H 7D 4C JD JS");
    public Hand handOnePairNine = HandBuilder.parseEulerFormat("9H 2D 4C 9D AS");

    public Hand handTwoPairKingQueen = HandBuilder.parseEulerFormat("QD QS 3C KS KH");
    public Hand handTwoPairKingFour = HandBuilder.parseEulerFormat("KD KC AH 4D 4S");

    public Hand handThreeOfAKindQueen = HandBuilder.parseEulerFormat("QD QS QC KS 6H");
    public Hand handThreeOfAKindFour = HandBuilder.parseEulerFormat("AD 3C 4H 4D 4S");

    public Hand handStraightTen = HandBuilder.parseEulerFormat("TD 9S 8C 7S 6H");
    public Hand handStraightSix = HandBuilder.parseEulerFormat("2D 3C 4H 5D 6S");

    public Hand handFlushAce = HandBuilder.parseEulerFormat("TD 5D 3D 7D AD");
    public Hand handFlushNine = HandBuilder.parseEulerFormat("2S 3S 9S 5S 6S");

    public Hand handFullHouseAceTwo = HandBuilder.parseEulerFormat("AD AS AC 2S 2H");
    public Hand handFullHouseAceThree = HandBuilder.parseEulerFormat("AD AC AH 3D 3S");

    public Hand handFourOfAKindQueen = HandBuilder.parseEulerFormat("QD QS QC KS QH");
    public Hand handFourOfAKindFour = HandBuilder.parseEulerFormat("AD 4C 4H 4D 4S");

    public Hand handStraightFlushJack = HandBuilder.parseEulerFormat("JD TD 8D 7D 9D");
    public Hand handStraightFlushNine = HandBuilder.parseEulerFormat("5S 6S 7S 8S 9S");

    public Hand handRoyalFlushClubs  = HandBuilder.parseEulerFormat("TC AC JC QC KC");
    public Hand handRoyalFlushHearts = HandBuilder.parseEulerFormat("AH KH QH JH TH");

    public Hand tieHandPairTwoHighCardAceToSeven = HandBuilder.parseEulerFormat("2C 2D AC 9H 7S");
    public Hand tieHandPairTwoHighCardAceToEight = HandBuilder.parseEulerFormat("2S 2H AD 9C 8S");

    public Hand tieHandTwoPairTwoHighCardSeven = HandBuilder.parseEulerFormat("2C 2D AC AH 7S");
    public Hand tieHandTwoPairTwoHighCardEight = HandBuilder.parseEulerFormat("2S 2H AD AS 8S");

    public Hand tieHandThreeOfAKindEight = HandBuilder.parseEulerFormat("2C 2D 2H AH 8S");
    public Hand tieHandThreeOfAKindSeven = HandBuilder.parseEulerFormat("2S 2H 2D AS 7S");

    public Hand trueTieHandPair = HandBuilder.parseEulerFormat("2C 4D 9H 8H 8S");
    public Hand trueTieHandPair2 = HandBuilder.parseEulerFormat("2S 4H 9D 8D 8C");

    public PokerTest(){

    }

}
