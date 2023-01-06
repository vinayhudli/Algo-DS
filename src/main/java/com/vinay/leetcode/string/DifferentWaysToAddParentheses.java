package com.vinay.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaysToAddParentheses {

    Map<String, List<Integer>> interimResult = new HashMap<>();

    public static void main(String[] args) {
        DifferentWaysToAddParentheses differentWaysToAddParentheses = new DifferentWaysToAddParentheses();
        List<Integer> list = differentWaysToAddParentheses.diffWaysToCompute("2-1-1");
        for (Integer entry:list){
            System.out.println(entry);
        }
    }

    public List<Integer> diffWaysToCompute(String expression) {
        computeSmallerChunk(expression);
        return interimResult.get(expression);
    }

    private void computeSmallerChunk(String str){
        if (interimResult.containsKey(str)){
            return;
        }

        List<Integer> result = new ArrayList<>();
        for (int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if (isOperator(c)){
                String leftChunk = str.substring(0, i) ;
                computeSmallerChunk(leftChunk);
                List<Integer> leftChunkResult = interimResult.get(leftChunk);
                String rightChunk = str.substring(i + 1);
                computeSmallerChunk(rightChunk);
                List<Integer> rightChunkResult = interimResult.get(rightChunk);

                for (Integer leftEntry:leftChunkResult){
                    for (Integer rightEntry:rightChunkResult){
                        int temp ;
                        if (c == '+'){
                            temp = leftEntry + rightEntry;
                        }else if (c == '-'){
                            temp = leftEntry - rightEntry;
                        }else {
                            temp = leftEntry*rightEntry;
                        }
                        result.add(temp);
                    }
                }
            }
        }
        if(result.isEmpty())
            result.add(Integer.valueOf(str));
        interimResult.put(str, result);
    }

    private boolean isOperator(char c){
        return c == '+' || c == '-' || c == '*' ;
    }
}
