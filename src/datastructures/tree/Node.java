package datastructures.tree;

public class Node {
    Node left;
    Node right;
    private int value;

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
