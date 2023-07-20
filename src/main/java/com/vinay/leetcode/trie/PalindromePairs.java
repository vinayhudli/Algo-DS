package com.vinay.leetcode.trie;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/palindrome-pairs/description/
Description:
Store each word in Trie in reverse fashion, and iterate through the array and compare against the trie to see if they are palindrome.
Soln: https://leetcode.com/problems/palindrome-pairs/solutions/79195/o-n-k-2-java-solution-with-trie-structure/
 */
public class PalindromePairs {

    public static void main(String[] args) {
        PalindromePairs palindromePairs = new PalindromePairs();
        List<List<Integer>> lists = palindromePairs.palindromePairs(new String[]{"a","b","c","ab","ac","aa"});
        for (List<Integer> l:lists){
            System.out.println(l.get(0)+"-"+l.get(1));
        }
    }

    class TrieNode{
//        storing words in reverse fashion character by character
        TrieNode[] nodes;

//        index to mark the end of word, to make sure the same word is not added palindrome pair
        int index;

//        word indices that are palindrome after the current character
        List<Integer> indices;

        public TrieNode() {
            this.nodes = new TrieNode[26];
            index = -1;
            indices = new ArrayList<>();
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode root = new TrieNode();
        for (int i=0;i< words.length;i++)
            addNode(root, words[i], i);

        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i< words.length; i++)
            result.addAll(searchPalindromes(words[i], root, i));

        return result;
    }


    private void addNode(TrieNode root, String word, int index){
        TrieNode parent = root;
        for (int i =word.length()-1; i>=0; i--){
            char c = word.charAt(i);
            if (parent.nodes[c-'a'] == null){
                parent.nodes[c-'a'] = new TrieNode();
            }
//            check if the word is palindrome after the current index,
//            this is to avoid checking if the rest of the word is palindrome if the string being compared to is smaller than word in trie
            if (isPalindrome(word.substring(0, i+1)))
                parent.indices.add(index);
            parent = parent.nodes[c-'a'];
        }
        parent.indices.add(index);
        parent.index = index;
    }

    private List<List<Integer>> searchPalindromes(String word, TrieNode root, int index){
        TrieNode parent = root;
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i < word.length(); i++){
            if (parent.index >= 0 && parent.index != index && isPalindrome(word.substring(i)))
                result.add(List.of(index, parent.index));
            char c = word.charAt(i);
            if (parent.nodes[c-'a'] == null)
                return result;
            parent = parent.nodes[c-'a'];
        }

        for (Integer idx : parent.indices) {
            if (index == idx)
                continue;
            result.add(List.of(index, idx));
        }

        return result;
    }

    private boolean isPalindrome(String str){
        int low = 0, high = str.length()-1;
        while (low<high){
            if (str.charAt(low) != str.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }

}
