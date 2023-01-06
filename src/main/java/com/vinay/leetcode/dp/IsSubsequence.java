package com.vinay.leetcode.dp;

public class IsSubsequence {

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence("axc", "aaxbc"));
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length())
            return false;
        int lasrgerStringIndex = 0;
        char[] largerString = t.toCharArray();
        char[] smallerString = s.toCharArray();
        for (int i=0;i< smallerString.length;i++){
            char search = smallerString[i];
            if (lasrgerStringIndex == largerString.length)
                return false;
            boolean found = false;
            while (lasrgerStringIndex < largerString.length){
                if (largerString[lasrgerStringIndex] == search) {
                    found = true;
                    lasrgerStringIndex++;
                    break;
                }
                lasrgerStringIndex++;
            }
            if (!found)
                return false;
        }
        return true;
    }
}
