package com.ads.assignments.assignment_2;
public class main {
    public static void main(String[] args) {
        MyQueue<Integer> TestQueue = new MyQueue<>();
        TestQueue.enqueue(1);

        TestQueue.printList();
        boolean check = TestQueue.isEmpty();
        System.out.println("Is the queue empty? " + check);
        TestQueue.enqueue(2);
        TestQueue.enqueue(3);
        TestQueue.enqueue(4);
        TestQueue.enqueue(5);
        TestQueue.peek();
        System.out.println("Peeked value: " + TestQueue.peek());
    }
}
