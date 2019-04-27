package datastructures.tree;

public class Tree {
    private Node root;

    public void add(int value) {
        root = add(root, value);
    }

    public Node add(Node root, int value) {
        if (root == null)
            return new Node(value);

        if (value < root.getValue())
            root.left = add(root.left, value);
        else if (value > root.getValue())
            root.right = add(root.right, value);
        else
            return root;

        return root;
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    public Node delete(Node root, int value) {
        if (root == null) return null;
        if (value == root.getValue()) {
            // Case 1: no children
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: only 1 child
            if (root.right == null) {
                return root.left;
            }

            if (root.left == null) {
                return root.right;
            }

            // Case 3: 2 children
            int smallestValue = findSmallestValue(root.right);
            root.setValue(smallestValue);
            root.right = delete(root.right, smallestValue);
            return root;
        }
        if (value < root.getValue()) {
            root.left = delete(root.left, value);
            return root;
        }

        root.right = delete(root.right, value);
        return root;
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.getValue() : findSmallestValue(root.left);
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    public boolean contains(Node root, int value) {
        if (root == null) return false;
        if (root.getValue() == value) return true;
        if (value < root.getValue())
            return contains(root.left, value);
        else
            return contains(root.right, value);
    }

    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(Node root) {
        if(root == null) return;

        inOrder(root.left);
        System.out.println("val: " + root.getValue());
        inOrder(root.right);
    }

    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(Node root) {
        if(root == null) return;

        System.out.println("val: " + root.getValue());
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    public void postOrder(Node root) {
        if(root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println("val: " + root.getValue());
    }

    public boolean isEmpty() {
        return root == null;
    }
}
