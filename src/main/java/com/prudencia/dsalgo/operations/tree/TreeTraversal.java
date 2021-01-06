    package com.prudencia.dsalgo.operations.tree;


import java.util.LinkedList;
import java.util.Queue;

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


    private String levelOrderTraversal(Node node) {
       if(node == null){
           return "";
       }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node curr = queue.poll();
            strResult += curr.key+ " ";

            if(curr.left != null) {
                queue.add(curr.left);
            }
            if(curr.right != null) {
                queue.add(curr.right);
            }
        }

        return strResult;
    }

    private String levelOrderTraversal2(Node node) {
        if(node == null){
            return "";
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);

        while(!queue.isEmpty()){
            int count = queue.size();
            for(int i=0;i<count; i++){
                Node curr = queue.poll();
                strResult += curr.key+ " ";
                if(curr.left != null) {
                    queue.add(curr.left);
                }
                if(curr.right != null) {
                    queue.add(curr.right);
                }
            }
            strResult+="\n";

        }

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

    public String levelOrderTraversal() {
        return levelOrderTraversal(node);
    }


    public String levelOrderTraversal2() {
        return levelOrderTraversal2(node);
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

