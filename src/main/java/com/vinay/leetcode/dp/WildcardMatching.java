package com.vinay.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class WildcardMatching {

    public static void main(String[] args) {
        WildcardMatching wildcardMatching = new WildcardMatching();
        System.out.println(wildcardMatching.isMatch("aab", "********"));
    }

    Boolean[][] incrementalResult ;
    public boolean isMatch(String s, String p) {
        char[] string = s.toCharArray();
        char[] pattern = p.toCharArray();
        List<Character> patternWithSingleStar = new ArrayList<>();
        char ch = ' ';
        for (int i=0;i< pattern.length;i++){
            if (ch == pattern[i] && pattern[i] == '*')
                continue;
            ch = pattern[i];
            patternWithSingleStar.add(ch);
        }
        Character[] characters = patternWithSingleStar.toArray(new Character[0]);
        incrementalResult = new Boolean[pattern.length][string.length];
        return iterativelyMatchPattern(string, 0, characters, 0);
//        return strmatch(s, p, s.length(), p.length());
    }

    private boolean iterativelyMatchPattern(char[] string, int stringIdx, Character[] pattern, int patternIdx){
        if (patternIdx == pattern.length && stringIdx < string.length)
            return false;
        else if (patternIdx == pattern.length && stringIdx == string.length)
            return true;
        else if (patternIdx < pattern.length && stringIdx == string.length){
            while (patternIdx < pattern.length){
                if (pattern[patternIdx] != '*'){
                    break;
                }
                patternIdx++;
            }
            return patternIdx==pattern.length;
        }

        if (incrementalResult[patternIdx][stringIdx] != null)
            return incrementalResult[patternIdx][stringIdx];

        boolean match = false;
        if (string[stringIdx] == pattern[patternIdx] || pattern[patternIdx] == '?'){
            match = iterativelyMatchPattern(string, stringIdx+1, pattern, patternIdx+1);
        }else if (pattern[patternIdx] == '*'){
            int temp = stringIdx;
            while (temp<=string.length) {
                match = match ||
                        iterativelyMatchPattern(string, temp , pattern, patternIdx + 1);
                if (match)
                    break;
                temp++;
            }
        }
        incrementalResult[patternIdx][stringIdx] = match;
        return match;
    }



        // Function that matches input str with
        // given wildcard pattern
        boolean strmatch(String str, String pattern,
                                int n, int m)
        {
            // empty pattern can only match with
            // empty string
            if (m == 0)
                return (n == 0);

            // lookup table for storing results of
            // subproblems
            boolean[][] lookup = new boolean[n + 1][m + 1];

            // initialize lookup table to false
            for (int i = 0; i < n + 1; i++)
                Arrays.fill(lookup[i], false);

            // empty pattern can match with empty string
            lookup[0][0] = true;

            // Only '*' can match with empty string
            for (int j = 1; j <= m; j++)
                if (pattern.charAt(j - 1) == '*')
                    lookup[0][j] = lookup[0][j - 1];

            // fill the table in bottom-up fashion
            for (int i = 1; i <= n; i++)
            {
                for (int j = 1; j <= m; j++)
                {
                    // Two cases if we see a '*'
                    // a) We ignore '*'' character and move
                    // to next character in the pattern,
                    //	 i.e., '*' indicates an empty
                    //	 sequence.
                    // b) '*' character matches with ith
                    //	 character in input
                    if (pattern.charAt(j - 1) == '*')
                        lookup[i][j] = lookup[i][j - 1]
                                || lookup[i - 1][j];

                        // Current characters are considered as
                        // matching in two cases
                        // (a) current character of pattern is '?'
                        // (b) characters actually match
                    else if (pattern.charAt(j - 1) == '?'
                            || str.charAt(i - 1)
                            == pattern.charAt(j - 1))
                        lookup[i][j] = lookup[i - 1][j - 1];

                        // If characters don't match
                    else
                        lookup[i][j] = false;
                }
            }

            return lookup[n][m];
        }

}
