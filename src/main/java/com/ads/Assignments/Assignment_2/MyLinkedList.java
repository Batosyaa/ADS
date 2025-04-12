package com.ads.Assignments.assignment_2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T> {
    
    private class MyNode {
        T element;
        MyNode next;
        MyNode prev;
        
        public MyNode(T element, MyNode prev, MyNode next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
    
    private MyNode head;
    private MyNode tail;
    private int size;
    
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    @Override
    public int size() {
        return size;
    }
    
    @Override
    public void add(T item) {
        addLast(item); // I guess they act the same
    }
    
    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        getNodeAt(index).element = item;
    }
    
    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            MyNode current = getNodeAt(index);
            MyNode newNode = new MyNode(item, current.prev, current);
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }
    
    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item, null, head);
        
        if (head != null) {
            head.prev = newNode;
        } else {
            tail = newNode;
        }
        
        head = newNode;
        size++;
    }
    
    @Override
    public void addLast(T item) {
        MyNode newNode = new MyNode(item, tail, null);
        
        if (tail != null) {
            tail.next = newNode;
        } else {
            // List was empty, new node is also head
            head = newNode;
        }
        
        tail = newNode;
        size++;
    }
    
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        return getNodeAt(index).element;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return head.element;
    }
    
    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return tail.element;
    }
    
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            MyNode nodeToRemove = getNodeAt(index);
            nodeToRemove.prev.next = nodeToRemove.next;
            nodeToRemove.next.prev = nodeToRemove.prev;
            
            nodeToRemove.prev = null;
            nodeToRemove.next = null;
            
            size--;
        }
    }
    
    @Override
    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        
        size--;
    }
    
    @Override
    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        
        size--;
    }
    
    @Override
    public void sort() {
        if (size <= 1) return;
        
        Object[] array = toArray();
        
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (compare(array[j], array[j + 1]) > 0) {
                    Object temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        
        clear();
        for (Object item : array) {
            @SuppressWarnings("unchecked")
            T element = (T) item;
            addLast(element);
        }
    }
    
    @SuppressWarnings("unchecked")
    private int compare(Object a, Object b) {
        if (a == null && b == null) return 0;
        if (a == null) return -1;
        if (b == null) return 1;
        
        if (a instanceof Comparable) {
            return ((Comparable<Object>) a).compareTo(b);
        }
        

        return a.toString().compareTo(b.toString());
    }
    
    @Override
    public int indexOf(Object object) {
        MyNode current = head;
        int index = 0;
        
        while (current != null) {
            if (object == null ? current.element == null : object.equals(current.element)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
    
    @Override
    public int lastIndexOf(Object object) {
        MyNode current = tail;
        int index = size - 1;
        
        while (current != null) {
            if (object == null ? current.element == null : object.equals(current.element)) {
                return index;
            }
            current = current.prev;
            index--;
        }
        
        return -1;
    }
    
    @Override
    public boolean exists(Object object) {
        return indexOf(object) >= 0;
    }
    
    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (MyNode current = head; current != null; current = current.next) {
            result[i++] = current.element;
        }
        return result;
    }
    
    @Override
    public void clear() {
        MyNode current = head;
        while (current != null) {
            MyNode next = current.next;
            current.prev = null;
            current.next = null;
            current.element = null;
            current = next;
        }
        
        head = null;
        tail = null;
        size = 0;
    }
    
    private MyNode getNodeAt(int index) {
        MyNode current;
        
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        
        return current;
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode current = head;
            
            @Override
            public boolean hasNext() {
                return current != null;
            }
            
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                
                T element = current.element;
                current = current.next;
                return element;
            }
        };
    }
}