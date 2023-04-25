package com.vinay.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/*
https://leetcode.com/problems/car-fleet/description/
 */
public class CarFleet {
    /*
    the logic is that the car farther from target takes less time than car nearer to target will always catch up
     */
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length ==1)
            return 1;
        double[][] positionAndTime = new double[position.length][2];
        for (int i=0;i< position.length;i++){
            positionAndTime[i][0] = position[i];
            positionAndTime[i][1] = ((double) target-position[i])/speed[i];
        }

        Arrays.sort(positionAndTime, Comparator.comparingDouble(a -> a[0]));
        int numOfFleet = 0;
        double currentLow = 1000001;
        for (int i= position.length-1;i>=0;i--){
            if (positionAndTime[i][1] <= currentLow){
                currentLow = positionAndTime[i][1];
                numOfFleet++;
            }
        }
        return numOfFleet;
    }
}
