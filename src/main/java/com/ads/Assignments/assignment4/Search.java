package com.ads.assignments.assignment4;

import java.util.HashMap;
import java.util.Map;

public abstract class Search<V> {
    protected Map<Vertex<V>, Vertex<V>> edgeTo = new HashMap<>();
    protected Vertex<V> start;

    public Search(WeightedGraph<V> graph, Vertex<V> start) {
        this.start = start;
    }

    public abstract boolean hasPathTo(Vertex<V> vertex);

    public abstract Iterable<Vertex<V>> pathTo(Vertex<V> vertex);
}
