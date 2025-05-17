package com.ads.assignments.assignment4;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WeightedGraph<T> {
    private final boolean undirected;
    private final Map<T, Vertex<T>> adjList = new HashMap<>();

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(T data) {
        adjList.put(data, new Vertex<>(data));
    }

    public void addEdge(T from, T to, double weight) {
        if (!hasVertex(from)) {
            addVertex(from);
        }

        if (!hasVertex(to)) {
            addVertex(to);
        }

        if (from.equals(to)) return;

        if (hasEdge(from, to)) return;

        adjList.get(from).addNeighbor(to, weight);

        if (undirected) {
            adjList.get(to).addNeighbor(from, weight);
        }
    }

    public boolean hasVertex(T data) {
        return adjList.containsKey(data);
    }

    public boolean hasEdge(T from, T to) {
        return adjList.containsKey(from) &&
                adjList.get(from).getAdjacentVertices().containsKey(to);
    }

    public Map<T, Double> getAdjacency(T current) {
        return adjList.get(current).getAdjacentVertices();
    }

    public Set<T> getAllVertices() {
        return Set.copyOf(adjList.keySet());
    }

    public Map<T, Double> getNeighbors(T vertex, Vertex<T> source) {
        return adjList.getOrDefault(vertex, source).getAdjacentVertices();
    }

    public Vertex<T> getVertex(T key) {
        return adjList.get(key);
    }
}
