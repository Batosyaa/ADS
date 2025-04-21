package com.ads.assignments.assignment_2;


// This class is for the Stack API with main functions for the stack

public class MyStack<T> {
    private final MyArrayList<T> list;
    
    public MyStack() {
        list = new MyArrayList<>();
    }
    
    public void push(T item) {
        list.addLast(item);
    } // adds the element to the end of the list
    
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T item = list.getLast();
        list.removeLast();
        return item;
    } // pop removes the last element from the list and also returns it
    
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.getLast();
    } // returns the last element of the list without removing it
    
    public boolean isEmpty() {
        return list.size() == 0;
    } // checks whether the list is empty or not
    
    public int size() {
        return list.size();
    } // for the stack size
    
    public void clear() {
        list.clear();
    } // clears everything in the list
}