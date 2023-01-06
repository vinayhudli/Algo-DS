package com.vinay.leetcode.binary.tree;

import java.util.*;

public class CloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private Map<Node, Node> oldToNewMap = new HashMap<>();
    private Map<Node, Integer> nodeToStatus = new HashMap<>();
    public Node cloneGraph(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()){
            Node remove = queue.remove();
            oldToNewMap.computeIfAbsent(remove, val->new Node(remove.val));
            Node clone = oldToNewMap.get(remove);
            nodeToStatus.put(clone, 1);
            if (clone.neighbors.isEmpty()) {
                List<Node> clones = getClones(remove.neighbors);
                clone.neighbors.addAll(clones);
            }

            for (Node neighbour:remove.neighbors){
                if (!oldToNewMap.containsKey(neighbour) || nodeToStatus.get(oldToNewMap.get(neighbour)) == 0)
                    queue.add(neighbour);
            }
        }
        return oldToNewMap.get(node);
    }

    private List<Node> getClones(List<Node> nodes){
        List<Node> adjNodes = new ArrayList<>();
        for (Node n:nodes){
            oldToNewMap.computeIfAbsent(n, val->new Node(n.val)) ;
            Node node = oldToNewMap.get(n);
            nodeToStatus.putIfAbsent(node, 0);
            adjNodes.add(node) ;
        }
        return adjNodes;
    }

//    dfs to go through all the available nodes
    private Node clone(Node node){
        if (oldToNewMap.containsKey(node))
            return oldToNewMap.get(node);

        Node cloneNode = new Node(node.val);
        oldToNewMap.put(node, cloneNode);
        for (Node neighbor: node.neighbors){
            Node neighborClone = clone(neighbor);
            cloneNode.neighbors.add(neighborClone);
        }
        return oldToNewMap.get(node);
    }


}
