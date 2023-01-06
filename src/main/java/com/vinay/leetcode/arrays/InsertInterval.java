package com.vinay.leetcode.arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {


    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        int[][] insert = insertInterval.insert(new int[][]{{1,2},{6,7},{8,10},{12,16}}, new int[]{17, 18});
        for (int i=0;i<insert.length;i++){
            System.out.println(insert[i][0]+"--"+insert[i][1]);
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0){
            List<int[]> result = new ArrayList<>();
            result.add(newInterval);
            return result.toArray(new int[1][]);
        }

        int i=0;
        List<int[]> result = new ArrayList<>();
        while (i<intervals.length && intervals[i][1]<newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        return null;
    }
    public int[][] insert1(int[][] intervals, int[] newInterval) {
        if(intervals.length==0){
            LinkedList<int[]> result = new LinkedList<>();
            result.add(newInterval);
            return result.toArray(new int[1][]);
        }
        int index = findPos(intervals, newInterval[0]);
        int lowerIndex = -1;
        if (index-1>=0){
            if (intervals[index-1][1] >= newInterval[0])
                lowerIndex = index-1;
        }
        int highIndex = -1;
        int temp = index;
        while (temp < intervals.length){
            if (newInterval[1] >= intervals[temp][0]) {
                highIndex = temp;
                temp++;
            }else
                break;
        }

        LinkedList<int[]> result = new LinkedList<>();
//        System.out.println(lowerIndex+"--"+highIndex+"--"+index);
        int i=0;
        int count = 0;
        while (i< intervals.length){
            int[] entry = new int[2];
            if (i==lowerIndex && i<highIndex){
                entry[0] = Math.min(intervals[lowerIndex][0], newInterval[0]) ;
                entry[1] = Math.max(intervals[highIndex][1], newInterval[1]);
                i = highIndex;
            }else if(i == lowerIndex && i<index){
                entry[0] = Math.min(intervals[lowerIndex][0], newInterval[0]) ;
                entry[1] = Math.max(intervals[lowerIndex][1], newInterval[1]);
                i = index-1;
            }else if(i== index && i <= highIndex){
                entry[0] = newInterval[0];
                entry[1] = Math.max(newInterval[1], intervals[highIndex][1]);
                i=highIndex;
            }else{
                entry[0] = intervals[i][0];
                entry[1] = intervals[i][1];
            }
            result.add(entry);
            count++;
            i++;
        }
        if (index == intervals.length && lowerIndex==-1) {
            result.add(newInterval);
            count++;
        }else if (lowerIndex == -1 && highIndex == -1) {
            result.add(index, newInterval);
            count++;
        }
        int[][] arrResult = new int[count][2];
        int j = 0;
        for (int[] ints:result){
            arrResult[j][0] = ints[0];
            arrResult[j][1] = ints[1];
            j++;
        }
        return arrResult;
    }

    private int findPos(int[][] intervals, int newStart){
        int low = 0;
        int high = intervals.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if (intervals[mid][0] == newStart)
                return mid;
            else if (intervals[mid][0] > newStart){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return high+1;
    }
}
