package com.vinay.takeuforwardsheet;

import java.util.*;

/*
https://takeuforward.org/data-structure/n-meetings-in-one-room/
 */
public class Nmeetingsinoneroom {

    public static void main(String[] args) {
        List<Integer> list = maximumMeetings(new int[]{1, 3, 0, 5, 8, 5}, new int[]{9, 4, 8, 7, 9, 9});
        list.forEach(System.out::println);
    }

    public static List<Integer> maximumMeetings(int[] start, int[] end) {
        Queue<Meeting> meetingQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.end != o2.end)
                return o1.end - o2.end;
            else
                return o1.start - o2.start;
        });

        for (int i =0;i< start.length;i++){
            Meeting meeting = new Meeting();
            meeting.start = start[i];
            meeting.end = end[i];
            meeting.index = i;
            meetingQueue.add(meeting);
        }
        List<Integer> result = new ArrayList<>();
        int previousMeetingEnd = -1;
        for (int i=0;i< start.length;i++){
            Meeting remove = meetingQueue.poll();
            if (remove.start > previousMeetingEnd){
                result.add(remove.index);
                previousMeetingEnd = remove.end;
            }
        }
        return result;
    }

   static class Meeting{
        int start;
        int end;
        int index;
    }
}
