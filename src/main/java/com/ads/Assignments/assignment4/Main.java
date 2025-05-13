package com.ads.assignments.assignment4;


public class Main {
    public static void main(String[] args) {
        Vertex<String> Vertex1 = new Vertex<>("Almaty");
        Vertex<String> Vertex2 = new Vertex<>("Astana");
        Vertex<String> Vertex3 = new Vertex<>("Shymkent");
        Vertex<String> Vertex4 = new Vertex<>("Atyrau");
        Vertex<String> Vertex5 = new Vertex<>("Kostanay");
        Vertex<String> Vertex6 = new Vertex<>("Kyzylorda");

        WeightedGraph<String> graph = new WeightedGraph<>(true);

        graph.addEdge(Vertex1, Vertex2, 2.5);
        graph.addEdge(Vertex2, Vertex3, 3.4);
        graph.addEdge(Vertex3, Vertex4, 8.5);
        graph.addEdge(Vertex4, Vertex5, 7.2);
        graph.addEdge(Vertex5, Vertex6, 1.5);
        graph.addEdge(Vertex6, Vertex1, 6);
        graph.addEdge(Vertex1, Vertex3, 9);
        graph.addEdge(Vertex2, Vertex4, 4.5);


        DijkstraSearch<String> dijkstra = new DijkstraSearch<>();
        dijkstra.dijkstra(graph, Vertex5);
        System.out.println("Dijkstra Path to the best city in Kazakhstan(Almaty):");
        for (Vertex<String> v : dijkstra.pathTo(Vertex1)) {
            System.out.print(v.getData() + " --> ");
        }
        System.out.println();

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>();
        bfs.BreadthFirstSearch(graph, Vertex1);
        System.out.println("BFS Path to city Kyzylorda:");
        for (Vertex<String> v : bfs.pathTo(Vertex6)) {
            System.out.print(v.getData() + " --> ");
        }
        System.out.println();

        Vertex1.addNeighbor(Vertex6, 5.5);

        System.out.println("Updated Dijkstra Path to the best city in Kazakhstan(Almaty):");
        dijkstra.dijkstra(graph, Vertex5);
        for (Vertex<String> v : dijkstra.pathTo(Vertex1)) {
            System.out.print(v.getData() + " --> ");
        }
    }
}

