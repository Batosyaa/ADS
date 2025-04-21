package com.ads.assignments.assignment_2;

public class MyQueue<T> {
    private final MyLinkedList<T> list;
    
    public MyQueue() {
        list = new MyLinkedList<>();
    }
    
    // enqueue is the same as addLast in MyLinkedList
    public void enqueue(T item) {
        list.addLast(item);
    }

    // offer returns false if the item is null, otherwise enqueues the item and returns true
    public boolean offer(T item) {
        if (item == null) {
            return false;
        } else {
            list.addLast(item);
            return true;
        }
    }

    // add throws an exception if the item is null, otherwise enqueues the item
    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Failed to insert item: " + item);
        } else {
            list.addLast(item);
        }
    }

    // removes the item form the queue and returns it
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }

    // same as dequeue, but returns null if th queue is empty
    public T remove() {
        if (isEmpty()) {
            return null;
        } else {
            list.removeFirst();
        }
        return list.getFirst();
    }
    
    // poll is the sam as remove, but insted, throws an exception if the queue is empty
    public T poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        list.removeFirst();
        return list.getFirst();
    }

    // returns the first item in the queue without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        } 
        return list.getFirst();
    }

    // element is like peek, but throws an exception if the queue is empty
    public void element() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        } else {
            list.getFirst();
        }
    }
    
    // checks whether the list is empty
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

    // prints all the elements in the queue in this fromat: [1 2 3 4 5]
    public void printList() {
        Object[]array = list.toArray();
        System.out.print("[");
        for (Object array1 : array) {
            System.out.print(array1 + " ");
        }
        System.out.println("]");
    }
}
