package com.vinay.leetcode.string;

import java.util.*;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {

    public static void main(String[] args) {
        MinimumDeletionsToMakeCharacterFrequenciesUnique minimumDeletionsToMakeCharacterFrequenciesUnique = new MinimumDeletionsToMakeCharacterFrequenciesUnique();
        System.out.println(minimumDeletionsToMakeCharacterFrequenciesUnique.minDeletions("abcddecefhgggffhhh"));
    }

    /**
     * my original solution, it is in 5 percentile
     * @param s
     * @return
     */
    public int minDeletionsFirstAttempt(String s) {

        Map<Character, Integer> stringToCount = new HashMap<>();
        Map<Integer, Integer> countToNumberOfCharacters = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int diff = o1-o2;
                if (diff != 0) return -1*diff;
                return 0;
            }
        });
        char[] chars = s.toCharArray();
        int maxCount = 1;
        for (int i=0;i< chars.length;i++){
            Integer toCountOrDefault = stringToCount.getOrDefault(chars[i], 0) + 1;
            stringToCount.put(chars[i], toCountOrDefault);
            if (toCountOrDefault > 1){
                countToNumberOfCharacters.compute(toCountOrDefault-1, (key, value)->value-1);
            }
            int numOfCharacters = countToNumberOfCharacters.getOrDefault(toCountOrDefault, 0)+1;
            countToNumberOfCharacters.put(toCountOrDefault, numOfCharacters);
            maxCount = Math.max(maxCount, toCountOrDefault);
        }

        int numberOfChanges = 0;

        for (Map.Entry<Integer, Integer> entry: countToNumberOfCharacters.entrySet()){
//            System.out.println("key : "+entry.getKey()+" value: "+entry.getValue());
            int occurences = entry.getValue();
            if (occurences <= 1)
                continue;
            int changes = occurences-1;
            numberOfChanges += changes;
            if (entry.getKey()>1) {
                int newChanges = countToNumberOfCharacters.getOrDefault(entry.getKey() - 1, 0)+changes;
                countToNumberOfCharacters.put(entry.getKey()-1, newChanges);
            }
        }

        return numberOfChanges;
    }

    /**
     * this was taken from leetcode discussions.
     * @param s
     * @return
     */
    public int minDeletions(String s) {

        Map<Character, Integer> stringToCount = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i=0;i< chars.length;i++)
            stringToCount.put(chars[i], stringToCount.getOrDefault(chars[i], 0) + 1);

        int numberOfChanges = 0;
        Set<Integer> occurenceList = new HashSet<>();
        for (Map.Entry<Character, Integer> entry: stringToCount.entrySet()){
            int occurences = entry.getValue();
            while (occurenceList.contains(occurences)){
                numberOfChanges++;
                occurences--;
            }
            if (occurences > 0)
                occurenceList.add(occurences);
        }

        return numberOfChanges;
    }
}
