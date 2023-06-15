package com.vinay.leetcode.binarysearch;

import java.util.*;

/*

 */
public class TimeBasedKeyValueStore {

    Map<String, List<TimeEntry>> map = new HashMap<>();
    Map<String, TreeSet<TimeEntry>> treeMap = new HashMap<>();

    public TimeBasedKeyValueStore() {
    }

    public void set1(String key, String value, int timestamp) {
        List<TimeEntry> timeEntries = map.getOrDefault(key, new ArrayList<>());
        timeEntries.add(new TimeEntry(value, timestamp));
        map.put(key, timeEntries);
    }


    public void set(String key, String value, int timestamp) {
        TreeSet<TimeEntry> timeEntries = treeMap.getOrDefault(key, new TreeSet<>(Comparator.comparingInt(o->o.timestamp)));
        timeEntries.add(new TimeEntry(value, timestamp));
        treeMap.put(key, timeEntries);
    }

    public String get(String key, int timestamp) {
        TreeSet<TimeEntry> timeStampToVal = treeMap.get(key);
        if (timeStampToVal == null)
            return "";
        TimeEntry floor = timeStampToVal.floor(new TimeEntry("", timestamp));
        return floor == null? "":floor.value;
    }

    public String get1(String key, int timestamp) {
        List<TimeEntry> list = map.get(key);
        int maxTimestamp = -1;
        int low = 0;
        int high = list == null?-1:list.size()-1;
        String value="";
        while (low <= high){
            int mid = (low+high)/2;
            TimeEntry midEntry = list.get(mid);
            if (midEntry.timestamp == timestamp)
                return midEntry.value;
            else if (midEntry.timestamp<timestamp) {
                low = mid + 1;
                if (maxTimestamp < midEntry.timestamp)
                    value = midEntry.value;
            }else {
                high = mid - 1;
            }
        }
        return value;
    }

    private void addIntoSortedList(List<TimeEntry> list, TimeEntry entry){
        if (list.isEmpty()) {
            list.add(entry);
            return;
        }
        int low =0, high = list.size()-1;
        while (low<=high){
            int mid = (low+high)/2;
            TimeEntry midEntry = list.get(mid);
            if (midEntry.timestamp <= entry.timestamp){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        list.add(low, entry);
    }

    class TimeEntry{
        String value;
        int timestamp;

        public TimeEntry(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
