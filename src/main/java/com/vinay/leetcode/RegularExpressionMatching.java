package com.vinay.leetcode;

public class RegularExpressionMatching {
    Boolean[][] intermediateResults ;

    public static void main(String[] args) {
        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
        System.out.println(regularExpressionMatching.isMatch("aa","a"));
    }

    public boolean isMatch(String s, String p) {
        char[] value = s.toCharArray();
        char[] pattern = p.toCharArray();
        intermediateResults = new Boolean[pattern.length+1][value.length+1];
        return matchChar(value, 0, pattern, 0);
    }

    public boolean matchChar(char[] value, int valueIndex, char[] pattern, int patternIndex){
        if (patternIndex>=pattern.length && valueIndex<value.length)
            return false;
        else if (patternIndex >= pattern.length )
            return true;

        if (intermediateResults[patternIndex][valueIndex] != null)
            return intermediateResults[patternIndex][valueIndex];

        if (patternIndex<pattern.length-1 && pattern[patternIndex+1] == '*'){
            intermediateResults[patternIndex][valueIndex] = false ;
            if (valueIndex<value.length && (pattern[patternIndex] == '.' || pattern[patternIndex]==value[valueIndex])){
                intermediateResults[patternIndex][valueIndex] = matchChar(value, valueIndex+1, pattern, patternIndex+2) ||
                        matchChar(value, valueIndex+1, pattern, patternIndex) ;
            }
            intermediateResults[patternIndex][valueIndex] = intermediateResults[patternIndex][valueIndex] || matchChar(value, valueIndex, pattern, patternIndex+2);
        }else {
            if (valueIndex < value.length && (pattern[patternIndex]==value[valueIndex] || pattern[patternIndex]=='.')){
                intermediateResults[patternIndex][valueIndex] = matchChar(value, valueIndex+1, pattern, patternIndex+1);
            }else {
                intermediateResults[patternIndex][valueIndex] = false;
            }
        }
        return intermediateResults[patternIndex][valueIndex];
    }

    public int getNextIndexAfterMatch(char[] value, char pattern, int valueIndex){
        if (pattern == '.')
            return value.length;
        for (int i =valueIndex;i<value.length;i++){
            if (pattern!=value[i])
                return i;
        }
        return value.length;
    }
}
