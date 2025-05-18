package com.ads.assignments.assignment4;

public class Main {
    
    public static void main(String[] args) {
        WeightedGraph<String> WeightedGraph = new WeightedGraph<>(true);
        fillWithWeights(WeightedGraph);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(WeightedGraph, "Almaty");
        outputPath(djk, "Kyzylorda");


        System.out.println("--------------------------------");

        UnweightedGraph<String> graph = new UnweightedGraph<>(false);
        fillWithoutWeights(graph);

        System.out.println("DFS:");
        Search<String> dfs = new DepthFirstSearch<>(graph, "Almaty");
        outputPath(dfs, "Kyzylorda");

        System.out.println("--------------------------------");

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(WeightedGraph, "Almaty");
        outputPath(bfs, "Kyzylorda");
    }

    public static void fillWithoutWeights(UnweightedGraph<String> graph) {
        graph.addEdge("Almaty", "Astana");
        graph.addEdge("Astana", "Almaty");
        graph.addEdge("Almaty", "Atyrau");
        graph.addEdge("Atyrau", "Almaty");
        graph.addEdge("Astana", "Shymkent");
        graph.addEdge("Shymkent", "Astana");
        graph.addEdge("Astana", "Kostanay");
        graph.addEdge("Kostanay", "Astana");
        graph.addEdge("Shymkent", "Kyzylorda");
        graph.addEdge("Kyzylorda", "Shymkent");
        graph.addEdge("Atyrau", "Kostanay");
        graph.addEdge("Kostanay", "Atyrau");
        graph.addEdge("Kostanay", "Kyzylorda");
        graph.addEdge("Kyzylorda", "Kostanay");
    }

    public static void fillWithWeights(WeightedGraph<String> graph) {
        graph.addEdge("Almaty", "Astana", 7.2);
        graph.addEdge("Astana", "Almaty", 7.2);
        graph.addEdge("Almaty", "Atyrau", 6.4);
        graph.addEdge("Atyrau", "Almaty", 6.4);
        graph.addEdge("Astana", "Shymkent", 5.3);
        graph.addEdge("Shymkent", "Astana", 5.3);
        graph.addEdge("Astana", "Kostanay", 5.5);
        graph.addEdge("Kostanay", "Astana", 5.5);
        graph.addEdge("Shymkent", "Kyzylorda", 7.9);
        graph.addEdge("Kyzylorda", "Shymkent", 7.9);
        graph.addEdge("Atyrau", "Kostanay", 8.1);
        graph.addEdge("Kostanay", "Atyrau", 8.1);
        graph.addEdge("Kostanay", "Kyzylorda", 9.1);
        graph.addEdge("Kyzylorda", "Kostanay", 9.1);
    }

    public static void outputPath(Search<String> search, String key) {
        for (String v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }

        System.out.println();
    }
}
