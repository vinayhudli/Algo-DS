package com.vinay.leetcode.sliding.window;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        int a = 'z';
        int A = 'Z';
        System.out.println(a);
        System.out.println(A);
//        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
//        System.out.println(minimumWindowSubstring.minWindow("a", "b"));
    }
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return new String();
        }
        int[] map = new int[123];
        int count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex=0;
        for (int i=0;i<t.length();i++)
            map[t.charAt(i)]++;

        while (end < s.length()) {
            char ch = s.charAt(end++);
            if (map[ch]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                ch = s.charAt(start++);
                if (map[ch]++ == 0) {
                    count++;
                }
            }
        }

        return minLen == Integer.MAX_VALUE? new String():
                s.substring(startIndex, startIndex+minLen);
    }

    int tSize;
    String s;
    Map<Character, Integer> tCharacterCount = new HashMap<>();
    Map<Character, Integer> sCharacterCount = new HashMap<>();
    int minLength = Integer.MAX_VALUE;
    String minStr = "";

    boolean[][] visited ;

    public String minWindow1(String s, String t) {
        this.s = s;
        visited = new boolean[s.length()][s.length()];
        tSize = t.length();
        if (t.length()>s.length())
            return "";
        for (int i=0;i<t.length();i++)
            tCharacterCount.put(t.charAt(i), tCharacterCount.getOrDefault(t.charAt(i), 0)+1);
        for (int j=0;j<s.length();j++)
            sCharacterCount.put(s.charAt(j), sCharacterCount.getOrDefault(s.charAt(j), 0)+1);
        findTheMinWindow(0, s.length()-1);
        return minStr;
    }

    private void findTheMinWindow(int low, int high){
        if (low > high || high-low+1 < tSize || visited[low][high])
            return;

        visited[low][high] = true;
        if (sCharacterCount.get(s.charAt(low)) > tCharacterCount.getOrDefault(s.charAt(low), 0)){
            sCharacterCount.put(s.charAt(low), sCharacterCount.get(s.charAt(low))-1);
            findTheMinWindow(low+1, high);
            sCharacterCount.put(s.charAt(low), sCharacterCount.get(s.charAt(low))+1);
        }
        if (sCharacterCount.get(s.charAt(high)) > tCharacterCount.getOrDefault(s.charAt(high), 0)){
            sCharacterCount.put(s.charAt(high), sCharacterCount.get(s.charAt(high))-1);
            findTheMinWindow(low, high-1);
            sCharacterCount.put(s.charAt(high), sCharacterCount.get(s.charAt(high))+1);
        }
        if (minLength > high-low && isMatch()){
            minLength = high-low;
            minStr = s.substring(low, high+1);
        }
    }

    private boolean isMatch(){
        for (Map.Entry<Character, Integer> entry:tCharacterCount.entrySet()){
            if (entry.getValue()> sCharacterCount.getOrDefault(entry.getKey(), 0))
                return false;
        }
        return true;
    }

}
