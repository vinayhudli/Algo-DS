package com.vinay.leetcode.matrix;

/*
https://leetcode.com/problems/set-matrix-zeroes/description/
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        int[][] matrix = new int[][]{{0,2,1},{1,2,0},{1,5,6}};
        setMatrixZeroes.setZeroes(matrix);
        for (int i=0;i< matrix.length;i++)
            for (int j=0;j<matrix[0].length;j++)
                System.out.println(matrix[i][j]);
    }

    /*
    taken from: https://leetcode.com/problems/set-matrix-zeroes/solutions/26014/any-shorter-o-1-space-solution/?orderBy=most_votes
     */
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        boolean col0 = false;
        for (int i=0;i<rows;i++){
            if (matrix[i][0] == 0) col0 = true;
            for (int j=1;j<cols;j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i=rows-1;i>=0;i--) {
            for (int j = cols-1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (col0) matrix[i][0] = 0;
        }
    }
}
