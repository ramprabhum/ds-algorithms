package com.prudencia.dsalgo.tree;

public class TreeFunctions {

    public int treeHeight(Node node){
        if(node == null)
            return 0;
        else{
            return Math.max(treeHeight(node.left),treeHeight(node.right)) +1;
        }
    }

//    public static void main(String[] args) {
//        Node node = new Node(1);
//        node.left = new Node(2);
//        node.right = new Node(3);
//        node.left.left = new Node(4);
//        node.left.left.left = new Node(5);
//        System.out.println(treeHeight(node));
//    }

}


