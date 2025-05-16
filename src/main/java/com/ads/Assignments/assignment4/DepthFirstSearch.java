package com.ads.assignments.assignment4;

public class DepthFirstSearch<T> extends Search<T> {
    public DepthFirstSearch(UnweightedGraph<T> graph, T source) {
        super(source);
        dfs(graph, source);
    }

    private void dfs(UnweightedGraph<T> graph, T current) {
        marked.add(current);

        for (T neighbor : graph.adjacencyList(current)) {
            if (!marked.contains(neighbor)) {
                edgeTo.put(neighbor, current);
                dfs(graph, neighbor);
            }
        }
    }
}
