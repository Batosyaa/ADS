package com.ads.assignments.assignment4;

import java.util.*;

public class DijkstraSearch<T> extends Search<T> {
    private final Map<T, Double> distance = new HashMap<>();
    private final Set<T> visited = new HashSet<>();

    public DijkstraSearch(WeightedGraph<T> graph, T source) {
        super(source);
        dijkstra(graph, source);
    }

    private void dijkstra(WeightedGraph<T> graph, T source) {
        PriorityQueue<T> pq = new PriorityQueue<>(Comparator.comparingDouble(distance::get));

        for (T vertex : graph.getAllVertices()) {
            distance.put(vertex, Double.MAX_VALUE);
        }

        distance.put(source, 0.0);
        pq.add(source);

        while (!pq.isEmpty()) {
            T current = pq.poll();
            if (visited.contains(current)) continue;
            visited.add(current);

            Vertex<T> currentVertex = graph.getVertex(current);
            for (Map.Entry<T, Double> neighbor : graph.getNeighbors(current, currentVertex).entrySet()) {
                T neighborVertex = neighbor.getKey();
                double weight = neighbor.getValue();
                double newDist = distance.get(current) + weight;

                if (newDist < distance.get(neighborVertex)) {
                    distance.put(neighborVertex, newDist);
                    edgeTo.put(neighborVertex, current); // from Search<T>
                    pq.add(neighborVertex);
                }
            }
        }
    }

    @Override
    public List<T> pathTo(T dest) {
        List<T> path = new ArrayList<>();

        if (!hasPathTo(dest)) return path;

        for (T at = dest; at != null; at = edgeTo.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    public double getDistance(T v) {
        return distance.getOrDefault(v, Double.MAX_VALUE);
    }

    @Override
    public boolean hasPathTo(T v) {
        return distance.containsKey(v) && distance.get(v) != Double.MAX_VALUE;
    }
}
