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
}
