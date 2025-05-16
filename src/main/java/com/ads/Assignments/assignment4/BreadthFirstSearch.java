package com.ads.assignments.assignment4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch<T> {
    private final Set<T> visited = new HashSet<>();
    private final Map<T, T> edgeTo = new HashMap<>();

    public void BreadthFirstSearch(WeightedGraph<T> graph, T source) {
        Queue<T> queue = new LinkedList<>();
        visited.add(source);
        queue.add(source);

        while (!queue.isEmpty()) {
            T current = queue.poll();
            for (T neighbor : graph.getAdjacency(current).keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    edgeTo.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }

    public List<Vertex<T>> pathTo(T dest) {
        List<Vertex<T>> path = new ArrayList<>();
        if (!visited.contains(dest)) {
            return path;
        }

        for (T at = dest; at != null; at = edgeTo.get(at)) {
            path.add(new Vertex<>(at));
        }

        Collections.reverse(path);
        return path;
    }

}
