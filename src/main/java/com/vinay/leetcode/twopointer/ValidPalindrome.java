package com.vinay.leetcode.twopointer;

public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome(" "));
    }

    public boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length()-1;
        String s1 = s.toLowerCase();
        while (low<=high){
            char lowChar = s1.charAt(low);
            char highChar = s1.charAt(high);
            if (!isAlphaNumeric(lowChar))
                low++;
            else if (!isAlphaNumeric(highChar))
                high--;
            else if (lowChar != highChar) {
                return false;
            }else {
                high--;
                low++;
            }
        }
        return true;
    }

    private boolean isAlphaNumeric(char c){
        return (c >= 'a' && c <= 'z') || (c>='0' && c<='9');
    }
}
