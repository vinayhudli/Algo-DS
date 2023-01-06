package com.vinay.leetcode.bfs;

import java.util.*;

public class WordLadderII {

    List<List<String>> ladders = new ArrayList<>();

    public static void main(String[] args) {
        WordLadderII wordLadderII = new WordLadderII();
        List<List<String>> ladders = wordLadderII.findLadders(
                "red",
                "tax", Arrays.asList(
                        "ted","tex","red","tax","tad", "den", "rex", "pee") );
        for (List<String> list:ladders){
            for (String str:list){
                System.out.println(str);
            }
            System.out.println("next set");
        }
    }

    /**
     * construct a tree and traverse from leaf to root
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord))
            return new ArrayList<>();
        Set<String> visitedString = new HashSet<>();
        Map<String, Set<String>> childToListOfParents = new HashMap<>();
        List<String> list = new LinkedList<>();
        list.add(beginWord);
        List<String> childList = new ArrayList<>();

        boolean found = false;
        int level = 0;
        while (!list.isEmpty()){
            String head = list.remove(0);
            List<String> indicesOfStringDifferingByOne = new ArrayList<>();
            if (!visitedString.contains(head))
                indicesOfStringDifferingByOne = getIndicesOfStringDifferingByOne(head, dict, childToListOfParents);

            visitedString.add(head);
            for (String s : indicesOfStringDifferingByOne) {
                if (s.compareToIgnoreCase(beginWord) == 0)
                    continue;

                childList.add(s);
                if (!found && s.compareToIgnoreCase(endWord) == 0)
                    found = true;
            }

            if (list.isEmpty()){
                level++;
                if (found)
                    break;
                list = childList;
                childList = new ArrayList<>();
            }
        }
        LinkedHashSet<String> currentList = new LinkedHashSet<>();
        currentList.add(endWord);
//        System.out.println("level : "+level);
        dfs(childToListOfParents, level+1, currentList, beginWord, endWord);
        return ladders;
    }

    private void dfs(Map<String, Set<String>> tree, int level, LinkedHashSet<String> currentList, String beginWord, String s){
        level--;
//        System.out.println("dfs : "+s);
        if (level == 0 && s.compareToIgnoreCase(beginWord) == 0) {
            List<String> tempList = new LinkedList<>();
            for (String entry:currentList)
                tempList.add(0, entry);
            ladders.add(tempList);
            return;
        }
        if (level == 0)
            return;

        Set<String> child = tree.get(s);
        if (child == null)
            return;
        for (String entry: child){
//            System.out.println("child : "+entry);
            if (currentList.contains(entry))
                continue;
            currentList.add(entry);
            dfs(tree, level, currentList, beginWord, entry);
            currentList.remove(entry);
        }
    }

    String[] alphabets = new String[]{"a","b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> getIndicesOfStringDifferingByOne(String str, Set<String> wordList, Map<String, Set<String>> childToListOfParents){
        List<String> indices = new ArrayList<>();
        int length = str.length();
//        System.out.println("word : "+str);
        Set<String> parents = childToListOfParents.getOrDefault(str, new HashSet<>());
        for (int k=0;k< alphabets.length;k++) {
            for (int i = 0; i < length; i++) {
                String sub = str.substring(0, i) + alphabets[k] + str.substring(i + 1);
                    if (wordList.contains(sub) && !parents.contains(sub)) {
//                    System.out.println(word);
                        indices.add(sub);
                        Set<String> orDefault = childToListOfParents.getOrDefault(sub, new HashSet<>());
                        orDefault.add(str);
                        childToListOfParents.put(sub, orDefault);
                    }
                }
        }
        return indices;
    }
}
