package com.vinay.leetcode.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class KClosestPointstoOrigin {

    public static void main(String[] args) {
        KClosestPointstoOrigin kClosestPointstoOrigin = new KClosestPointstoOrigin();
        int[][] ints = kClosestPointstoOrigin.kClosest(new int[][]{{3, 3}, {5, -1}, {-2,4}}, 2);
        for (int i=0;i< ints.length;i++){
            System.out.println(ints[i][0]+", "+ints[i][1]);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        if (k== points.length)
            return points;
        Queue<Points> queue = new PriorityQueue<>((inserted, present)-> present.sumOfSquares- inserted.sumOfSquares);
        for (int i=0;i< points.length;i++){
            int sumOfSquares = (int) (Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            Points pointsObj = new Points(sumOfSquares,  i);
            queue.add(pointsObj);
            if (queue.size() > k)
                queue.remove();
        }

        int[][] result =new int[k][2];
        int i = 0;
        while (!queue.isEmpty()){
            Points remove = queue.remove();
            result[i][0] = points[remove.index][0];
            result[i][1] = points[remove.index][1];
            i++;
        }
        return result;
    }

    class Points{
        int sumOfSquares;
        int index;

        public Points(int sumOfSquares, int index) {
            this.sumOfSquares = sumOfSquares;
            this.index = index;
        }
    }
}
