package com.prudencia.dsalgo.tree;

import org.junit.Assert;
import org.junit.Test;

public class TreeFunctionsTest {

    TreeFunctions treeFunctions = new TreeFunctions();

    @Test
    public void assertTreeHeight() {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        Assert.assertEquals(treeFunctions.treeHeight(node),3);
    }

    @Test
    public void assertKDistance() {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        Assert.assertEquals(treeFunctions.printKDistance(node,1),"2 3 ");
    }

    @Test
    public void assertSize() {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        Assert.assertEquals(treeFunctions.treeSize(node),4);
    }

    @Test
    public void assertMax() {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(40);
        node.left.right = new Node(6);
        Assert.assertEquals(treeFunctions.maxSize(node),40);
    }

    @Test
    public void assertLeftView() {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        Assert.assertEquals(treeFunctions.leftViewUtil(node,1),"1 2 6 ");
    }

    @Test
    public void assertRightView() {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        Assert.assertEquals(treeFunctions.rightViewUtil(node,1),"1 3 7 ");
    }

    @Test
    public void assertBalancedTree() {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.right.left = new Node(6);
        Assert.assertEquals(treeFunctions.isBalanced(node),true);
    }

    @Test
    public void assertUnBalancedTree() {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.right.left = new Node(6);
        node.right.left.left = new Node(7);
        node.right.left.left.left = new Node(8);
        Assert.assertEquals(treeFunctions.isBalanced(node),false);
    }


}
