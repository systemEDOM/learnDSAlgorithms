package datastructures.graph;

import datastructures.structures.Queue;
import datastructures.structures.Stack;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {
    private Map<Vertex, Set<Edge>> adjVertices;
    private Map<String, Vertex> adjVerticesNames;

    public Graph() {
        adjVertices = new HashMap<>();
        adjVerticesNames = new HashMap<>();
    }

    //o(1)
    public Set<Edge> getAdjVertices(String label) {
        Vertex v = adjVerticesNames.get(label);
        return adjVertices.get(v);
    }

    //o(1)
    public void addVertex(String label) {
        Vertex v = new Vertex(label);
        adjVertices.putIfAbsent(v, new LinkedHashSet<>());
        adjVerticesNames.putIfAbsent(label, v);
    }

    //o(n^2)
    public void removeVertex(String label) {
        Vertex v = adjVerticesNames.get(label);
        adjVerticesNames.remove(label);

        Iterator<Edge> iterator = adjVertices.get(v).iterator();
        while (iterator.hasNext()) {
            Edge ve = iterator.next();

            Iterator<Edge> it2 = adjVertices.get(ve.getDest()).iterator();
            while (it2.hasNext()) {
                Edge ed2 = it2.next();
                if (ed2.getDest() == v)
                    it2.remove();
            }
            iterator.remove();
        }
        adjVertices.remove(v);
    }

    //o(1)
    public void addEdge(String label1, String label2) {
        Vertex v1 = adjVerticesNames.get(label1);
        Vertex v2 = adjVerticesNames.get(label2);
        if(v1 != null && v2 != null) {
            adjVertices.get(v1).add(new Edge(v1, v2, 1));
            adjVertices.get(v2).add(new Edge(v2, v1, 1));
        }
    }

    //o(n)
    public void removeEdge(String label1, String label2) {
        Vertex v1 = adjVerticesNames.get(label1);
        Vertex v2 = adjVerticesNames.get(label2);

        Iterator<Edge> iterator = adjVertices.get(v1).iterator();
        while (iterator.hasNext()) {
            Edge ve = iterator.next();
            if (ve.getSrc() == v1 && ve.getDest() == v2)
                iterator.remove();
        }

        Iterator<Edge> iterator2 = adjVertices.get(v2).iterator();
        while (iterator2.hasNext()) {
            Edge ve = iterator2.next();
            if (ve.getDest() == v1 && ve.getSrc() == v2)
                iterator2.remove();
        }
    }

    public Set<String> depthFirstTraversal(String root) {
        return depthFirstTraversal(root, new LinkedHashSet<String>());
    }

    //O(V+E)
    public Set<String> depthFirstTraversal(String root, Set<String> visited) {
        if(!visited.contains(root)) {
            visited.add(root);
            //System.out.println("Conex root: "+root);
            //getAdjVertices(root).forEach(el -> System.out.println("el: "+el.getDest().getLabel()));
            if(getAdjVertices(root) != null) {
                for (Edge ed : getAdjVertices(root)) {
                    depthFirstTraversal(ed.getDest().getLabel(), visited);
                }
            }
        }
        return visited;
    }

    //o(V+E)
    public Set<String> breadthFirstTraversal(String root) {
        Set<String> visited = new LinkedHashSet<String>();
        //Queue<String> queue = new LinkedList<String>(); //Using the Queue from Java.util
        Queue<String> queue = new Queue<String>(); //Using the Queue from this project
        queue.add(root);
        visited.add(root);
        while(!queue.isEmpty()) {
            String vertex = queue.remove();
            if(getAdjVertices(vertex) != null) {
                for (Edge ed : getAdjVertices(vertex)) {
                    if (!visited.contains(ed.getDest().getLabel())) {
                        visited.add(ed.getDest().getLabel());
                        queue.add(ed.getDest().getLabel());
                    }
                }
            }
        }
        return visited;
    }

    public void printGraph() {
        for (Map.Entry<Vertex, Set<Edge>> ent : adjVertices.entrySet()) {
            System.out.println(ent.getKey().getLabel());
            for (Edge ed : ent.getValue()) {
                System.out.println(ed.getSrc().getLabel()+" -> "+ed.getDest().getLabel());
            }
        }
    }
}
