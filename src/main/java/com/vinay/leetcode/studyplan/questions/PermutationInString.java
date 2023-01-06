package com.vinay.leetcode.studyplan.questions;

public class PermutationInString {

    public static void main(String[] args) {
        PermutationInString permutationInString = new PermutationInString();
        System.out.println(permutationInString.checkInclusion("oo","eidbaocojahbc")) ;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];
        for (int i=0;i<s1.length();i++){
            s1Map[s1.charAt(i)-'a']++;
            s2Map[s2.charAt(i)-'a']++;
        }

        int count = 0;
        for (int i=0;i<26;i++){
            if (s1Map[i] == s2Map[i])
                count++;
        }
        if (count == 26)
            return true;

        for (int i=0;i<s2.length()-s1.length();i++){
            int r = s2.charAt(i+s1.length())-'a';
            int l = s2.charAt(i)-'a';

            s2Map[r]++;
            if (s2Map[r] == s1Map[r])
                count++;
            else if (s2Map[r] == s1Map[r]+1)
                count--;

            s2Map[l]--;
            if (s2Map[l] == s1Map[l])
                count++;
            else if (s2Map[l] == s1Map[l]-1)
                count--;

            if (count==26)
                return true;
        }

        return false;
    }

    public boolean checkInclusionLessOptimised(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];
        for (int i=0;i<s1.length();i++){
            s1Map[s1.charAt(i)-'a']++;
            s2Map[s2.charAt(i)-'a']++;
        }

        for (int i=0;i<s2.length()-s1.length();i++){
            if (matches(s1Map, s2Map))
                return true;

            s2Map[s2.charAt(i+s1.length()) - 'a']++;
            s2Map[s2.charAt(i) - 'a']--;
        }

        return matches(s1Map, s2Map);
    }

    public boolean matches(int[] s1Map, int[] s2Map){
        for (int i=0;i< s1Map.length;i++){
            if (s1Map[i] != s2Map[i])
                return false;
        }
        return true;
    }

}
