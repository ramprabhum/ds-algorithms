package com.prudencia.dsalgo.problems.tree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindLeaves {
        List<List<Integer>> result = new ArrayList();

public List<List<Integer>> findLeaves(TreeNode root) {
        getHeight(root);
        return result;

        }

private int getHeight(TreeNode root) {

        if(root == null){
        return -1;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        int height = Math.max(leftHeight,rightHeight) + 1;

        if(this.result.size() == height){
        this.result.add(new ArrayList<>());

        }

        this.result.get(height).add(root.val);
        return height;
        }

    public static void main(String[] args) {
        FindLeaves findLeaves = new FindLeaves();

        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);


        System.out.println(findLeaves.findLeaves(tree));
    }
}

