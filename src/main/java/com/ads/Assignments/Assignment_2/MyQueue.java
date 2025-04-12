package com.ads.Assignments.assignment_2;

public class MyQueue<T> {
    private final MyLinkedList<T> list;
    
    public MyQueue() {
        list = new MyLinkedList<>();
    }
    
    public void enqueue(T item) {
        list.addLast(item);
    }

    public boolean offer(T item) {
        if (item == null) {
            return false;
        } else {
            list.addLast(item);
            return true;
        }
    }

    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Failed to insert item: " + item);
        } else {
            list.addLast(item);
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }

    public T remove() {
        if (isEmpty()) {
            return null;
        } else {
            list.removeFirst();
        }
        return list.getFirst();
    }
    
    public T poll() {
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

    public void element() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        } else {
            list.getFirst();
        }
    }
    
    public boolean isEmpty() {
        boolean answ = list.size() == 0;
        return answ;
    }
    
    public int size() {
        return list.size();
    }
    
    public void clear() {
        list.clear();
    }

    public void printList() {
        Object[]array = list.toArray();
        System.out.print("[");
        for (Object array1 : array) {
            System.out.print(array1 + " ");
        }
        System.out.println("]");
    }
}
