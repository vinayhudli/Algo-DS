package com.vinay.leetcode.sliding.window;

/*
https://leetcode.com/problems/longest-repeating-character-replacement/description/
 */
public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxLength = 0;
        int maxCount = 0;
        int[] charCount = new int[26];
        for (int i=0;i<s.length();i++){
            maxCount = Math.max(maxCount, ++charCount[s.charAt(i)-'A']);
            while (i-left+1-maxCount>k){
                charCount[s.charAt(left)-'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, i-left+1);
        }
        return maxLength;
    }
}
