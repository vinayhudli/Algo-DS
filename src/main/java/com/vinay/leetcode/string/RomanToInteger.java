package com.vinay.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        Map<Character, Short> map = new HashMap<>();
        map.put('I', (short) 1);
        map.put('V', (short) 5);
        map.put('X', (short) 10);
        map.put('L', (short) 50);
        map.put('C', (short) 100);
        map.put('D', (short) 500);
        map.put('M', (short) 1000);

        int total = 0;
        for (int i=0;i< s.length();i++){
            if (i+1< s.length()) {
                if ((s.charAt(i) == 'I' && (s.charAt(i+1)=='V' || s.charAt(i+1)=='X'))
                 || (s.charAt(i) == 'X' && (s.charAt(i+1)=='L' || s.charAt(i+1)=='C'))
                    || (s.charAt(i) == 'C' && (s.charAt(i+1)=='D' || s.charAt(i+1)=='M'))) {
                    total = total+(map.get(s.charAt(i+1)) - map.get(s.charAt(i)));
                    i++;
                }else {
                    total += map.get(s.charAt(i)) ;
                }
            }else {
                total += map.get(s.charAt(i)) ;
            }
        }

        return total;
    }
}
