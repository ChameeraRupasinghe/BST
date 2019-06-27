package com.chameera;

public class Node {

    private Integer key;
    private Node parent, left, right;

    public Node() {
    }

    public Node(int key) {
        this.key = key;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
        if (left != null)
            left.setParent(this);
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
        if (right != null)
            right.setParent(this);
    }

    @Override
    public String toString() {
        String nodeToString = "Node{" +
                "key=" + (key != null ? key : "null") +
                ", parent=" + (parent != null ? parent.getKey() : "null") +
                ", left=" + (left != null ? left.getKey() : "null") +
                ", right=" + (right != null ? right.getKey() : "null") +
                '}';
        return nodeToString;
    }
}
