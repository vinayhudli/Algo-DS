package com.vinay.leetcode.arrays;

import java.util.Arrays;

public class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] merge = mergeIntervals.merge(new int[][]{{1, 4}, {4, 5}});
        for (int i=0;i< merge.length;i++)
            System.out.println(merge[i][0]+"--"+merge[i][1]);
    }
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1 )
            return intervals;
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        int[][] result = new int[intervals.length][2];
        int index = 0;
        result[0][0] = intervals[0][0];
        result[0][1] = intervals[0][1];
        for (int i=1;i<intervals.length;i++){
            if (intervals[i][0] >= result[index][0] && intervals[i][0] <= result[index][1]){
                result[index][1] = Math.max(result[index][1], intervals[i][1]);
            }else {
                index++;
                result[index][0] = intervals[i][0] ;
                result[index][1] = intervals[i][1];
            }
        }
        return Arrays.copyOfRange(result, 0, index+1);
    }
}
