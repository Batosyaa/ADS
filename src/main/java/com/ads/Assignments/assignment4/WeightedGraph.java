package com.ads.assignments.assignment4;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WeightedGraph<T> {
    private final boolean undirected;
    private final Map<T, Vertex<T>> adjVertices = new HashMap<>();

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(T data) {
        adjVertices.put(data, new Vertex<>(data));
    }

    public void addEdge(T from, T to, double weight) {
        if (!hasVertex(from)) {
            addVertex(from);
        }

        if (!hasVertex(to)) {
            addVertex(to);
        }

        // handle parallels and self-loops
        
        adjVertices.get(from).addNeighbor(to, weight);

        if(undirected) {
            adjVertices.get(to).addNeighbor(from, weight);
        }
    }

    public boolean hasVertex(T data) {
        return adjVertices.containsKey(data);
    }

    public boolean hasEdge(T from, T to) {
        return adjVertices.containsKey(from) && adjVertices.containsKey(to);
    }

    public Map<T, Double> getAdjacency(T current) {
        return adjVertices.get((T) current).getAdjacentVertices();
    }

    public Set<T> getAllVertices() {
        return Set.copyOf(adjVertices.keySet());
    }
}