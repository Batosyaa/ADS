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
    private final Map<Vertex<T>, Double> distance = new HashMap<>();
    private final Map<Vertex<T>, Vertex<T>> edgeTo = new HashMap<>();
    private final Set<Vertex<T>> visited = new HashSet<>();

    public void dijkstra(WeightedGraph<T> graph, Vertex<T> source) {
        PriorityQueue<Vertex<T>> pq = new PriorityQueue<>(Comparator.comparingDouble(distance::get));
        for (Vertex<T> v : graph.getAllVertices()) {
            distance.put(v, Double.MAX_VALUE);
        }

        distance.put(source, 0.0);
        pq.add(source);

        while (!pq.isEmpty()) {
            Vertex<T> current = pq.poll();
            if (visited.contains(current)) continue;
            visited.add(current);

            for (Map.Entry<Vertex<T>, Double> neighbor : graph.getAdjacency(current).entrySet()) {
                double newDist = distance.get(current) + neighbor.getValue();
                if (newDist < distance.get(neighbor.getKey())) {
                    distance.put(neighbor.getKey(), newDist);
                    edgeTo.put(neighbor.getKey(), current);
                    pq.add(neighbor.getKey());
                }
            }
        }
    }

    public List<Vertex<T>> pathTo(Vertex<T> dest) {
        List<Vertex<T>> path = new ArrayList<>();
        if (!distance.containsKey(dest)) return path;

        for (Vertex<T> at = dest; at != null; at = edgeTo.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    public double getDistance(Vertex<T> v) {
        return distance.getOrDefault(v, Double.MAX_VALUE);
    }
}
