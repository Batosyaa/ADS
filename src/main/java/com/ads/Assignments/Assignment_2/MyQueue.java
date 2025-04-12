package com.ads.Assignments.assignment_2;

public class MyQueue<T> {
    private final MyLinkedList<T> list;
    
    public MyQueue() {
        list = new MyLinkedList<>();
    }
    
    public void enqueue(T item) {
        list.addLast(item);
    }
    
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }
    
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.getFirst();
    }
    
    public boolean isEmpty() {
        return list.size() == 0;
    }
    
    public int size() {
        return list.size();
    }
    
    public void clear() {
        list.clear();
    }

    public void printList() {
        Object[]array = list.toArray();
        System.out.println("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
}
