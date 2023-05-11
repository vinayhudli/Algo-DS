package com.vinay.runner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ApplicationRunner {

    public static int Var1 ;
    public static void main(String[] args) throws InterruptedException {
        ApplicationRunner applicationRunner = new ApplicationRunner();
        Object obj = LocalDateTime.now();
        if (obj instanceof LocalDateTime){
            LocalDateTime convert = (LocalDateTime) obj;
            System.out.println(convert);
        }
    }

    int maxArea = 0;
    public int maxArea(int[] height) {
        int low = 0, high = height.length-1;
        while (low < high){
            if (height[low] < height[high]){
                maxArea = Math.max(maxArea, (high-low)*height[low]);
                low++;
            } else if (height[low] > height[high]) {

            }else{

            }
        }
        return maxArea;
    }
}
