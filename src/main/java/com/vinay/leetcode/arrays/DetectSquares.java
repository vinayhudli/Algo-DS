package com.vinay.leetcode.arrays;

/*
https://leetcode.com/problems/detect-squares/description/
 */
public class DetectSquares {

    int[][] pointsMatrix = new int[1001][1001];
    public DetectSquares() {
    }

    public void add(int[] point) {
        pointsMatrix[point[0]][point[1]]++;
    }

    public int count(int[] point) {
        int totalNumOfSquares = 0;
        for (int i=0;i<1001;i++){
            int numOfSquares = 0;
            int distance = i-point[0];
            if ( i == point[0] || pointsMatrix[i][point[1]] == 0 )
                continue;
            numOfSquares = pointsMatrix[i][point[1]];
            if (point[1]+distance >=0 && point[1]+distance < 1001) {
                numOfSquares *= pointsMatrix[point[0]][point[1] + distance];
                numOfSquares *= pointsMatrix[i][point[1] + distance];
            }else
                numOfSquares = 0;
            totalNumOfSquares += numOfSquares;

            numOfSquares = pointsMatrix[i][point[1]];
            if (point[1]-distance >= 0 && point[1]-distance<1001) {
                numOfSquares *= pointsMatrix[point[0]][point[1] - distance];
                numOfSquares *= pointsMatrix[i][point[1] - distance];
            }else
                numOfSquares=0;
            totalNumOfSquares += numOfSquares;
        }
        return totalNumOfSquares;
    }

    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[]{3,10});
        detectSquares.add(new int[]{11, 2});
        detectSquares.add(new int[]{3, 2});
        System.out.println(detectSquares.count((new int[]{11, 10})));
        System.out.println(detectSquares.count((new int[]{14, 8})));
        detectSquares.add(new int[]{11, 2});
        System.out.println(detectSquares.count((new int[]{11, 10})));
    }
}
