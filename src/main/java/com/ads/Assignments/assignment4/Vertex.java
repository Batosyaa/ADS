package com.ads.assignments.assignment4;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Vertex<T> {
    private final T data;
    private final Map<Vertex<T>, Double> adjacentVertices;

    public Vertex(T data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }  
    
    public T getData() {
        return data;
    }

    public void addNeighbor(Vertex<T> neighbor, double weight) {
        if (adjacentVertices.containsKey(neighbor)) {
            double currentWeight = adjacentVertices.get(neighbor);
            if (weight < currentWeight) {
                adjacentVertices.put(neighbor, weight);
            }
        } else {
            adjacentVertices.put(neighbor, weight);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex<?>)) return false;

        Vertex<?> vertex = (Vertex<?>) o;

        return data != null ? data.equals(vertex.data) : vertex.data == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}