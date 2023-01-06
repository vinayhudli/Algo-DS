package com.vinay.leetcode.studyplan.questions;

public class ReverseString {

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString(new char[]{'h','e','l','l','o'});
    }

    public void reverseString(char[] s) {
        int low = 0;
        int high = s.length-1;
        while (low<high){
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;
            low++;
            high--;
        }
    }
}
