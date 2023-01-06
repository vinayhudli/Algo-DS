package com.vinay.leetcode;

import java.util.Stack;

public class LongestParanthesis {

    public static void main(String[] args) {
     LongestParanthesis longestParanthesis = new LongestParanthesis();
        System.out.println(longestParanthesis.longestValidParentheses(""));
    }

    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> characterStack = new Stack<>();
        int max = 0;
        int currentCount = 0;

        for (int i=0;i<chars.length;i++){
            if (characterStack.empty() && chars[i]==')'){
                currentCount = 0;
                continue;
            }else if(chars[i] == '('){
                characterStack.push(chars[i]);
            }else {
                characterStack.pop();
                currentCount = currentCount+2;
                max = max<currentCount?currentCount:max;
            }
        }

        return max;
    }

}
