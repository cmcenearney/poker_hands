package poker.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class RankTest {

    @Test
    public void testGetAbbrev(){
        assertEquals("2", Rank.TWO.getAbbrev());
    }

    @Test
    public void testGetByAbbrev(){
        Rank t = Rank.getByAbbrev("2");
        assertEquals("2", t.getAbbrev());
        assertEquals("Two", t.getLabel());
    }

    @Test
    public void testOrdinalsAsExpected(){
        assert( Rank.TWO.position() == 0);
        assert( Rank.THREE.position() == 1);
        assert(Rank.KING.position() == 11);
    }

}