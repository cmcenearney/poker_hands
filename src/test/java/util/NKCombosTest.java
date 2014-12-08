package util;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class NKCombosTest {

    @Test
    public void testICTree() {
        NKCombos t = new NKCombos(4);
        //System.out.println(t.countNodes());
        assert (t.countNodes() == 16);
    }

    @Test
    public void testDepthLimitedSearch() {
        NKCombos t = new NKCombos(5);
        ArrayList<NKCombos.ICTree> search = t.dls(t.tree, 3, new ArrayList<>());
        //System.out.println(search.size());
        assert (search.size() == 10);
    }

    @Test
    public void testGetKCombinationsIndices() {
        NKCombos t = new NKCombos<>(5);
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

    @Test
    public void testGetKCombinationsItems() {
        NKCombos<Integer> t = new NKCombos<Integer>(5);
        List<Integer> testItems = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        Set<List<Integer>> combos = t.getKCombinations(testItems,3);
        Set<ArrayList<Integer>> expected = new HashSet<>(Arrays.asList(
                new ArrayList<Integer>(Arrays.asList(0, 1, 2)),
                new ArrayList<Integer>(Arrays.asList(0, 1, 3)),
                new ArrayList<Integer>(Arrays.asList(0, 1, 4)),
                new ArrayList<Integer>(Arrays.asList(0, 2, 3)),
                new ArrayList<Integer>(Arrays.asList(0, 2, 4)),
                new ArrayList<Integer>(Arrays.asList(0, 3, 4)),
                new ArrayList<Integer>(Arrays.asList(1, 2, 3)),
                new ArrayList<Integer>(Arrays.asList(1, 2, 4)),
                new ArrayList<Integer>(Arrays.asList(1, 3, 4)),
                new ArrayList<Integer>(Arrays.asList(2, 3, 4))
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