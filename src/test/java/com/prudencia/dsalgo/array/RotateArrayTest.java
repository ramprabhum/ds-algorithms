package com.prudencia.dsalgo.array;

import org.junit.Assert;
import org.junit.Test;

public class RotateArrayTest {

    RotateArray rotate = new RotateArray();
    int arr[] = { 1, 2, 3, 4, 5, 6, 7 };

    @Test
    public void assertBruteForceRotation() {
        rotate.leftRotate(arr,2,7);
        Assert.assertArrayEquals(arr, new int[]{  3, 4, 5, 6, 7, 1, 2});
    }

}
