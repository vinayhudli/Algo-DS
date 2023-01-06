package com.vinay.leetcode.string;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> lists = groupAnagrams.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        for (List<String> l:lists){
            for (String str:l){
                System.out.println(str);
            }
            System.out.println("---------");
        }
    }

    /**
     * This approach goes through array sorts each element (which is key for map) and puts the original entry into that map
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            List<String> list = map.getOrDefault(s, new ArrayList<>());
            list.add(str);
            map.put(s, list);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry:map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }

    /**
     * This approach goes through string to one by one and each time search till end of array to find anagrams
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagramsFirstApproach(String[] strs) {
        long start = System.currentTimeMillis();
        List<List<String>> result = new ArrayList<>();
        Node[] nodes = new Node[strs.length];
        short count = 0;
        for (String str:strs){
            nodes[count] = new Node(str);
            count++;
        }

        count = 0;
        for (Node node:nodes){
            if (!node.isVisited)
                result.add(getAnagrams(count, nodes));
            count++;
        }
        return result;
    }

    private List<String> getAnagrams(short index, Node[] nodes){
        List<String> result = new ArrayList<>();
        result.add(nodes[index].val);
        char[] mainNode = nodes[index].val.toCharArray();
        Arrays.sort(mainNode);
        for (int i=index+1;i< nodes.length;i++){
            if (!nodes[i].isVisited && isAnagram(mainNode, nodes[i].val)){
                result.add(nodes[i].val);
                nodes[i].isVisited = true;
            }
        }
        return result;
    }

    private boolean isAnagram(char[] mainStr, String compareStr){
        if (mainStr.length != compareStr.length())
            return false;
        char[] compareChar = compareStr.toCharArray();
        Arrays.sort(compareChar);
        for (int i=0;i<compareChar.length;i++){
            if (compareChar[i] != mainStr[i])
                return false;
        }
        return true;
    }

    class Node{
        String val;
        boolean isVisited = false;
        public Node(String val){
            this.val = val;
        }
    }
}
