package com.ads.assignments.assignment4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Search<Vertex> {
    protected Set<Vertex> marked;
    protected Map<Vertex, Vertex> edgeTo;
    protected final Vertex source;


    public Search(Vertex source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }



    public boolean hasPathTo(Vertex v) {
        return !marked.contains(v);
    }

    public Iterable<Vertex> pathTo(Vertex v) {
        if (hasPathTo(v)) return null;

        LinkedList<Vertex> list = new LinkedList<>();
        for (Vertex i = v; i != source; i = edgeTo.get(i)) {
            list.push(i);
        }

        list.push(source);

        return list;
    }
}
