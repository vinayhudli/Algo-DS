package com.vinay.leetcode.twopointer;

public class ReverseWordsInAString {

    public static void main(String[] args) {
        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
        System.out.println(reverseWordsInAString.reverseWords("a good   example"));
    }

    public String reverseWordsOriginalSoln(String s) {
        s = s.trim();
        String[] split = s.split(" ");
        StringBuilder str = new StringBuilder();
        for (int i= split.length-1;i>=0;i--){
            if (!split[i].isEmpty())
                str.append(" ").append(split[i]);
        }
        if (str.length()>0)
            str.deleteCharAt(0);
        return str.toString();
    }

    /**
     * Simple and effective logic:
     * https://leetcode.com/problems/reverse-words-in-a-string/discuss/47720/Clean-Java-two-pointers-solution-(no-trim(-)-no-split(-)-no-StringBuilder)
     * @param s
     * @return
     */
    public String reverseWords(String s){
        char[] chars = s.toCharArray();
        reverseWholeString(chars, 0, chars.length-1);
        return reverseIndividualWords(chars);
    }

    private String reverseIndividualWords(char[] chars){
        int i=0, j=0, l=0;
        int numberOfWords = 0;
        while (i< chars.length && j< chars.length){
            while (i< chars.length && chars[i] == ' ') i++;
            if (i == chars.length)
                break;

            if (numberOfWords > 0)
                chars[j++] = ' ';

            l = j;
            while (i < chars.length && chars[i] != ' ')
                chars[j++] = chars[i++];

            reverseWholeString(chars, l, j-1);
            numberOfWords++;
        }

        return String.valueOf(chars, 0, j);
    }
    private void reverseWholeString(char[] chars, int i, int j){
        while (i<j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }
}
