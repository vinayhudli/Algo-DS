package com.vinay.leetcode.stack;

import java.util.Stack;

/*
https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i< tokens.length;i++){
            if (isOperator(tokens[i])){
                stack.push(operationResult(stack.pop(), stack.pop(), tokens[i]));
            }else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }

    private int operationResult(int secondOperand, int firstOperand, String operator){
        switch (operator){
            case "+":
                return firstOperand+secondOperand;
            case "-":
                return firstOperand-secondOperand;
            case "*":
                return firstOperand*secondOperand;
            default:
                return firstOperand/secondOperand;
        }
    }

    private boolean isOperator(String op){
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }
}
