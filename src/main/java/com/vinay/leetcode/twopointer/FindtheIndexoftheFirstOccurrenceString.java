package com.vinay.leetcode.twopointer;

/*
https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 */
public class FindtheIndexoftheFirstOccurrenceString {

    public static void main(String[] args) {
        FindtheIndexoftheFirstOccurrenceString findtheIndexoftheFirstOccurrenceString = new FindtheIndexoftheFirstOccurrenceString();
        System.out.println("value : "+findtheIndexoftheFirstOccurrenceString.strStr("leetcode", "z"));
    }

    public int strStr(String haystack, String needle) {
        for (int i=0;i<haystack.length();i++){
            for (int j=0;;j++){
                if (j==needle.length()) return i;
                if (i+j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i+j)) break;
            }
        }
        return -1;
    }

}
