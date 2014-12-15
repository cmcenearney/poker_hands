package combinatrix;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class BinomialTreeCombinationsTest {

    @Test
    public void testAllPathsGenerated() {
        BinomialTreeCombinations c = new BinomialTreeCombinations(4);
        Set<List<Integer>> combos = c.getAllPaths();
        HashSet<List<Integer>> expected = new HashSet<List<Integer>>() {{
            add(Arrays.asList(0));
            add(Arrays.asList(1, 0));
            add(Arrays.asList(2, 0));
            add(Arrays.asList(2, 1, 0));
            add(Arrays.asList(3, 0));
            add(Arrays.asList(3, 1, 0));
            add(Arrays.asList(3, 2, 0));
            add(Arrays.asList(3, 2, 1, 0));
        }};
        assertEquals(expected, combos);
    }

    @Test
    public void testK3N5() {
        BinomialTreeCombinations c = new BinomialTreeCombinations(5);
        Set<List<Integer>> combos = c.getKIndices(3);
        Set<List<Integer>> expected = new HashSet<List<Integer>>(){{
            add(Arrays.asList(0, 1, 2));
            add(Arrays.asList(0, 1, 3));
            add(Arrays.asList(0, 1, 4));
            add(Arrays.asList(0, 2, 3));
            add(Arrays.asList(0, 2, 4));
            add(Arrays.asList(0, 3, 4));
            add(Arrays.asList(1, 2, 3));
            add(Arrays.asList(1, 2, 4));
            add(Arrays.asList(1, 3, 4));
            add(Arrays.asList(2, 3, 4));
        }};
        assertEquals(expected, combos);
    }

    //this should have a reasonable running time
    @Test
    public void testK3N72(){
        BinomialTreeCombinations c = new BinomialTreeCombinations(172);
        Set<List<Integer>> combos = c.getKIndices(3);
        assert(833340 == combos.size());
    }

}