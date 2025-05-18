package com.ads.assignments.assignment4;

import java.util.*;

public class UnweightedGraph<T> {
    private final boolean undirected;
    private final Map<T, List<T>> map = new HashMap<>();

    public UnweightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(T v) {
        map.putIfAbsent(v, new LinkedList<>());
    }

    public void addEdge(T source, T dest) {
        addVertex(source);
        addVertex(dest);

        if (source.equals(dest)) return;
        if (map.get(source).contains(dest)) return;

        map.get(source).add(dest);

        if (undirected) {
            map.get(dest).add(source);
        }
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (List<T> neighbors : map.values()) {
            count += neighbors.size();
        }

        return undirected ? count / 2 : count;
    }

    public boolean hasVertex(T v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(T source, T dest) {
        return hasVertex(source) && map.get(source).contains(dest);
    }

    public List<T> adjacencyList(T v) {
        return map.getOrDefault(v, new LinkedList<>());
    }

    public Set<T> getAllVertices() {
        return map.keySet();
    }
}
