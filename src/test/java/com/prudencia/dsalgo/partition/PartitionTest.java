package com.prudencia.dsalgo.partition;

import org.junit.Assert;
import org.junit.Test;

public class PartitionTest {

    @Test
    public void assertNaivePartition() {
        NaivePartition naivePartition = new NaivePartition();
        int[] arr=new int[]{3,5,6,2,9,4,1,8,7};
        Assert.assertArrayEquals(naivePartition.naivePartition
                (arr,0,arr.length-1,arr.length-1),new int[]{3,5,6,2,4,1,7,9,8});

    }

    @Test
    public void assertLomutoPartition() {
        LomutoPartition lomutoPartition = new LomutoPartition();
        int[] arr=new int[]{3,5,6,2,9,4,1,8,7};
        lomutoPartition.lomutoPartition
                (arr,0,arr.length-1);
        Assert.assertArrayEquals(arr,new int[]{3,5,6,2,4,1,7,8,9});

    }

    @Test
    public void assertHoarePartition() {
        HoarePartition hoarePartition = new HoarePartition();
        int[] arr=new int[]{3,5,6,2,9,4,1,8,7};
        hoarePartition.hoarePartition
                (arr,0,arr.length-1);
        Assert.assertArrayEquals(arr,new int[]{1,2,6,5,9,4,3,8,7});

    }
}

