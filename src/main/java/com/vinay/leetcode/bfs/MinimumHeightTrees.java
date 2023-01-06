package com.vinay.leetcode.bfs;

import java.util.*;

/**
 * We can solve this problem by first thinking about the 1-D solution, that is if the longest graph is given, then the node which will minimize the height
 * will be mid node if total node count is odd or mid-two-node if total node count is even. This solution can be reached by the following approach – Start
 * two pointers from both ends of the path and move one step each time until pointers meet or one step away, at the end pointers will be at those nodes
 * which will minimize the height because we have divided the nodes evenly so the height will be minimum.
 * The same approach can be applied to a general tree also. Start pointers from all leaf nodes and move one step inside each time, keep combining pointers which
 * overlap while moving, at the end only one pointer will remain on some vertex or two pointers will remain at one distance away. Those nodes represent the root
 * of the vertex which will minimize the height of the tree.
 * So we can have only one root or at max two roots for minimum height depending on tree structure as explained above. For the implementation we will not use actual
 * pointers instead we’ll follow BFS like approach, In starting all leaf node are pushed into the queue, then they are removed from the tree, next new leaf node is
 * pushed in the queue, this procedure keeps on going until we have only 1 or 2 node in our tree, which represent the result.
 */
public class MinimumHeightTrees {

    public static void main(String[] args) {
        MinimumHeightTrees minimumHeightTrees = new MinimumHeightTrees();
        List<Integer> minHeightTrees = minimumHeightTrees.findMinHeightTrees(7, new int[][]{
                {0,1},{1,2},{1,3},{2,4},{3,5},{4,6}});
        for (Integer h:minHeightTrees){
            System.out.println(h);
        }

    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1)
            return Arrays.asList(0);
        List<Set<Integer>> nodes = new ArrayList<>(n);
        for (int i=0;i<n;i++)
            nodes.add(new HashSet<>());

        for (int[] edge:edges){
            nodes.get(edge[0]).add(edge[1]);
            nodes.get(edge[1]).add(edge[0]);
        }

        List<Integer> queue = new ArrayList<>();
        for (int i=0;i< nodes.size();i++){
            if (nodes.get(i).size() == 1)
                queue.add(i);
        }

        int num = n ;
        while (num>2){
            Set<Integer> parent = new HashSet<>();
            for (Integer entry:queue){
                Integer next = nodes.get(entry).iterator().next();
                nodes.get(next).remove(entry);
                if (nodes.get(next).size() == 1)
                    parent.add(next);
            }
            num -= queue.size();
            queue.clear();
//            System.out.println(num);
//            if (num >= 0)
            queue.addAll(parent);
        }
//        System.out.println(num);


        return queue;
    }

    public List<Integer> findMinHeightTreesFirstApproach(int n, int[][] edges) {
        rootHeights = new Integer[n];
        constructTree(edges, 0, new ArrayList[n], new Integer[n]);
//        System.out.println("mht "+minHeight);
        for (int i=0;i<rootHeights.length;i++){
//            System.out.println("root height "+rootHeights[i]);
            if (rootHeights[i] != null && rootHeights[i] == minHeight)
                mhtRoot.add(i);
        }
        return mhtRoot;
    }

    int minHeight = Integer.MAX_VALUE;
    List<Integer> mhtRoot = new ArrayList<>();
    Integer[] rootHeights ;
    private void constructTree(int[][] edges, int index, List<Integer>[] tree, Integer[] nodeParent){
        if (index == edges.length){
            Integer root = findRoot(nodeParent);
            Integer height = findHeight(root, tree);
//            System.out.println("root "+root+" height "+height);
            if (height > -1 && (rootHeights[root] == null || rootHeights[root]>height)) {
                rootHeights[root] = height;
            }
            return;
        }

        int node1 = edges[index][0];
        int node2 = edges[index][1];
//        System.out.println(tree.size());
        List<Integer> list = tree[node1];
        if (list == null){
            list = new ArrayList<>();
            tree[node1] = list;
        }
        list.add(node2);
        nodeParent[node2] = node1;
        constructTree(edges, index+1, tree, nodeParent);
        list.remove(list.size()-1);
        nodeParent[node2] = null;

        list = tree[node2];
        if (list == null){
            list = new ArrayList<>();
            tree[node2] = list;
        }
        list.add(node1);
        nodeParent[node1] = node2;
        constructTree(edges, index+1, tree, nodeParent);
        list.remove(list.size()-1);
        nodeParent[node1] = null;
    }

    private Integer findRoot(Integer[] nodeParent){
        Integer root = 0;
        while (nodeParent[root] != null){
            root = nodeParent[root];
        }
        return root;
    }

    private Integer findHeight(Integer root, List<Integer>[] tree){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(root);
        List<Integer> child = new ArrayList<>();
        int height = 0;
        int numberOfNodes = 0;
        while (!queue.isEmpty() ){
            Integer poll = queue.poll();
            numberOfNodes++;
            if (tree[poll] != null)
                child.addAll(tree[poll]);
            if (queue.isEmpty() && !child.isEmpty()) {
                queue.addAll(child);
                child.clear();
                height++;
                if (height > minHeight)
                    break;
            }
        }
        if (height<= minHeight && numberOfNodes < tree.length)
            return -1;

        if (queue.isEmpty() && child.isEmpty())
            minHeight = Math.min(height, minHeight);
        return height;
    }
}
