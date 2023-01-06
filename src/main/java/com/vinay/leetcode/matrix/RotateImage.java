package com.vinay.leetcode.matrix;

import java.util.HashMap;
import java.util.Map;

public class RotateImage {
    Map<String, String> newIndexMap = new HashMap<>();

    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}});
    }

    public void rotate(int[][] matrix) {
        constructIndexMap(matrix);
        for (int i=0;i< matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                shuffleInPlace(matrix, i, j);
                if (newIndexMap.isEmpty())
                    return;
            }
        }

//        for (int i=0;i< matrix.length;i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                System.out.println(matrix[i][j]);
//            }
//            System.out.println("new row");
//        }
    }

    private void shuffleInPlace(int[][] matrix, int row, int column){
        int temp = matrix[row][column];
        while (newIndexMap.containsKey(row+"-"+column)){
            String[] s = newIndexMap.get(row + "-" + column).split("-");
            int tempRow = Integer.parseInt(s[0]);
            int tempCol = Integer.parseInt(s[1]);
            int val = matrix[tempRow][tempCol];
            matrix[tempRow][tempCol] = temp;
            temp = val;
            newIndexMap.remove(row+"-"+column);
            row = tempRow;
            column = tempCol;
        }
    }

    private void constructIndexMap(int[][] matrix){
        int row = 0;
        int col = 0;
        for (int i= matrix.length-1;i>=0;i--){
            for (int j=0;j<matrix[0].length;j++){
                newIndexMap.put(i+"-"+j, row+"-"+col);
                row++;
            }
            col++;
            row=0;
        }
    }

}
