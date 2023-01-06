package com.vinay.leetcode;

import java.util.Arrays;

public class UniqueBinarySearchTrees {
    int[][] interimResult ;
    public static void main(String[] args) {
        UniqueBinarySearchTrees uniqueBinarySearchTrees =  new UniqueBinarySearchTrees();
        System.out.println(uniqueBinarySearchTrees.numTrees(3));

    }

    public int numTrees(int n) {
        interimResult = new int[n+1][n+1];
        for (byte i =0;i<interimResult.length;i++){
            for (byte j=0;j< interimResult.length;j++){
                interimResult[i][j] = -1 ;
            }
        }
        return numSubTrees(1, n);
    }

    public int numSubTrees(int min, int max){

        if (min >= max)
            return 1;

        if (interimResult[min][max] > -1)
            return interimResult[min][max];

        int total = 0;
        for (int i=min;i<=max;i++){
            int numLeftSubTrees = numSubTrees(min, i-1);
            int numRightSubTrees = numSubTrees(i+1, max);
            total += numLeftSubTrees*numRightSubTrees;
        }
        interimResult[min][max] = total;
        return total;
    }
}
