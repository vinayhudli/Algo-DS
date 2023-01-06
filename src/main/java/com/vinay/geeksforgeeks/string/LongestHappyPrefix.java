package com.vinay.geeksforgeeks.string;

public class LongestHappyPrefix {

    public static void main(String[] args) {
        System.out.println(longestPrefix("ababc"));
    }

    static String longestPrefix(String s)
    {
        char[] c = s.toCharArray();
        int[][] dp = new int[c.length][c.length];
        int maxLength = 0;
        int maxLengthEndingIndex = -1;
        for (int i=0;i<c.length-1;i++){
            for (int j=i+1;j<c.length;j++){
                if (i == 0 && c[i]!=c[j])
                    continue;
                if (c[i] == c[j]){
                    int pre = 0;
                    if (i>0 && j>0)
                        pre = dp[i-1][j-1];

                    dp[i][j] = pre+1;
                    if (dp[i][j] > maxLength && (i == 0 || (i-pre) == 0)){
                        maxLength = dp[i][j];
                        maxLengthEndingIndex = i;
                    }
                }
            }
            if (maxLength == 0)
                break;
        }
        String str = "";
        if (maxLength>0){
            str = String.copyValueOf(c, maxLengthEndingIndex-maxLength+1, maxLength);
        }
        return str;

    }

}
