package com.ads.assignments.assignment4;

import java.util.*;

public class WeightedGraph<V> {
    private final Set<Vertex<V>> vertices = new HashSet<>();

    public void addVertex(V data) {
        vertices.add(new Vertex<>(data));
    }

    public void addEdge(V source, V destination, double weight) {
        Vertex<V> sourceVertex = findVertex(source);
        Vertex<V> destinationVertex = findVertex(destination);

        if (sourceVertex != null && destinationVertex != null) {
            sourceVertex.addAdjacentVertex(destinationVertex, weight);
            destinationVertex.addAdjacentVertex(sourceVertex, weight);
        }
    }

    public Set<Vertex<V>> getVertices() {
        return vertices;
    }
}
