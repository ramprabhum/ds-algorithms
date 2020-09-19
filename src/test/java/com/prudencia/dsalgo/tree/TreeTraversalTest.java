package com.prudencia.dsalgo.tree;

import org.junit.Assert;
import org.junit.Test;

public class TreeTraversalTest {

    TreeTraversal tree = new TreeTraversal();


      @Test
      public void assertTreeTraversal() {
          tree.node = new Node(1);
          tree.node.left = new Node(2);
          tree.node.right = new Node(3);
          tree.node.left.left = new Node(4);
          tree.node.left.right = new Node(5);

          Assert.assertEquals("4 2 5 1 3 ",
                  tree.inOrderTraversal());

          tree.strResult= "";

          Assert.assertEquals("1 2 4 5 3 ",
                  tree.preOrderTraversal());

          tree.strResult= "";

          Assert.assertEquals("4 5 2 3 1 ",
                  tree.postOrderTraversal());

          tree.strResult= "";

          Assert.assertEquals("1 2 3 4 5 ",
                  tree.levelOrderTraversal());




      }


}

