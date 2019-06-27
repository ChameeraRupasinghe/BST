package com.chameera;

public class BST {

    private Node root;

    public void treeWalk(Node startingNode) {
        if (startingNode != null) {
            treeWalk(startingNode.getLeft());
            System.out.println(startingNode.getKey() + " ");
            treeWalk(startingNode.getRight());
        }
    }

    public Node treeSearch(Node startingNode, int searchValue) {
        if (startingNode == null || startingNode.getKey() == searchValue) {
            return startingNode;
        }
        if (searchValue < startingNode.getKey()) {
            return treeSearch(startingNode.getLeft(), searchValue);
        } else return treeSearch(startingNode.getRight(), searchValue);
    }

    public Node minimum(Node startingNode) {
        if (startingNode == null) return null;
        Node x = startingNode;
        while (x.getLeft() != null) {
            x = x.getLeft();
        }
        return x;
    }

    public Node maximum(Node startingNode) {
        if (startingNode == null) return null;
        Node x = startingNode;
        while (x.getRight() != null) {
            x = x.getRight();
        }
        return x;
    }

    public Node successor(Node node) {
        if (node.getRight() != null) {
            return minimum(node.getRight());
        }
        Node x = node.getParent();
        while (x != null && x.getRight() == node) {
            node = x;
            x = x.getParent();
        }
        return x;
    }

    public Node predecessor(Node node) {
        if (node.getLeft() != null) {
            return maximum(node.getLeft());
        }
        Node x = node.getParent();
        while (x != null && x.getLeft() == node) {
            node = x;
            x = x.getParent();
        }
        return x;
    }

    public void insert(int key) {
        Node newNode = new Node(key);
        Node y = null;
        Node x = this.root;

        while (x != null) {
            y = x;
            if (newNode.getKey() < x.getKey()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }
        newNode.setParent(y);

        if (y == null) {
            this.root = newNode;
        } else if (newNode.getKey() < y.getKey()) {
            y.setLeft(newNode);
        } else
            y.setRight(newNode);
    }

    public void delete(Node nodeToDelete) {
        if (nodeToDelete.getLeft() == null){
            transplant(nodeToDelete, nodeToDelete.getRight());
        } else if (nodeToDelete.getRight() == null){
            transplant(nodeToDelete, nodeToDelete.getLeft());
        } else {
            Node y = minimum(nodeToDelete.getRight());
            if (y.getParent() != nodeToDelete){
                transplant(y, y.getRight());
                y.setRight(nodeToDelete.getRight());
                y.getRight().setParent(y);
            }
            transplant(nodeToDelete, y);
            y.setLeft(nodeToDelete.getLeft());
            y.getLeft().setParent(y);
        }
    }

    private void transplant(Node u, Node v) {
        if (u.getParent() == null) {
            this.root = v;
        } else if (u == u.getParent().getLeft()) {
            u.getParent().setLeft(v);
        } else {
            u.getParent().setRight(v);
        }
        if (v != null) {
            v.setParent(u.getParent());
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }


}
