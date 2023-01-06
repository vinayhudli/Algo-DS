package com.vinay.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class StringToInteger {

    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(stringToInteger.myAtoiOptimised("2147483648"));
    }

    public int myAtoi(String s) {
        List<Character> positiveChars = new ArrayList<>(Arrays.asList('2','1','4','7','4','8','3','6','4','7'));
        s = s.trim();
        if (s.length() == 0)
            return 0;
        char[] chars = s.toCharArray();
        List<Character> extractedChars = new ArrayList<>();
        boolean isNegative = false;
        for (int i=0;i< chars.length;i++){
            if (i==0 && chars[i] == '-')
                isNegative = true;
            else if (i==0 && chars[i] == '+') {
                continue;
            } else if (chars[i]>='0' && chars[i]<='9') {
                extractedChars.add(chars[i]);
//                System.out.println(chars[i]);
            }else {
                break;
            }
        }
        int numberOfLeadingZeros = getNumberOfZeros(extractedChars);
        int actualSize = extractedChars.size()-numberOfLeadingZeros;
        if (actualSize>positiveChars.size()) {
            if (isNegative)
                return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        } else if (actualSize<positiveChars.size()) {
            int result = 0;
            for (int i=0;i<extractedChars.size();i++){
//                System.out.println(extractedChars.get(i));
                result= (result*10)+Character.getNumericValue(extractedChars.get(i));
//                System.out.println(result);
            }
            if (isNegative)
                result = -1*result;
            return result;
        }else{
            int result = 0;
            boolean isLess = false;
            for (int i=0;i<extractedChars.size();i++){
                System.out.println(extractedChars.get(i)+" , positive chars : "+positiveChars.get(i));
                if (isLess)
                    result= (result*10)+Character.getNumericValue(extractedChars.get(i));
                else if (i==extractedChars.size()-1 && isNegative && extractedChars.get(i)<=positiveChars.get(i)+1) {
                    result= (result*10)+Character.getNumericValue(extractedChars.get(i));
                } else if (extractedChars.get(i)<=positiveChars.get(i)) {
                    if (extractedChars.get(i)<positiveChars.get(i))
                        isLess = true;
                    result=(result*10)+ Character.getNumericValue(extractedChars.get(i));
                }else {
                    if (isNegative)
                        return Integer.MIN_VALUE;
                    return Integer.MAX_VALUE;
                }
            }
            return isNegative? -1*result:result;
        }
    }

    private int getNumberOfZeros(List<Character> list){
        int result = 0;
        for (Character ch:list){
            if (ch == '0')
                result++;
            else
                break;
        }
        return result;
    }

    /**
     * This is really good solution, straightforward
     */
    private int myAtoiOptimised(String s){
        int index = 0;
        boolean isNegative = false;
        s = s.trim();
        if (s.length() == 0)
            return 0;
        char[] chars = s.toCharArray();
        if (chars[index] == '-') {
            isNegative = true;
            index++;
        } else if (chars[index] == '+') {
            index++;
        }

        int total = 0;
        int maxDivideBy10 = Integer.MAX_VALUE/10;
        int rem = Integer.MAX_VALUE%10;
        while (index<chars.length){
            int digit = chars[index]-'0';
            if (digit<0 || digit>9)
                break;

            if (maxDivideBy10 < total || (maxDivideBy10 == total && rem < total))
                return isNegative? Integer.MIN_VALUE:Integer.MAX_VALUE;
            total = total*10+digit;
            index++;
        }
        return isNegative?total*-1:total;
    }

}
