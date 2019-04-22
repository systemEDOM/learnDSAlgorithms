import datastructures.algorithms.Algorithms;
import datastructures.graph.Graph;
import datastructures.structures.DoubleLinkedList;
import datastructures.structures.LinkedList;
import datastructures.structures.Queue;
import datastructures.structures.Stack;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Algorithms algorithms = new Algorithms();
        /*List<List<Integer>> perm = algorithms.permutations2(Arrays.asList(1,2,3));
        System.out.println("**Permutations**");
        System.out.println(perm);*/

        /*System.out.println("**Linked List**");
        LinkedList<Integer> linkedList = new LinkedList<>();
        //System.out.println("Is empty: "+linkedList.isEmpty());
        linkedList.insert(1);
        linkedList.insert(2);
        //linkedList.deleteByData(1);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);
        linkedList.insert(6);
        //linkedList.deleteByPosition(4);
        //linkedList.findData(6);
        //linkedList.findPosition(4);
        //linkedList.deleteFirst();
        linkedList.reverse();
        linkedList.print();
        linkedList.printReverse();*/


        /*System.out.println("**Double Linked List**");
        DoubleLinkedList<Integer> dlinkedList = new DoubleLinkedList<>();
        //System.out.println("Is empty: "+linkedList.isEmpty());
        dlinkedList.insert(1);
        dlinkedList.insert(2);
        //dlinkedList.deleteByData(1);
        dlinkedList.insert(3);
        dlinkedList.insert(4);
        dlinkedList.insert(5);
        //dlinkedList.deleteByPosition(4);
        //dlinkedList.findData(6);
        //dlinkedList.findPosition(4);
        //dlinkedList.deleteFirst();
        dlinkedList.print();
        dlinkedList.printReverse();*/

        /*Queue<Integer> q = new Queue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.front();
        q.dequeue();
        q.dequeue();
        q.front();
        q.dequeue();
        q.front();
        q.print();*/

        /*Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.pop();
        s.top();
        s.print();*/

        /*Graph graph = new Graph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        graph.removeVertex("Alice");
        graph.removeEdge("Bob", "Rob");
        graph.getAdjVertices("Bob").forEach(x -> System.out.println("Bob -> "+x.getLabel()));
        graph.printGraph();*/

    }
}
