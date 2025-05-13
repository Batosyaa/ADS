package com.ads.assignments.assignment4;

import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class BreadthFirstSearch<V> extends Search<V> {
    private Map<Vertex<V>, Boolean> visited = new HashMap<>();

    public BreadthFirstSearch(WeightedGraph<V> graph, Vertex<V> start) {
        super(graph, start);
        bfs(graph, start);
    }

    private void bfs(WeightedGraph<V> graph, Vertex<V> start) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(start);
        visited.put(start, true);

        while(!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (!visited.containsKey(neighbor)) {
                    edgeTo.put(neighbor, current);
                    visited.put(neighbor, true);
                    queue.add(neighbor);
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(Vertex<V> vertex) {
        return visited.containsKey(vertex);
    }

    

}
