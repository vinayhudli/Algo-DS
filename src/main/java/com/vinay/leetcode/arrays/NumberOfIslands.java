package com.vinay.leetcode.arrays;

public class NumberOfIslands {

    int numberOfIslands = 0;

    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println(numberOfIslands.numIslands(new char[][]{
                {'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
    {'0','0','0','0','0'}}));
    }

    public int numIslands(char[][] grid) {
        char[][] clone = grid.clone();
        for (int i=0;i< grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (clone[i][j] != '-' && clone[i][j] != '0') {
                    if (recursiveConstructIsland(clone, i, j, 0))
                        numberOfIslands++;
                }
            }
        }
        return numberOfIslands;
    }

    private boolean recursiveConstructIsland(char[][] grid, int row, int col, int numberOfOne){
        if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0)
            return numberOfOne!=0;

        if (grid[row][col] == '-')
            return numberOfOne!=0;
        if (grid[row][col] == '1'){
            numberOfOne++;
            grid[row][col] = '-';
            boolean nextRow = recursiveConstructIsland(grid, row+1, col, numberOfOne) ;
            boolean preRow = recursiveConstructIsland(grid, row-1, col, numberOfOne) ;
            boolean nextCol = recursiveConstructIsland(grid, row, col+1, numberOfOne) ;
            boolean preCol = recursiveConstructIsland(grid, row, col-1, numberOfOne);

            return nextRow || nextCol || preCol || preRow ;
        }
        return numberOfOne!=0;
    }
}
