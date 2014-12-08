package util;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;


public class NKCombos<T> {

    Integer n;
    ICTree tree;

    public class ICTree {
        Integer value;
        HashMap<Integer, ICTree> children;
        ICTree parent;
        ICTree (Integer value, ICTree parent){
            this.value = value;
            this.parent = parent;
            this.children = new HashMap<>();
        }
    }

    public NKCombos(Integer n){
        this.n = n;
        tree = new ICTree(null, null);
        initTree();
    }

    public HashSet<HashSet<Integer>> getKCombinations(int k){
        HashSet<HashSet<Integer>> combos = new HashSet<HashSet<Integer>>();
        for (ICTree t : dls(tree, k, new ArrayList<>())){
            combos.add(getValues(t));
        }
        return combos;
    }

    public Set<List<T>> getKCombinations(List<T> list, int k){
        return getKCombinations(k).stream()
                .map(set -> set.stream()
                    .map(i -> list.get(i))
                    .collect(Collectors.toList()))
                .collect(Collectors.toSet());
    }

    private void initTree(){
        for (int i = 0; i < n; i++) {
            ICTree newNode = new ICTree(i, tree);
            tree.children.put(i, newNode);
            constructTree(newNode);
        }
    }

    private void constructTree(ICTree node){
        if (node.value == 0)
            return;
        for (int i = 0; i < node.value; i++){
            if (!node.children.containsKey(i)){
                ICTree newChild = new ICTree(i, node);
                node.children.put(i, newChild);
                constructTree(newChild);
            }
        }
    }

    void dfs(ICTree node, Consumer<ICTree> f){
        Set<ICTree> visited = new HashSet<>();
        for (Integer i : node.children.keySet()) {
            node = node.children.get(i);
            if (!visited.contains(node)) {
                f.accept(node);
                dfs(node, f);
            }
        }
    }

    List<ICTree> breadthFirstTraversal(ICTree node){
        List<ICTree> results = new LinkedList<ICTree>();
        Queue<ICTree> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            ICTree n = queue.remove();
            n.children.values().stream().forEach(i -> queue.add(i));
            results.add(n);
        }
        return results;
    }

    public Integer countNodes() {
        return breadthFirstTraversal(tree).size();
    }

    ArrayList<ICTree> dls(ICTree node, int limit, ArrayList<ICTree> acc){
        Set<ICTree> visited = new HashSet<>();
        if (limit == 0) {
            acc.add(node);

        } else {
            for (Integer i : node.children.keySet()) {
                if (!visited.contains(node.children.get(i))) {
                    dls(node.children.get(i), limit - 1, acc);
                }
            }
        }
        return acc;
    }

    HashSet<Integer> getValues(ICTree node){
        HashSet<Integer> values = new HashSet<Integer>();
        while (node.value != null){
            values.add(node.value);
            node = node.parent;
        }
        return values;
    }



}
