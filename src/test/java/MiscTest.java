import org.junit.Before;
import org.junit.Test;
import poker.PokerTest;
import poker.model.Card;
import poker.model.Hand;
import poker.model.Rank;

import java.util.*;
import java.util.stream.Collectors;

public class MiscTest extends PokerTest{

    Collection<Hand> hands = new ArrayList<>();

    @Before
    public void setUp(){
        hands.add(handFlushAce);
        hands.add(handFlushNine);
        hands.add(handSimpleHighCard);hands.add(handSimpleFlush);
    }

    @Test
    public void testReduceToAccumulateCollectionOfDifferentType(){
        Set<Rank> ranks = new HashSet<>();
        hands.stream()
                .forEach(h -> h.getCards().stream()
                        .forEach(c -> ranks.add(c.getRank())));
        System.out.println(ranks.size());
    }
}
