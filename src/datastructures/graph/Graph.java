package datastructures.graph;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {
    private Map<Vertex, Set<Vertex>> adjVertices;
    private Map<String, Vertex> adjVerticesNames;

    public Graph() {
        adjVertices = new HashMap<>();
        adjVerticesNames = new HashMap<>();
    }

    public Set<Vertex> getAdjVertices(String label) {
        Vertex v = adjVerticesNames.get(label);
        return adjVertices.get(v);
    }

    public void addVertex(String label) {
        Vertex v = new Vertex(label);
        adjVertices.putIfAbsent(v, new HashSet<Vertex>());
        adjVerticesNames.putIfAbsent(label, v);
    }

    public void removeVertex(String label) {
        Vertex v = adjVerticesNames.get(label);
        adjVertices.values().stream().map(e -> e.remove(v)).collect(Collectors.toList());
    }

    public void addEdge(String label1, String label2) {
        Vertex v1 = adjVerticesNames.get(label1);
        Vertex v2 = adjVerticesNames.get(label2);
        if(v1 != null && v2 != null) {
            adjVertices.get(v1).add(v2);
            adjVertices.get(v2).add(v1);
        }
    }

    public void removeEdge(String label1, String label2) {
        Vertex v1 = adjVerticesNames.get(label1);
        Vertex v2 = adjVerticesNames.get(label2);
        Set<Vertex> eV1 = adjVertices.get(v1);
        Set<Vertex> eV2 = adjVertices.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    public void printGraph() {
        adjVerticesNames.forEach((k,v) -> {
            System.out.println(v.getLabel());
            adjVertices.get(v).forEach((el) -> {
                System.out.println(v.getLabel()+" -> "+el.getLabel());
            });
        });
    }
}
