package util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class IndexCombinationsTest {

    @Test
    public void testICTree() {
        IndexCombinations t = new IndexCombinations(4);
        //System.out.println(t.countNodes());
        assert (t.countNodes() == 16);
    }

    @Test
    public void testDepthLimitedSearch() {
        IndexCombinations t = new IndexCombinations(5);
        ArrayList<IndexCombinations.ICTree> search = t.dls(t.tree, 3, new ArrayList<>());
        //System.out.println(search.size());
        assert (search.size() == 10);
    }

    @Test
    public void testGetKCombinations() {
        IndexCombinations t = new IndexCombinations(5);
        HashSet<HashSet<Integer>> combos = t.getKCombinations(3);
        HashSet<HashSet<Integer>> expected = new HashSet<>(Arrays.asList(
                new HashSet<Integer>(Arrays.asList(0, 1, 2)),
                new HashSet<Integer>(Arrays.asList(0, 1, 3)),
                new HashSet<Integer>(Arrays.asList(0, 1, 4)),
                new HashSet<Integer>(Arrays.asList(0, 2, 3)),
                new HashSet<Integer>(Arrays.asList(0, 2, 4)),
                new HashSet<Integer>(Arrays.asList(0, 3, 4)),
                new HashSet<Integer>(Arrays.asList(1, 2, 3)),
                new HashSet<Integer>(Arrays.asList(1, 2, 4)),
                new HashSet<Integer>(Arrays.asList(1, 3, 4)),
                new HashSet<Integer>(Arrays.asList(2, 3, 4))
        ));
        assertEquals(expected, combos);
    }

// todo - make this performant (72 eg is a dealbreaker)
//    @Test
//    public void testLargerNumber(){
//        IndexCombinations t = new IndexCombinations(72);
//        HashSet<HashSet<Integer>> combos = t.getKCombinations(3);
//        System.out.println(combos.size());
//    }


}