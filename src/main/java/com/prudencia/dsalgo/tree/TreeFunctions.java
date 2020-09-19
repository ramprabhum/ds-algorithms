package com.prudencia.dsalgo.tree;

public class TreeFunctions {

    String kDistance = "";
    public int treeHeight(Node node){
        if(node == null)
            return 0;
        else{
            return Math.max(treeHeight(node.left),treeHeight(node.right)) +1;
        }
    }

    public String printKDistance(Node node, int height){
        if(node == null)
            return null;
        if(height == 0){
            kDistance+=node.key + " ";
        } else {
            printKDistance(node.left,height-1);
            printKDistance(node.right,height-1);
        }

        return kDistance;
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


