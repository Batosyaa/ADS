package com.ads.assignments.assignment_3;

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

    private Node put(Node x, K key, V val) {
        int compare = key.compareTo(key);
        if (compare < 0) {
            x.left = put(x.left, key, val);
        }
        else if (compare > 0) {
            x.right = put(x.right, key, val);
        } else x.val = val;
        return x;
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    


    
}