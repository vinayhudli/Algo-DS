package com.vinay.leetcode.binarysearch;

/*
https://leetcode.com/problems/search-a-2d-matrix/description/
 */
public class SearchA2DMatrix {

    public static void main(String[] args) {
        SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix();
        System.out.println(searchA2DMatrix.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 0));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int targetRow = -1;
        int colLength = matrix[0].length -1;
        for (int i=0;i< matrix.length;i++){
            if (matrix[i][0] <= target && matrix[i][colLength] >= target){
                targetRow = i;
                break;
            }
        }
        if (targetRow == -1)
            return false;
        int low =0, high = colLength, mid = -1;
        while (low<=high){
            mid = (low+high)/2;
            if (matrix[targetRow][mid] == target)
                return true;
            else if (matrix[targetRow][mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return false;
    }
}
