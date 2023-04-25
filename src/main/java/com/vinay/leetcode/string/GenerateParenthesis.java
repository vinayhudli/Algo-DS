package com.vinay.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        String str = "(";
        List<String> result = new ArrayList<>();
        generate(str, 1, n, result);

        return result;
    }

    public void generate(String str, int currentCount, int n, List<String> currentList){
        if (currentCount == 0 && str.length() == n * 2) {
            currentList.add(str);
            return;
        }else if(str.length() > n * 2 || currentCount < 0 || currentCount > n){
            return;
        }

        generate(str+"(", currentCount+1, n, currentList);
        generate(str+")", currentCount-1, n, currentList);
    }
}
