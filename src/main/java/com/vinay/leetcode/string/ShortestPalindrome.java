package com.vinay.leetcode.string;

import java.util.Arrays;

/**
 * this computes kmp lookup table to get the string, it's not that intitutive but really good algorithm. Runtime is O(n+m) even though it looks like lps computation may be O(n2)
 * good link that explains this: https://www.youtube.com/watch?v=nJbNe0Yzjhw&ab_channel=FluentAlgorithms
 */
public class ShortestPalindrome {

    public static void main(String[] args) {
        ShortestPalindrome shortestPalindrome = new ShortestPalindrome();
        System.out.println(shortestPalindrome.shortestPalindrome("abcd"));
    }

    public String shortestPalindrome(String s) {
        if (s.length() <= 1)
            return s;
        return findSmallestPalindrome(s) ;
    }

    /**
     * lps means longest proper prefix which is also suffix.proper prefix always starts at 0 and suffix should always end
     * at the last position of the substring
     * @param chars
     * @return
     */
    private int[] getLpsArray(char[] chars){
        int[] lps = new int[chars.length];
        int t = 0;
        lps[0] = 0;
        for(int i=1;i< chars.length;i++){
            t = lps[i-1];
            while (t>0 && chars[t] != chars[i]){
                t = lps[t-1];
            }
            if (chars[t] == chars[i])
                t++;
            lps[i] = t;
        }
        return lps;
    }

    private String findSmallestPalindrome(String s){
        char[] chars1 = s.toCharArray();
        char[] reverse = reverse(chars1);
        char[] result = Arrays.copyOf(chars1, 2*chars1.length+1);
        result[chars1.length] = '#';
        System.arraycopy(reverse, 0, result, chars1.length+1, reverse.length);
        int[] lpsArray = getLpsArray(result);
        int index = lpsArray[lpsArray.length-1]  ;
        String value = String.valueOf(reverse, 0, reverse.length-index);
        return value + s;
    }

    private char[] reverse(char[] s){
        char[] reverse = new char[s.length];
        for (int i=0;i<s.length;i++){
            reverse[i] = s[s.length-1-i];
        }
        return reverse;
    }

//    private String findSmallestPalindromeNaive(char[] c, int low, int high){
//        if (low==high){
//            String str = String.valueOf(c);
//            String reverse = reverseString(c, low+1, c.length-1);
//            return reverse+str;
//        }
//
//        if (isPalindrome(c, low, high)){
//            String str = String.valueOf(c);
//            String reverse = reverseString(c, high+1, c.length-1);
//            return reverse+str;
//        }
//
//        return findSmallestPalindromeNaive(c, low, high-1);
//    }

//    private String reverseString(char[] ch, int low, int high){
//        char[] reverse = new char[high-low+1];
//        int i = 0;
//        while (high>=low){
//            reverse[i] = ch[high];
//            high--;
//            i++;
//        }
//        return String.valueOf(reverse);
//    }
//
//    private boolean isPalindrome(char[] ch, int low, int high){
//        while (low <= high){
//            if (ch[low] != ch[high])
//                return false;
//            low++;
//            high--;
//        }
//        return true;
//    }
}
