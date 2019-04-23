package datastructures.structures;

public class Queue<T> {
    private Node<T> first;
    private Node<T> last;

    public void add(T data) {
        Node<T> node = new Node<>(data);
        if (first == null) {
            first = node;
            last = node;
        }
        else {
            addLast(node);
        }
    }

    public T remove() {
        T val = null;
        if (!isEmpty()) {
            val = first.getData();
            first = first.getNext();
            //System.out.println("val deleted: " + val);
        }

        return val;
    }

    public void front() {
        if (!isEmpty()) {
            System.out.println("front val: " + first.getData());
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

    public void addLast(Node node) {
        last.setNext(node);
        last = node;
    }

    public boolean isEmpty() {
        return (first == null) ? true : false;
    }
}
