package com.ads.assignments.assignment_3;

import java.util.ArrayList;
import java.util.List;

import com.ads.assignments.assignment_2.MyStack;

public class MyBST<K extends Comparable<K>, V> {
    private Node root;
    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node put(Node current, K key, V val) {
        if (current == null) {
            return new Node(key, val);
        }
        int compare = key.compareTo(current.key);
        if (compare < 0) {
            current.left = put(current.left, key, val);
        }
        else if (compare > 0) {
            current.right = put(current.right, key, val);
        } else current.val = val;
        return current;
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    public V get(K key) {
        Node current = root;

        while (current != null) {
            int compare = key.compareTo(current.key);
            if (compare < 0)    current = current.left;            
            else if (compare > 0)   current = current.right;
            else    return current.val;
        }
        return null;
    }

    private Node min(Node current) {
        while (current.left != null) current = current.left;
        return current;
    }

    private Node deleteMin(Node current) {
        if (current.left == null) return current.right;
        current.left = deleteMin(current.left);
        return current;
    }

    private Node delete(Node current, K key) {
        if (current == null) return null;

        int compare = key.compareTo(current.key);
        if (compare < 0) current.left = delete(current.left, key);
        else if (compare > 0) current.right = delete(current.right, key); 
        else {
            if (current.left == null) return current.right;
            if (current.right == null) return current.left;

            Node temporary = current;
            current = min(temporary.right);
            current.right = deleteMin(temporary.right);
            current.left = temporary.left;
        }
        return current;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    public Iterable<K> iterator() {
    List<K> keys = new ArrayList<>();
    MyStack<Node> stack = new MyStack<>();
    Node current = root;

    while (current != null || !stack.isEmpty()) {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        current = stack.pop();
        keys.add(current.key);

        current = current.right;
    }

    return keys;
}
}