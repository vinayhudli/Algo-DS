package com.vinay.leetcode.stack;

import java.util.Stack;

/*
https://leetcode.com/problems/daily-temperatures/
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] ints = dailyTemperatures.dailyTemperatures(new int[]{30,60,90});
        for (int i:ints){
            System.out.println(i);
        }
    }

//    using stack
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i =0;i< temperatures.length;i++){
            while (!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                Integer pop = stack.pop();
                ans[pop] = i-pop;
            }
            stack.push(i);
        }
        return ans;
    }
}
