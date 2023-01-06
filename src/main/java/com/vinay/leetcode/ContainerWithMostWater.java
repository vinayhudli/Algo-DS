package com.vinay.leetcode;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(
                containerWithMostWater.maxArea(new int[] {1,2,1})
        );
    }

    public int maxArea(int[] height) {
        int max = 0;
        int maxArea = 0;
        for (int i=0;i<height.length;i++){
            if (max<height[i]){
                max = height[i];
                int nextIndex = -1 ;
                for (int j=i+1;j<height.length;j++){
                    int dim1 = height[j] ;
                    if (max < height[j]){
                        dim1 = max;
                        nextIndex = nextIndex == -1?j:nextIndex;
                    }
                    int currentArea = dim1*(j-i);
                    maxArea = maxArea<currentArea?currentArea:maxArea;
                }
                if (nextIndex == -1) {
                    return maxArea;
                }
                i = nextIndex-1;
            }
        }
        return maxArea;
    }
}
