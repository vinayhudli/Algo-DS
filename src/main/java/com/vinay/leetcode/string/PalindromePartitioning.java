package com.vinay.leetcode.string;

import java.util.*;

public class PalindromePartitioning {

    Map<Integer,List<List<String>>> indexedPalindrome = new HashMap<>();

    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        List<List<String>> aab = palindromePartitioning.partition("aabb");
        for (List<String> entry: aab){
            System.out.println("new list");
            for (String str:entry){
                System.out.println(str);
            }
        }
    }

    public List<List<String>> partition(String s) {
        indexedPalindrome(s,0);
        return indexedPalindrome.get(0);
    }

    private List<List<String>> indexedPalindrome(String s, int index){
        if (indexedPalindrome.containsKey(index))
            return indexedPalindrome.get(index);
        if (index == s.length()-1){
            List<List<String>> lists = new LinkedList<>();
            List<String> list = new LinkedList<>();
            list.add(s.substring(index));
            lists.add(list);
            indexedPalindrome.put(index,lists);
            return lists;
        }else if (index == s.length()){
            List<List<String>> lists = new LinkedList<>();
            return lists;
        }

        char[] chars = s.substring(index).toCharArray();
        StringBuilder substring = new StringBuilder();
        for (int i=0;i< chars.length;i++){
            substring.append(chars[i]) ;
            String sub = substring.toString();
            if (substring.length() == 1 || isPalindrome(sub)){
                List<List<String>> lists = indexedPalindrome(s, index+i+1);
                List<List<String>> result = new LinkedList<>();
                for (List<String> entry:lists){
                    List<String> temp = new LinkedList<>(entry);
                    temp.add(0,sub);
                    result.add(temp);
                }

                if (i == chars.length-1){
                    List<String> temp = new LinkedList<>();
                    temp.add(sub);
                    result.add(temp);
                }

                if (indexedPalindrome.containsKey(index)){
                    List<List<String>> lists1 = indexedPalindrome.get(index);
                    lists1.addAll(result);
                }else {
                    indexedPalindrome.put(index, result);
                }
            }
        }

        return new LinkedList<>(indexedPalindrome.get(index));
    }


    private boolean isPalindrome(String str){
        char[] ch = str.toCharArray();
        int low = 0;
        int high = ch.length-1;
        while (low<high){
            if (ch[low] != ch[high])
                return false;
            low++;
            high--;
        }
        return true;
    }
}
