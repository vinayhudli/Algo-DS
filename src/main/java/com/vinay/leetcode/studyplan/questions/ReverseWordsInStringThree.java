package com.vinay.leetcode.studyplan.questions;

public class ReverseWordsInStringThree {


    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            String reverseWord = reverseWord(split[i]);
            stringBuilder.append(reverseWord).append(" ");
        }
        stringBuilder.replace(stringBuilder.length()-1, stringBuilder.length(), "");
        return stringBuilder.toString();
    }

    public String reverseWord(String word){
        int low = 0;
        int high = word.length()-1;
        char[] chars = word.toCharArray();
        while (low<high){
            char temp = chars[low];
            chars[low] = chars[high] ;
            chars[high] = temp;
            low++;
            high--;
        }
        return String.copyValueOf(chars);
    }

}
