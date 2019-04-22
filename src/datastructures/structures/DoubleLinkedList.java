package datastructures.structures;

public class DoubleLinkedList<T> {
    private Node<T> head;
    private Node<T> last;
    private int index = 0;

    //o(1)
    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null && last == null) {
            head = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            //newNode.setNext(head);
            //head.setPrev(newNode);
            newNode.setPrev(last);
            //head = newNode;
            last = newNode;
        }
        index++;
    }

    //1
    //2
    //3
    //1-2-3

    //o(n)
    public void findData(T data) {
        Node currNode = head;
        if (isEmpty()) {
            System.out.println("LinkedList empty");
        } else {
            if (currNode.getData() == data) {
                System.out.println(data + " found");
            } else {
                while (currNode != null && currNode.getData() != data) {
                    currNode = currNode.getNext();
                }
                if (currNode != null) {
                    System.out.println(data + " found");
                } else {
                    System.out.println(data + " not found");
                }
            }
        }
    }

    //o(n)
    public void findPosition(int position) {
        Node currNode = head;
        int currentPosition = 0;
        if (isEmpty()) {
            System.out.println("LinkedList empty");
        } else {
            if (index == position) {
                System.out.println(position + " found position");
            } else {
                while (currNode != null && currentPosition != position) {
                    currNode = currNode.getNext();
                    currentPosition++;
                }
                if (currNode != null) {
                    System.out.println(currentPosition + " found position");
                } else {
                    System.out.println(currentPosition + " not found position");
                }
            }
        }
    }

    //o(1)
    public void deleteFirst() {
        if (isEmpty()) {
            System.out.println("LinkedList empty");
        } else {
            head = head.getNext();
        }
    }

    //o(n)
    public void deleteByData(T data) {
        Node currNode = head, prev = null;
        if (isEmpty()) {
            System.out.println("LinkedList empty");
        } else {
            if (currNode.getData() == data) {
                head = currNode.getNext();
                System.out.println(data + " found and deleted");
            } else {
                while (currNode != null && currNode.getData() != data) {
                    prev = currNode;
                    currNode = currNode.getNext();
                }
                if (currNode != null) {
                    prev.setNext(currNode.getNext());
                    System.out.println(data + " found and deleted");
                }
            }
        }
    }

    //o(n)
    public void deleteByPosition(int position) {
        int currentPosition = 0;
        Node currNode = head, prev = null;
        if (isEmpty()) {
            System.out.println("LinkedList empty");
        } else {
            if (index == position) {
                head = currNode.getNext();
                System.out.println(position + " found and deleted position");
            } else {
                while (currNode != null && currentPosition != position) {
                    prev = currNode;
                    currNode = currNode.getNext();
                    currentPosition++;
                }
                if (currNode != null) {
                    prev.setNext(currNode.getNext());
                    System.out.println(position + " found and deleted position");
                }
            }
        }
    }

    //o(n)
    public void print() {
        if (isEmpty()) {
            System.out.println("LinkedList empty");
        } else {
            Node last = head;
            while (last != null) {
                System.out.print("Value: "+last.getData());
                if (last.getPrev() != null)
                    System.out.println(" -  prev: "+last.getPrev().getData());
                last = last.getNext();
                System.out.println();
            }
        }
    }

    public void printReverse() {
        if (isEmpty()) {
            System.out.println("LinkedList empty");
        } else {
            printReverse(head);
        }
    }

    //o(n)
    public void printReverse(Node node) {
        if (node == null) return;
        printReverse(node.getNext());
        System.out.print("Value reverse: "+node.getData());
        if (node.getPrev() != null)
            System.out.println(" -  prev: "+node.getPrev().getData());
        System.out.println();
    }

    public void addFirst(Node node) {
        node.setNext(head);
        head = node;
    }

    public boolean isEmpty() {
        return (head == null) ? true : false;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
