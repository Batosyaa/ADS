package com.ads.assignments.assignment4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkstraSearch<T> {
    private final Map<T, Double> distance = new HashMap<>();
    private final Map<T, T> edgeTo = new HashMap<>();
    private final Set<T> visited = new HashSet<>();

    public void dijkstra(WeightedGraph<T> graph, T source) {
        PriorityQueue<T> pq = new PriorityQueue<>(Comparator.comparingDouble(distance::get));
        for (T v : graph.getAllVertices()) {
            distance.put(v, Double.MAX_VALUE);
        }

        distance.put(source, 0.0);
        pq.add(source);

        while (!pq.isEmpty()) {
            T current = pq.poll();
            if (visited.contains(current)) continue;
            visited.add(current);

            for (Map.Entry<T, Double> neighbor : graph.getAdjacency(current).entrySet()) {
                double newDist = distance.get(current) + neighbor.getValue();
                if (newDist < distance.get(neighbor.getKey())) {
                    distance.put(neighbor.getKey(), newDist);
                    edgeTo.put(neighbor.getKey(), current);
                    pq.add(neighbor.getKey());
                }
            }
        }
    }

    public List<T> pathTo(T dest) {
        List<T> path = new ArrayList<>();
        if (!distance.containsKey(dest)) return path;

        for (T at = dest; at != null; at = edgeTo.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    public double getDistance(Vertex<T> v) {
        return distance.getOrDefault(v, Double.MAX_VALUE);
    }
}
