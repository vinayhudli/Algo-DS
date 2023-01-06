package com.vinay.leetcode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumOfSubarrayMinimums {

    public static void main(String[] args) throws IOException {
        SumOfSubarrayMinimums sumOfSubarrayMinimums = new SumOfSubarrayMinimums();
        int[] arr ;
        try(BufferedReader bf = new BufferedReader(new FileReader("/Users/vinay.deshpande/personal_repo/Algo-DS/src/main/java/com/vinay/leetcode/temp.txt"))) {
            String line = bf.readLine();
            String[] split = line.split(",");
            arr = new int[split.length];
            for (int i=0;i<split.length;i++){
                arr[i] = Integer.valueOf(split[i]);
//                System.out.println(arr[i]);
            }
            System.out.println("array length : "+arr.length);
        }
        System.out.println(sumOfSubarrayMinimums.sumSubarrayMins(arr));

    }


    int sum = 0;

    public int sumSubarrayMins(int[] arr) {
        for (int i=0;i<arr.length;i++)
            recursiveSubArraySum(arr, i);
        return sum;
    }

    private void recursiveSubArraySum(int[] arr, int start){

        sum = (sum + arr[start]) % 1000000007;
        int min = arr[start];
        for (int i=start+1;i<arr.length;i++){
            min = Math.min(arr[i], min);
            sum = (sum+min) % 1000000007;
        }
    }
}
