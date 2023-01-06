package com.vinay.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> integers = spiralMatrix.spiralOrder(new int[][]{{1,5,9}});
        integers.forEach(System.out::println);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        minRow =-1;
        maxRow = (byte) matrix.length;
        minCol = -1;
        maxCol = (byte) matrix[0].length;
        int numberOfElements = matrix.length*matrix[0].length;
        int currentElements = 0;
        while (currentElements<numberOfElements){
            currentElements += traverse(matrix, minRow+1,0,minCol+1, 1 );
            minRow++;
            currentElements += traverse(matrix, minRow+1, 1, maxCol-1, 0);
            maxCol--;
            currentElements += traverse(matrix, maxRow-1, 0, maxCol-1, -1);
            maxRow--;
            currentElements += traverse(matrix, maxRow-1, -1, minCol+1, 0);
            minCol++;
        }
        return result;
    }
    byte minRow , maxRow , minCol , maxCol ;
    List<Integer> result = new ArrayList<>();
    private int traverse(int[][] matrix, int startRow, int rowAdder, int startCol, int colAdder){
        int row = startRow;
        int col = startCol;
        int elements = 0;
        while (row>minRow && row<maxRow && col>minCol && col<maxCol){
            result.add(matrix[row][col]);
            row += rowAdder;
            col += colAdder;
            elements++;
        }
        return elements;
    }
}
