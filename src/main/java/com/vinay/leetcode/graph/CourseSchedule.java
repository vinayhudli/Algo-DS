package com.vinay.leetcode.graph;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        System.out.println(courseSchedule.canFinish(3, new int[][]{{1,0},{1,2},{0,1}}));
    }

    /*
    DFS algorithm for topological search, I did it without browsing or studying topological sort. how great is that!!!!
     */
    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        Set<Integer> independentNode = new HashSet<>();
        Node[] listOfNodes = new Node[numCourses];
        for (int i=0;i< listOfNodes.length;i++){
            listOfNodes[i] = new Node();
            listOfNodes[i].val=i;
            independentNode.add(i);
        }

        for (int[] prerequisite : prerequisites) {
            int child = prerequisite[0];
            int parent = prerequisite[1];
            if (listOfNodes[parent].child == null)
                listOfNodes[parent].child = new ArrayList<>();
            listOfNodes[parent].child.add(child);
            independentNode.remove(child);
        }

        if (independentNode.isEmpty())
            return false;
        Set<Integer> allNodesVisitedAtleastOnce = new HashSet<>();
        boolean isLoop = false;
        for (Integer node:independentNode){
            Set<Integer> visited = new HashSet<>();
            isLoop = isLoop || dfsTraversalToCheckLoop(allNodesVisitedAtleastOnce, visited, listOfNodes[node], listOfNodes);
        }
        return allNodesVisitedAtleastOnce.size()==numCourses && !isLoop ;
    }

    private boolean dfsTraversalToCheckLoop(Set<Integer> allNodesVisitedAtleastOnce, Set<Integer> visited, Node node, Node[] listOfNodes){
        if (visited.contains(node.val))
            return true;
        if (allNodesVisitedAtleastOnce.contains(node.val))
            return false;
        allNodesVisitedAtleastOnce.add(node.val);
        visited.add(node.val);
//        System.out.println("in traversal : "+node.val);
//        boolean isLoop = false;
        if (node.child != null){
            for (Integer child:node.child) {
//                isLoop = isLoop || dfsTraversalToCheckLoop(allNodesVisitedAtleastOnce, visited, listOfNodes[child], listOfNodes );
                boolean b = dfsTraversalToCheckLoop(allNodesVisitedAtleastOnce, visited, listOfNodes[child], listOfNodes);
                if (b)
                    return true;
            }
        }
        visited.remove(node.val);
        return false;
    }

    /*
    Kahn's algorithm for topological sort
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] incomingEdge = new int[numCourses];
        int[][] matrix = new int[numCourses][numCourses];

        for (int i=0;i< prerequisites.length;i++){
            int to = prerequisites[i][0];
            int from = prerequisites[i][1];
            incomingEdge[to]++;
            matrix[from][to] = 1;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i=0;i<numCourses;i++){
            if (incomingEdge[i] == 0)
                queue.add(i);
        }

        int count = 0;
        while (!queue.isEmpty()){
            Integer remove = queue.remove();
            count++;
            for(int j=0;j<matrix[remove].length;j++){
                if (matrix[remove][j] == 1){
                    if (--incomingEdge[j] == 0)
                        queue.add(j);
                }
            }
        }

        return count == numCourses;
    }

    class Node{
        int val;
        List<Integer> child;
    }

}
