package com.vinay.leetcode.stack;

public class MinStack {

    Node head ;
    public MinStack() {

    }

    public void push(int val) {
        if (head == null)
            head = new Node(val, val, null);
        else
            head = new Node(val, Math.min(head.min, val), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    public static void main(String[] args) {
//        Queue<Player> queue = new PriorityQueue<>(Comparator.comparingInt(o->o.age));
//        queue.add(new Player(45, "Steven")) ;
//        queue.add(new Player(50, "John")) ;
//        queue.add(new Player(35, "Johnny")) ;
//        queue.add(new Player(40, "Jana")) ;
//
//        while (!queue.isEmpty()){
//            System.out.println(queue.remove());
//        }

        MinStack minStack = new MinStack();
        minStack.push(-5);
        minStack.push(-3);
        minStack.push(-4);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    class Node{
        int val ;
        int min ;
        Node next ;

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    static class Player{
        int age;
        String name;

        public Player(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
