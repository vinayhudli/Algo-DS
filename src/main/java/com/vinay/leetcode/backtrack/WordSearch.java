package com.vinay.leetcode.backtrack;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {

    public static void main(String[] args) {

        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(new char[][]{
                {'A','A','A','A','A','A'},
                {'A','A','A','A','A','A'},
                {'A','A','A','A','A','A'},
                {'A','A','A','A','A','A'},
                {'A','A','A','A','A','A'},
                {'A','A','A','A','A','A'}}, "AAAAAAAAAAAABAA"));

    }

//    Note: whenever you want to maintain a visited indices in an array, try to set that index value to special char and revert after processing
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i=0;i< board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (recursiveCharMatch(board, i, j, chars, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean recursiveCharMatch(char[][] board, int boardRow, int boardCol, char[] word, int wordIndex){
        if (wordIndex >= word.length)
            return true;
        else if (boardRow < 0 || boardCol < 0 || boardRow >= board.length || boardCol >= board[0].length || board[boardRow][boardCol] == '*')
            return false;
        char c = board[boardRow][boardCol];
        board[boardRow][boardCol] = '*' ;
        boolean result = false;
        if (word[wordIndex] == c){
            result = recursiveCharMatch(board, boardRow+1, boardCol, word, wordIndex+1) ||
                                recursiveCharMatch(board, boardRow, boardCol+1, word, wordIndex+1) ||
                                recursiveCharMatch(board, boardRow-1, boardCol, word, wordIndex+1) ||
                                recursiveCharMatch(board, boardRow, boardCol-1, word, wordIndex+1) ;
        }
        board[boardRow][boardCol] = c;
        return result;
    }
}
