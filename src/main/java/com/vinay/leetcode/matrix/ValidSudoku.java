package com.vinay.leetcode.matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
//        validSudoku.isValidSudoku();
    }

    MatrixPoint[][] matrixPoints = new MatrixPoint[][]{
            {new MatrixPoint(0,0), new MatrixPoint(2,2)},
            {new MatrixPoint(0,3), new MatrixPoint(2,5)},
            {new MatrixPoint(0,6), new MatrixPoint(2,8)},

            {new MatrixPoint(3,0), new MatrixPoint(5,2)},
            {new MatrixPoint(3,3), new MatrixPoint(5,5)},
            {new MatrixPoint(3,6), new MatrixPoint(5,8)},

            {new MatrixPoint(6,0), new MatrixPoint(8,2)},
            {new MatrixPoint(6,3), new MatrixPoint(8,5)},
            {new MatrixPoint(6,6), new MatrixPoint(8,8)},
    };

    public boolean isValidSudoku(char[][] board) {
        for (int i=0; i<9;i++){
            if (!isSubMatrixValid(matrixPoints[i][0], matrixPoints[i][1], board)){
                return false;
            }
        }
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (board[i][j] == '.')
                    continue;
                if (board[i][j]>'9' || board[i][j]<'1'){
                    return false;
                }
                if (!isRowAndColumnValid(i,j, board))
                    return false;
            }
        }
        return true;
    }

    private boolean isSubMatrixValid(MatrixPoint low, MatrixPoint high, char[][] board){
        Set<Character> set = new HashSet<>();
        for (int i=low.x;i<=high.x;i++){
            for (int j=low.y; j<= high.y; j++){
                if (set.contains(board[i][j]))
                    return false;
            }
        }
        return true;
    }

    private boolean isRowAndColumnValid(int x, int y, char[][] board){
        for (int i=0;i<9;i++){
            if (y != i && board[x][y] == board[x][i])
                return false;
            if (x != i && board[i][y] == board[x][y])
                return false;
        }

        return true;
    }

    class MatrixPoint{
        int x;
        int y;

        public MatrixPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
