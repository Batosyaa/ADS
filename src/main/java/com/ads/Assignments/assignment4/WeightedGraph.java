package com.ads.assignments.assignment4;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WeightedGraph<T> {
    private final boolean undirected;
    private final Map<Vertex<T>, Map<Vertex<T>, Double>> adjVertices = new HashMap<>();

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex v) {
        adjVertices.putIfAbsent(v, new HashMap<>());
    }

    public void addEdge(Vertex<T> from, Vertex<T> to, double weight) {
        addVertex(from);
        addVertex(to);

        adjVertices.get(from).put(to, weight);

        if(undirected) {
            adjVertices.get(to).put(from, weight);
        }
    }

    public Map<Vertex<T>, Double> getAdjacency(Vertex<T> v) {
        return adjVertices.getOrDefault(v, new HashMap<>());
    }

    public Set<Vertex<T>> getAllVertices() {
        return adjVertices.keySet();
    }
}