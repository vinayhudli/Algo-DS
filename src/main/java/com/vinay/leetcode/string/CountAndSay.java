package com.vinay.leetcode.string;

public class CountAndSay {

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(4));
    }

    public String countAndSay(int n) {
        if (n == 1)
            return "1";

        String str = countAndSay(n-1);
        char[] chars = str.toCharArray();
        int count = 1;
        char currentChar = chars[0];
        StringBuilder result = new StringBuilder();
        for (int i=1;i<chars.length;i++){
            if (currentChar == chars[i])
                count++;
            else {
                result.append(count).append(currentChar);
                count = 1;
                currentChar = chars[i];
            }
        }
        result.append(count).append(currentChar);
        return result.toString();
    }

}
