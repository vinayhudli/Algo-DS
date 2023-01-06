package com.vinay.leetcode;

import java.util.*;

public class LetterCombinationOfPhoneNumber {
    public static void main(String[] args) {
        LetterCombinationOfPhoneNumber letterCombinationOfPhoneNumber = new LetterCombinationOfPhoneNumber();
        List<String> strings = letterCombinationOfPhoneNumber.letterCombinations("23");
        for (String str:strings){
            System.out.println(str);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty())
            return new ArrayList<>();

        List<String> result = new ArrayList<>();
        addCombination(digits, "", result);
        return result;
    }

    private List<Character> getCharacterForDigit(byte b){
        switch (b){
            case 2:
                return Arrays.asList('a','b','c');
            case 3:
                return Arrays.asList('d','e','f');
            case 4:
                return Arrays.asList('g','h','i');
            case 5:
                return Arrays.asList('j','k','l');
            case 6:
                return Arrays.asList('m','n','o');
            case 7:
                return Arrays.asList('p','q','r','s');
            case 8:
                return Arrays.asList('t','u','v');
            case 9:
                return Arrays.asList('w','x','y','z');
            default:
                return new ArrayList<>();
        }
    }


    public void addCombination(String subDigit, String combination, List<String> result){
        int digit = Integer.parseInt(subDigit.substring(0, 1));
        List<Character> characterForDigit = getCharacterForDigit((byte) digit);
        for (Character c: characterForDigit){
            String newCombination = combination+c;
            if (subDigit.length() > 1)
                addCombination(subDigit.substring(1), newCombination, result);
            else
                result.add(newCombination);
        }
    }
}
