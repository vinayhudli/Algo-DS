package com.vinay.leetcode;

/*
https://leetcode.com/problems/maximal-rectangle/
good solution explanation: https://leetcode.com/problems/maximal-rectangle/discuss/1604254/C%2B%2B-Simple-Solution-w-Explanation-or-Optimizations-from-Brute-Force-to-DP
 */
public class MaximalRectangle {
/*
time: O((MN)^2)
Space: O(1)
 */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;

        int area=0, collen;

        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                collen = matrix[0].length;
                for (int row=i;row<matrix.length && matrix[row][j] == '1';row++){
                    int col;
                    for (col=j;col<matrix[0].length && matrix[row][col]=='1';col++);
                    collen = Math.min(collen, col-j);
                    area = Math.max(area, (row-i+1)*collen);
                }
            }
        }

        return area;
    }

    /*
    Time Complexity : O(M^2N)
Space Complexity : O(MN)
     */
    public int maximalRectangle1(char[][] matrix) {
        if (matrix.length == 0)
            return 0;

        int area=0, collen;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i=0;i<matrix.length;i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0){
                    dp[i][j] = matrix[i][j] == '1'?1:0;
                    continue;
                }
                dp[i][j] = matrix[i][j] == '1'?dp[i][j-1]+1:0;
            }
        }

        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                collen = matrix[0].length;
                for (int row=i;row<matrix.length && matrix[row][j] == '1';row++){
                    collen = Math.min(collen, dp[row][j]);
                    area = Math.max(area, (row-i+1)*collen);
                }
            }
        }

        return area;
    }
}
