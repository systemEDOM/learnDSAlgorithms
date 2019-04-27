import algorithms.Algorithms;
import datastructures.tree.Tree;

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
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.front();
        q.remove();
        q.remove();
        q.front();
        q.remove();
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



        //Graph graph = new Graph();
        /*graph.addVertex("Bob");
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
        //graph.removeEdge("Bob","Alice");
        System.out.println(graph.depthFirstTraversal("Bob").toString());*/
        //graph.removeVertex("Alice");
        //graph.printGraph();
        /*graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("S");
        graph.addVertex("C");
        graph.addVertex("G");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("H");
        graph.addEdge("A", "B");
        graph.addEdge("A", "S");
        graph.addEdge("S", "C");
        graph.addEdge("S", "G");
        graph.addEdge("C", "D");
        graph.addEdge("C", "E");
        graph.addEdge("C", "F");
        graph.addEdge("E", "H");
        graph.addEdge("G", "F");
        graph.addEdge("G", "H");
        //graph.removeVertex("H");
        //graph.removeEdge("B", "A");
        graph.printGraph();
        System.out.println(graph.depthFirstTraversal("A").toString());*/
        /*graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addEdge("A", "B");
        graph.addEdge("A", "D");
        graph.addEdge("A", "G");
        graph.addEdge("B", "E");
        graph.addEdge("B", "F");
        graph.addEdge("E", "G");
        graph.addEdge("F", "C");
        graph.addEdge("F", "D");
        graph.addEdge("C", "H");
        System.out.println(graph.depthFirstTraversal("A").toString());
        System.out.println(graph.breadthFirstTraversal("A").toString());*/
        //graph.removeVertex("B");
        //graph.removeEdge("Bob", "Rob");
        //graph.getAdjVertices("Bob").forEach(x -> System.out.println("Bob -> "+x.getLabel()+" val: "));
        //graph.getAdjVertices("Bob").forEach(x -> System.out.println("Bob -> "+x.getLabel()));
        //graph.printGraph();
        /*graph.addVertex("0");
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");
        graph.addEdge("0", "1");
        graph.addEdge("0", "2");
        graph.addEdge("1", "2");
        graph.addEdge("1", "3");
        graph.addEdge("2", "3");
        graph.addEdge("3", "4");
        graph.addEdge("4", "1");
        graph.addEdge("4", "0");
        graph.addEdge("4", "5");
        System.out.println(graph.depthFirstTraversal("0").toString());*/


        /*Tree tree = new Tree();
        tree.add(4);
        tree.add(1);
        tree.add(3);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(0);
        System.out.println("Finding: "+tree.contains(4));
        //tree.delete(0);
        System.out.println("InOrder...");
        tree.inOrder();
        System.out.println("PreOrder...");
        tree.preOrder();
        System.out.println("PostOrder...");
        tree.postOrder();*/
        /*
                4
              /   \
             1     5
            / \     \
           0   3     6
                      \
                       7
         */




        //int[] nums = {1,1,1,2,2,3};
        //int[] nums = {1};
        /*int[] nums = {1,6,2,1,6,1,6};
        int k = 2;
        //System.out.println(algorithms.topKFrequent(nums,k));
        System.out.println(algorithms.topKFrequent2(nums,k));*/

        int[] nums = {1,2,3};
        System.out.println(algorithms.subsets(nums));
    }
}


