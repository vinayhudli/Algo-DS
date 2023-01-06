package com.vinay.leetcode.dp;

public class LongestIncreasingPathInAMatrix {

    public static void main(String[] args) {
        LongestIncreasingPathInAMatrix longestIncreasingPathInAMatrix = new LongestIncreasingPathInAMatrix();
        System.out.println(longestIncreasingPathInAMatrix.longestIncreasingPath(new int[][]{{6,1},{5,2},{4,3}}));
    }

    public int longestIncreasingPath(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                calculateMaxLengthForIndices(result, matrix, i,j);
            }
        }

        return maxLength;
    }

    int maxLength = 0;
    private void calculateMaxLengthForIndices(int[][] result, int[][] matrix, int row, int col){
        if (row >= matrix.length || col >= matrix[0].length)
            return;

        if (result[row][col] > 0)
            return;
        if (row < matrix.length-1 && matrix[row][col] < matrix[row+1][col]){
            calculateMaxLengthForIndices(result, matrix, row+1, col);
            result[row][col] = Math.max(result[row][col], result[row+1][col]);
        }
        if (row > 0 && matrix[row][col] < matrix[row-1][col]) {
            calculateMaxLengthForIndices(result, matrix, row-1, col);
            result[row][col] = Math.max(result[row][col], result[row-1][col]);
        }
        if (col < matrix[0].length-1 && matrix[row][col] < matrix[row][col+1]) {
            calculateMaxLengthForIndices(result, matrix, row, col+1);
            result[row][col] = Math.max(result[row][col], result[row][col+1]);
        }
        if (col > 0 && matrix[row][col] < matrix[row][col-1]) {
            calculateMaxLengthForIndices(result, matrix, row, col-1);
            result[row][col] = Math.max(result[row][col], result[row][col-1]);
        }
        result[row][col]++;
        maxLength = Math.max(maxLength, result[row][col]);
    }
}
