package com.vinay.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindKClosestElements {

    public static void main(String[] args) {
        FindKClosestElements findKClosestElements = new FindKClosestElements();
        List<Integer> closestElements = findKClosestElements.findClosestElements(new int[]{-20, -19, -18, -16, -14, -13}, 2, -16);
        closestElements.forEach(System.out::println);
    }

    /*
    This solution was taken from here: https://leetcode.com/problems/find-k-closest-elements/discuss/106426/JavaC%2B%2BPython-Binary-Search-O(log(N-K)-%2B-K)
     */
    public List<Integer> findClosestElements(int[] A, int k, int x){
        int left = 0, right = A.length - k;
        while (left < right) {
            int mid = (left + right) / 2;
//            interesting line
            if (x - A[mid] > A[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }
        return Arrays.stream(A, left, left + k).boxed().collect(Collectors.toList());
    }

    /*
    my original solution
     */
    public List<Integer> findClosestElementsAnother(int[] arr, int k, int x) {
        List<Entry> entries = new ArrayList<>();

        if (k == arr.length)
            return Arrays.stream(arr).boxed().collect(Collectors.toList());

        for (int i=0;i< arr.length;i++){
            insertIntoList(entries, arr[i], Math.abs(x-arr[i]) );
        }
        List<Integer> result = new ArrayList<>();
        int count = 0;
        for (int i=0;i<entries.size();i++){
            Entry entry = entries.get(i);
            result.add(entry.originalElement);
            count++;
            if (count == k)
                break;
        }
        Collections.sort(result);
        return result;
    }

    private void insertIntoList(List<Entry> entries, int element, int diff){
        int low = 0,high = entries.size()-1;
        int insert = 0;
        while (low<=high){
            int mid = (low+high)/2;
            Entry entry = entries.get(mid);
            if (entry.diff < diff || entry.diff == diff) {
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        insert = high+1;
        while (insert < entries.size()){
            Entry entry = entries.get(insert);
            if (entry.diff == diff)
                insert++;
            else
                break;
        }

        Entry entry = new Entry();
        entry.diff = diff;
        entry.originalElement = element;
        if (insert == entries.size()){
            entries.add(entry);
        }else {
            entries.add(insert, entry);
        }
    }

    class Entry{
        int diff;
        int originalElement;
    }
}
