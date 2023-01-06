package com.vinay.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/integer-to-english-words/
 */
public class IntegerToEnglishWords {

    public static void main(String[] args) {
        IntegerToEnglishWords integerToEnglishWords = new IntegerToEnglishWords();
        System.out.println(integerToEnglishWords.numberToWords(1000000000));
    }

    public String numberToWordsMyVersion(int num) {
        if (num == 0)
            return "Zero";
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"One");
        map.put(2,"Two");
        map.put(3,"Three");
        map.put(4,"Four");
        map.put(5,"Five");
        map.put(6,"Six");
        map.put(7,"Seven");
        map.put(8,"Eight");
        map.put(9,"Nine");
        map.put(10,"Ten");
        map.put(11,"Eleven");
        map.put(12,"Twelve");
        map.put(13,"Thirteen");
        map.put(14,"Fourteen");
        map.put(15,"Fifteen");
        map.put(16,"Sixteen");
        map.put(17,"Seventeen");
        map.put(18,"Eighteen");
        map.put(19,"Nineteen");
        map.put(20,"Twenty");
        map.put(30,"Thirty");
        map.put(40,"Forty");
        map.put(50,"Fifty");
        map.put(60,"Sixty");
        map.put(70,"Seventy");
        map.put(80,"Eighty");
        map.put(90,"Ninety");
        map.put(100, "Hundred");
        map.put(1000, "Thousand");
        map.put(1000*1000, "Million");
        map.put(1000*1000*1000, "Billion");

        StringBuilder stringBuilder = new StringBuilder();
        int initialMultiplier = 1;
        int rem = num%1000;
        num = num/1000;
        while (rem != 0 || num !=0){
            int hundredsPlace = rem%100;
            int thousandsPlace = rem/100;
            int onesPlace = rem%10;
            int tensPlace = hundredsPlace-onesPlace;

            if (initialMultiplier>1 && rem > 0)
                stringBuilder.insert(0, " "+map.get(initialMultiplier));

            if (map.containsKey(hundredsPlace))
                stringBuilder.insert(0, " "+map.get(hundredsPlace));
            else{
                if (map.containsKey(onesPlace))
                    stringBuilder.insert(0, " "+map.get(onesPlace));
                if (map.containsKey(tensPlace))
                    stringBuilder.insert(0, " "+map.get(tensPlace));
            }

            if (map.containsKey(thousandsPlace))
                stringBuilder.insert(0, " "+map.get(thousandsPlace)+" Hundred");

            rem = num%1000;
            num = num/1000;
            initialMultiplier*= 1000;
        }
        if (stringBuilder.length()>0 && stringBuilder.charAt(0) == ' ')
            stringBuilder.deleteCharAt(0);
        return stringBuilder.toString();
    }

    /**
     * taken from here: https://leetcode.com/problems/integer-to-english-words/discuss/70647/4-ms-Java-Solution
     * it is little more polished than my solution
     * @param num
     * @return
     */
    public String numberToWords(int num) {
        if(num==0) {
            return "Zero";
        }
        return helper(num);
    }
    public String helper(int num) {
        String[] words = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
                "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        StringBuilder res = new StringBuilder();

        if(num>=1000000000) {
            res.append(helper(num/1000000000)).append(" Billion ").append(helper(num%1000000000));
        } else if(num>=1000000) {
            res.append(helper(num/1000000)).append(" Million ").append(helper(num%1000000));
        } else if(num>=1000) {
            res.append(helper(num/1000)).append(" Thousand ").append(helper(num%1000));
        } else if(num>=100) {
            res.append(helper(num/100)).append(" Hundred ").append(helper(num%100));
        } else if(num>=20) {
            res.append(words[(num-20)/10+20]).append(" ").append(words[num%10]);
        } else {
            res.append(words[num]);
        }

        return res.toString().trim();
    }

}
