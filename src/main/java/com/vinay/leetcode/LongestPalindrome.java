package com.vinay.leetcode;

public class LongestPalindrome {
    PalindromeIndex[][] palindromeString;

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("ac"));
    }

    public String longestPalindrome(String s) {
        palindromeString = new PalindromeIndex[s.length()][s.length()];
        char[] chars = s.toCharArray();
        PalindromeIndex palindromeIndex = palindromeSubstring(chars, 0, s.length() - 1);
        StringBuilder str = new StringBuilder();
        for (int i = palindromeIndex.start;i<= palindromeIndex.end;i++)
            str.append(chars[i]);

        return str.toString();
    }

    public PalindromeIndex palindromeSubstring(char[] chars, int start, int end){
        if (start >end)
            return null;
        if (start == end)
            return new PalindromeIndex(start, start);

        if (palindromeString[start][end] != null) {
            return palindromeString[start][end];
        }

        if (isPalindrome(chars, start, end)){
            palindromeString[start][end] = new PalindromeIndex(start,end);
            return palindromeString[start][end];
        }
        if (start == end-1) {
            palindromeString[start][start] = new PalindromeIndex(start, start);
            return palindromeString[start][start];
        }
        PalindromeIndex lowerStr = palindromeSubstring(chars, start, end-1);
        int lowerStrLength = lowerStr.end - lowerStr.start+1;
        if (lowerStrLength == (end-start)) {
            palindromeString[start][end] = lowerStr;
            return lowerStr;
        }
        PalindromeIndex upperStr = palindromeSubstring(chars, start+1, end);
        int upperStrLength = upperStr.end- upperStr.start+1;

        if (lowerStrLength>upperStrLength) {
            palindromeString[start][end] = lowerStr;
            return lowerStr;
        }
        palindromeString[start][end] = upperStr;
        return upperStr;
    }

    private boolean isPalindrome(char[] chars, int start, int end){
        int low = start;
        int high = end;
        int compareTill = (end-start)/2;
        for (int i=0;i<=compareTill;i++){
            if (chars[low+i] != chars[end-i]){
                return false;
            }
        }
        return true;
    }

    class PalindromeIndex{
        int start;
        int end;

        public PalindromeIndex(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "PalindromeIndex{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
