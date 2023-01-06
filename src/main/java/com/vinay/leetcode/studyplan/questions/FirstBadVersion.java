package com.vinay.leetcode.studyplan.questions;

public class FirstBadVersion {

    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        System.out.println(firstBadVersion.firstBadVersion(2126753390));
    }

    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;

        while (low != high){
            long sum = (long) low+high;
            int mid = (int) ((sum)/2);
            if (isBadVersion(mid)){
                if (mid == 1){
                    return mid;
                }
                if (mid>1 && !isBadVersion(mid-1)){
                    return mid;
                }
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    boolean isBadVersion(int version){
        if (version < 1702766719)
            return false ;
        return true;
    }
}
