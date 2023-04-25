package com.vinay.leetcode.twopointer;

/*
https://leetcode.com/problems/is-subsequence/description/
 */
public class IsSubsequence {

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence("axc", "aaxbc"));
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length())
            return false;
        int i=0;
        int slength = s.length();
        int tlength = t.length();
        for (int j=0;i<slength && j<tlength;j++){
            if (s.charAt(i) == t.charAt(j))
                i++;
        }
        return i==slength;
    }
}
