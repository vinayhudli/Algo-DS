package com.vinay.leetcode;

import java.util.*;

public class IntegerToRoman {

    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        System.out.println(integerToRoman.intToRoman(20));
    }

    public String intToRoman(int num) {
        List<Integer> nos = Arrays.asList(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
        List<String> symbols = Arrays.asList("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");
//        Map<Integer, String> map = new LinkedHashMap<>();
//        map.put(1000, "M");
//        map.put(900, "CM");
//        map.put(500, "D");
//        map.put(400, "CD");
//        map.put(100, "C");
//        map.put(90, "XC");
//        map.put(50, "L");
//        map.put(40, "XL");
//        map.put(10, "X");
//        map.put(9, "IX");
//        map.put(5, "V");
//        map.put(4, "IV");
//        map.put(1, "I");

        int currentValue = num;
        StringBuilder str = new StringBuilder();
        int startIndex = 0;
        while (currentValue>0){
            for (int i=startIndex;i<nos.size();i++){
                if (nos.get(i)<=currentValue){
                    str.append(symbols.get(i));
                    currentValue -= nos.get(i);
                    startIndex = i;
                    break;
                }
            }
        }

        return str.toString();
    }

}
