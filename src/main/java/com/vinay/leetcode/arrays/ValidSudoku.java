package com.vinay.leetcode.arrays;

/*
https://leetcode.com/problems/valid-sudoku/description/
 */

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        byte[][] rowSet = new byte[9][10];
        byte[][] colSet = new byte[9][10];
        byte[][] blockSet = new byte[9][10];

        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (board[i][j] == '.')
                    continue;
                int blockRow = (i/3)*3+j/3;
                int element = board[i][j] - '0';
                if (rowSet[i][element] > 0 || colSet[j][element] > 0 || blockSet[blockRow][element]>0)
                    return false;
                rowSet[i][element]++;
                colSet[j][element]++;
                blockSet[blockRow][element]++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        ValidSudoku validSudoku = new ValidSudoku();
        System.out.println(validSudoku.isValidSudoku(board));
    }
}
