package com.prudencia.dsalgo.tree;


public class TreeTraversal {


    public Node node = null;
    public String strResult = "";

    public TreeTraversal(){

    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    private String inOrderTraversal(Node node) {

        if (node == null)
            return "";

        // first recur on left subtree
        inOrderTraversal(node.left);

        // now deal with the node
        System.out.print(node.key + " ");
        strResult+=node.key+" ";

        // then recur on right subtree
        inOrderTraversal(node.right);
        return strResult;
    }

    private String preOrderTraversal(Node node) {

        if (node == null)
            return "";

        // now deal with the node
        System.out.print(node.key + " ");
        strResult+=node.key+" ";

        // first recur on left subtree
        preOrderTraversal(node.left);

        // then recur on right subtree
        preOrderTraversal(node.right);
        return strResult;
    }


    private String postOrderTraversal(Node node) {

        if (node == null)
            return "";

        // first recur on left subtree
        postOrderTraversal(node.left);

        // then recur on right subtree
        postOrderTraversal(node.right);

        // now deal with the node
        System.out.print(node.key + " ");
        strResult+=node.key+" ";
        return strResult;
    }

    public String inOrderTraversal() {
        return inOrderTraversal(node);
    }

    public String preOrderTraversal() {
        return preOrderTraversal(node);
    }

    public String postOrderTraversal() {
        return postOrderTraversal(node);
    }

    public Node createNode(int item) {
        Node node = new Node(item);
        return node;
    }


}

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

