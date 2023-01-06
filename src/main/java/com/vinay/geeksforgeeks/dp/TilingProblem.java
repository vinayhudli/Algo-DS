package com.vinay.geeksforgeeks.dp;

public class TilingProblem {
    //TODO: incomplete solution
//    public void calculateNumberOfWays(int n, int[] availableWays){
//        if (n==2 || n==1)
//            availableWays[n] = n;
//            return ;
//
//        if(availableWays[yDimension][xDimension] != -1)
//            return ;
//
//        int horizontallyLaid = 0, verticallyLaid = 0 ;
//        if(yDimension-1>=0 && xDimension-2>=0){
//            calculateNumberOfWays(yDimension-1, xDimension-2, availableWays) ;
//            horizontallyLaid = availableWays[yDimension-1][xDimension-2] == -1?0: availableWays[yDimension-1][xDimension-2];
//        }
//
//
//        if(yDimension-2>=0 && xDimension-1>=0) {
//            calculateNumberOfWays(yDimension - 2, xDimension - 1, availableWays);
//            verticallyLaid = availableWays[yDimension-2][xDimension-1] == -1?0:  availableWays[yDimension-2][xDimension-1];
//        }
//
//        availableWays[yDimension][xDimension] = horizontallyLaid+verticallyLaid;
//    }

    public static void main(String[] args) {
        TilingProblem tilingProblem = new TilingProblem();
        int[][] availableWays = new int[3][5];
        for (int i=0;i<3;i++){
            for (int j=0;j<5;j++){
                availableWays[i][j] = -1;
            }
        }

        availableWays[1][2] = 1;
        availableWays[2][1] = 1;
//        tilingProblem.calculateNumberOfWays(2, 4, availableWays);
//        System.out.println(availableWays[2][4]);
    }
}
