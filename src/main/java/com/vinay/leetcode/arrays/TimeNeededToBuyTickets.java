package com.vinay.leetcode.arrays;

public class TimeNeededToBuyTickets {

    public int timeRequiredToBuy(int[] tickets, int k) {
        int time=0;

        int target=tickets[k];
        for(int i=0;i<=k;i++)
            time+=Math.min(tickets[i],target);

        target--;
        for(int i=k+1;i<tickets.length;i++)
            time+=Math.min(tickets[i],target);
        return time;
    }
}
