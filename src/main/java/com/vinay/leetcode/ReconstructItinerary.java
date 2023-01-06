package com.vinay.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/reconstruct-itinerary/
 */
public class ReconstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> map = new HashMap<>();
        for (int i=0;i< tickets.size();i++){
            String from = tickets.get(i).get(0);
            String to = tickets.get(i).get(1);
            map.putIfAbsent(from, new ArrayDeque<>());
            Queue<String> orDefault = map.get(from);
            orDefault.add(to);
        }

        Queue<String> jfk = map.get("JFK");
        for (String str:jfk){

        }
        return null;
    }

    List<String> itinerary = new ArrayList<>();
    private void iterateAirport(int count, Map<String, Queue<String>> map, String nextStation, int numberOfEdges, StringBuilder stringBuilder){
        if (count == numberOfEdges && nextStation == null){

        }

    }
}
