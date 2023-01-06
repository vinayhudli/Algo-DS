package com.vinay.leetcode;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        ValidParenthesis validParenthesis = new ValidParenthesis();
        System.out.println(validParenthesis.isValid("{[]}"));
    }

    public boolean isValid(String s) {
        if (s.length()%2 != 0)
            return false;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c:chars){
            if (isClosingType(c)){
                if (stack.isEmpty() || !arePairs(stack.pop(), c))
                    return false;
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private boolean isClosingType(char c){
        return c == ')' || c == '}' || c == ']';
    }

    private boolean arePairs(char open, char close){
        switch (close){
            case '}':
                return open == '{';
            case ')':
                return open == '(';
            case ']':
                return open == '[';
        }
        return false;
    }
}
