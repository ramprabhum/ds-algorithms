package com.prudencia.dsalgo.search;

import com.prudencia.dsalgo.sort.MergeSort;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void testBinarySearch(){
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = new int[]{1,2,3,4,5,6,7};
        Assert.assertEquals(binarySearch.binarySearchIterative(arr,arr.length, 6),5);
        Assert.assertEquals(binarySearch.binarySearchRecursive(arr,0,arr.length-1, 6),5);

    }
}
