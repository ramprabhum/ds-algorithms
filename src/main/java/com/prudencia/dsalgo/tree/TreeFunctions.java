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


    public int treeSize(Node node){
        if(node == null)
            return 0;
       else {
            return 1 + treeSize(node.left) + treeSize(node.right);
        }
    }


    public int maxSize(Node node){
        if(node == null)
            return Integer.MIN_VALUE;
        else {
            return Math.max(node.key,Math.max(maxSize(node.left),maxSize(node.right)));
        }
    }

    int maxLevel = 0;
    String strResult = "";
    public String leftViewUtil(Node node, int level) {
        if (node == null)
            return "";
        if(maxLevel < level) {
            strResult+=node.key+" ";
            maxLevel = level;
        }

        leftViewUtil(node.left,level+1);
        leftViewUtil(node.right,level+1);
        return  strResult;
    }


    public String rightViewUtil(Node node, int level) {
        if (node == null)
            return "";
        if(maxLevel < level) {
            strResult+=node.key+" ";
            maxLevel = level;
        }

        rightViewUtil(node.right,level+1);
        rightViewUtil(node.left,level+1);
        return  strResult;
    }


    public boolean isBalanced(Node root) {
        if (root == null)
            return true;

        if (getHeight(root) == -1)
            return false;

        return true;
    }

    public int getHeight(Node root) {
        if (root == null)
            return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if (left == -1 || right == -1)
            return -1;

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;

    }


}


