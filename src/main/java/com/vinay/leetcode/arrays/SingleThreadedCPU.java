package com.vinay.leetcode.arrays;

import java.util.*;

public class SingleThreadedCPU {

    public static void main(String[] args) {
        SingleThreadedCPU singleThreadedCPU = new SingleThreadedCPU();
        int[] order = singleThreadedCPU.getOrder(new int[][]{{7,10},{7,12},{7,5},{7,4},{7,2}});
        for (int i=0;i< order.length;i++)
            System.out.println(order[i]);
    }


    public int[] getOrder(int[][] tasks) {

        int[][] newTasks = new int[tasks.length][3];

        for (int i=0;i<tasks.length;i++){
            newTasks[i][0] = tasks[i][0];
            newTasks[i][1] = tasks[i][1];
            newTasks[i][2] = i;
        }

        Arrays.sort(newTasks, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0])
                    return 0;
                else
                    return o1[0]>o2[0]?1:-1;
            }
        });

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1])
                return o1[1]>o2[1]?1:-1;
            else
                return o1[2]>o2[2]?1:-1;
        }) ;
        int[] order = new int[tasks.length];
        int current = newTasks[0][0];
        int taskIndex = 0;
        int orderIndex = 0;
        while (taskIndex<tasks.length){
            if (newTasks[taskIndex][0] <= current || priorityQueue.isEmpty()){
                priorityQueue.offer(newTasks[taskIndex]);
                taskIndex++;
            }else {
                int[] poll = priorityQueue.poll();
                order[orderIndex++] = poll[2];
                current = Math.max(current+poll[1], poll[0]+poll[1]);
            }
        }

        while (!priorityQueue.isEmpty()){
            order[orderIndex++] = priorityQueue.poll()[2];
        }

        return order;
    }

}
