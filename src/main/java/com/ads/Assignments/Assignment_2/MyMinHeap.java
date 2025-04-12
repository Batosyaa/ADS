package com.ads.Assignments.assignment_2;

public class MyMinHeap<T extends Comparable<T>> {
    private final MyArrayList<T> heap;
    
    public MyMinHeap() {
        heap = new MyArrayList<>();
    }
    
    public void insert(T item) {
        heap.addLast(item);
        shiftUp(heap.size() - 1);
    }
    
    public T extractMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        
        T min = heap.get(0);
        
        T lastItem = heap.getLast();
        heap.set(0, lastItem);
        heap.removeLast();
        
        if (!isEmpty()) {
            shiftDown(0);
        }
        
        return min;
    }
    
    public T findMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }
    
    public boolean isEmpty() {
        return heap.size() == 0;
    }
    
    public int size() {
        return heap.size();
    }
    
    public void clear() {
        heap.clear();
    }
    
    private void shiftUp(int index) {
        int parentIndex = getParentIndex(index);
        
        if (index > 0 && heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
            T temp = heap.get(index);
            heap.set(index, heap.get(parentIndex));
            heap.set(parentIndex, temp);
            
            shiftUp(parentIndex);
        }
    }
    
    private void shiftDown(int index) {
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);
        int smallest = index;
        
        if (leftChildIndex < heap.size() && 
            heap.get(leftChildIndex).compareTo(heap.get(smallest)) < 0) {
            smallest = leftChildIndex;
        }
        
        if (rightChildIndex < heap.size() && 
            heap.get(rightChildIndex).compareTo(heap.get(smallest)) < 0) {
            smallest = rightChildIndex;
        }
        
        if (smallest != index) {
            T temp = heap.get(index);
            heap.set(index, heap.get(smallest));
            heap.set(smallest, temp);
            shiftDown(smallest);
        }
    }
    
    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }
    
    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }
    
    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }
}