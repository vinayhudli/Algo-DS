package com.vinay.leetcode.stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
    int area = 0;

    public static void main(String[] args) {
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        System.out.println(largestRectangleInHistogram.largestRectangleArea(new int[]{2,4}));
    }

    /*
    soln from here: https://leetcode.com/problems/largest-rectangle-in-histogram/solutions/28902/5ms-o-n-java-solution-explained-beats-96/?orderBy=most_votes
     */
    public int largestRectangleArea1(int[] heights) {
        int[] lessInLeft = new int[heights.length];
        int[] lessInRight = new int[heights.length];
        lessInLeft[0] = -1;
        lessInRight[heights.length-1] = heights.length;
        int p;
        for (int i=1, j= heights.length-2;i< heights.length && j>=0;i++, j--){
            p = i-1;
            while (p>=0 && heights[p]>=heights[i])
                p = lessInLeft[p];
            lessInLeft[i] = p;

            p = j+1;
            while (p< heights.length && heights[p]>=heights[j])
                p = lessInRight[p];
            lessInRight[j] = p;
        }
        int ans = 0;
        for (int i=0;i< heights.length;i++){
            ans = Math.max(ans, heights[i]*(lessInRight[i] - lessInLeft[i] -1));
        }
        return ans;
    }

    /*
    from neetcode stack questions in roadmap
     */
    public int largestRectangleArea(int[] heights) {
        int area = 0;
        Stack<Pair> stack = new Stack<>();
        for (int i=0;i< heights.length;i++){
            int index = i;
            while (!stack.isEmpty() && stack.peek().height>heights[i]){
                Pair pop = stack.pop();
                area = Math.max(area, (i- pop.index)* pop.height);
                index = pop.index;
            }
            stack.push(new Pair(index, heights[i]));
        }
        while (!stack.isEmpty()){
            Pair pop = stack.pop();
            area = Math.max(area, (heights.length- pop.index)* pop.height);
        }
        return area;
    }

    class Pair{
        int index;
        int height;

        public Pair(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

}
