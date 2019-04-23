package datastructures.structures;

public class Stack<T> {
    private Node<T> first;

    public void push(T data) {
        Node<T> node = new Node<>(data);
        if (first == null) {
            first = node;
        }
        else {
            addFirst(node);
        }
    }

    public T pop() {
        T val = null;
        if (!isEmpty()) {
            val = first.getData();
            first = first.getNext();
            //System.out.println("val deleted: " + val);
        }

        return val;
    }

    public void top() {
        if (!isEmpty()) {
            System.out.println("top val: " + first.getData());
        }
    }

    public void print() {
        if(!isEmpty()) {
            Node aux = first;
            while(aux != null) {
                System.out.println("Val: "+aux.getData());
                aux = aux.getNext();
            }
        }
    }

    public void addFirst(Node node) {
        node.setNext(first);
        first = node;
    }

    public boolean isEmpty() {
        return (first == null) ? true : false;
    }
}
