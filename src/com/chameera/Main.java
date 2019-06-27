package com.chameera;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(6);
        bst.insert(17);
        bst.insert(3);
        bst.insert(12);
        bst.insert(1);

        System.out.println("BST root key: " + bst.getRoot().getKey());

        bst.treeWalk(bst.getRoot());

        Node foundNode = bst.treeSearch(bst.getRoot(), 10);
        System.out.println("Search and found: " + foundNode);

        System.out.println("Min node is: " + bst.minimum(bst.getRoot()));
        System.out.println("Max node is: " + bst.maximum(bst.getRoot()));

        Node nodeS = bst.minimum(bst.getRoot());
        System.out.println("Successor of: "+ nodeS + " is: "+ bst.successor(nodeS));

        Node nodeP = bst.maximum(bst.getRoot());
        System.out.println("Predecessor of: "+ nodeP + " is: "+ bst.predecessor(nodeP));

        Node nodeToDelete = bst.treeSearch(bst.getRoot(), 1);
        bst.delete(nodeToDelete);

        bst.treeWalk(bst.getRoot());
    }

}
