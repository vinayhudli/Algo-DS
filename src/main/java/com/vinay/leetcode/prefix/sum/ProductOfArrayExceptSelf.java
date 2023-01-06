package com.vinay.leetcode.prefix.sum;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        int[] ints = productOfArrayExceptSelf.productExceptSelf(new int[]{1,2,3,4});
        for (int i=0;i< ints.length;i++) System.out.println(ints[i]);
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        result[nums.length-1] = 1;
        for (int i=0;i< nums.length-1;i++){
            result[i+1] = result[i]*nums[i];
        }

        int product = 1;
        for (int i=nums.length-1;i>0 ;i--){
            product *= nums[i];
            result[i-1] *= product;
        }

        return result;
    }
}
