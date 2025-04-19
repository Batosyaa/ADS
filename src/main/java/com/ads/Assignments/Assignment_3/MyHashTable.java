package com.ads.Assignments.Assignment_3;


public class MyHashTable<K, V> {
    
    private class HashNode {
        K key;
        V value;
        HashNode next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private final HashNode[] chainArray;
    private int M = 16;
    private int size;

    public MyHashTable() {
        chainArray = (HashNode[]) new Object[M];
        size = 0;
    }

    public MyHashTable(int M) {
        this.M = M;
        chainArray = (HashNode[]) new Object[M];
        size = 0;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7FFFFFFF) % M;
    }

    public void put(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key or value cannot be null");
        }

        int index = hash(key);

        HashNode current = chainArray[index];
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        HashNode newNode = new HashNode(key, value);
        newNode.next = chainArray[index];
        chainArray[index] = newNode;
        size++;
    }

    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int index = hash(key);
        HashNode current = chainArray[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int index = hash(key);
        HashNode current = chainArray[index];
        HashNode prev = null;

        while (current != null) {
            if (current.equals(key)) {
                V value = current .value;
            
                if (prev == null) {
                    chainArray[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                
                size--;
                return value;
            }

            prev = current;
            current = current.next;
        }
        return null;
    }

    public boolean contains(V value) {
        if (value == null) {
            return false;
        }

        for (int i = 0; i < M; i++) {
            HashNode current = chainArray[i];
            while (current != null) {
                if (current.value.equals(value)) {
                    return true;
                }
                current = current.next;
            }
        }

        return false;
    }

    public K getKey(V value) {
        if (value == null) {
            return null;
        }

        for (int i = 0; i < M; i++) {
            HashNode current = chainArray[i];
            while (current != null) {
                if (current.value.equals(value)) {
                    return current.key;
                }
                current = current.next;
            }
        }
        return null;
    }
}
