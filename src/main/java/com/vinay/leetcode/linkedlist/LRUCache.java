package com.vinay.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,0);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        list.first = new Node();
        list.last = new Node();

        list.first.next = list.last;
        list.last.previous = list.first;
    }

//    main thing is to make the head and tail as separate empty nodes to avoid checking for nulls etc
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        Node node = map.get(key);
        list.removeNode(node);
        list.insertNode(list.first, list.first.next, node);
        return map.get(key).value;
    }

    public void put(int key, int value) {
//        System.out.println("map size: "+map.size());
        if (!map.containsKey(key) && map.size() == capacity){
            Node leastRecentlyUsed = list.last.previous;
//            System.out.println("capacity reached : "+leastRecentlyUsed.value);
            list.removeNode(leastRecentlyUsed);
            map.remove(leastRecentlyUsed.key);
        }

        Node node = new Node();
        if (map.containsKey(key)){
            node = map.get(key);
            list.removeNode(node);
        }
        node.value = value;
        node.key = key;
        map.put(key, node);

        list.insertNode(list.first, list.first.next, node);
    }

    List list = new List();
    Map<Integer, Node> map = new HashMap<>();
    int capacity;

    class Node{
        int value;
        int key;
        Node next;
        Node previous;
    }

    class List{
        Node first;
        Node last;

        public void insertNode(Node leftNode, Node rightNode, Node node){
            node.next = rightNode;
            node.previous = leftNode;
            leftNode.next = node;
            rightNode.previous = node;

        }

        public void removeNode(Node node){
            Node previousNode = node.previous;
            Node nextNode = node.next;
            previousNode.next = nextNode;
            nextNode.previous = previousNode;
        }
    }
}
