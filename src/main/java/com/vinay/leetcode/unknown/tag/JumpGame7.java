package com.vinay.leetcode.unknown.tag;

import java.util.ArrayDeque;
import java.util.Queue;

public class JumpGame7 {

    public static void main(String[] args) {
        JumpGame7 jumpGame7 = new JumpGame7();
        System.out.println(jumpGame7.canReach("01101110"
                , 2, 3));
    }

    public boolean canReach(String s, int minJump, int maxJump) {
        char[] c = s.toCharArray();
        if (c[0] != '0' || c[c.length-1] != '0' || c.length-1<minJump)
            return false;
        Queue<Integer> queue = new ArrayDeque<>(s.length());
        int maxIndex = 0;
        queue.add(0);
        while (!queue.isEmpty()){
            Integer remove = queue.remove();
            int minJumpIndex = Math.max(remove+minJump, maxIndex+1);
            int maxJumpIndex = remove+maxJump;
            int lastIndex = maxIndex;
            for (int i=minJumpIndex;i<=maxJumpIndex && i<c.length;i++){
                if (c[i] == '0' )
                    queue.add(i);
                lastIndex = i;
            }

            maxIndex = Math.max(lastIndex, maxIndex);
        }
        return maxIndex == s.length()-1 ;
    }
}
