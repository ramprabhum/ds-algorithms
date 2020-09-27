package com.prudencia.dsalgo.sort;

import org.junit.Assert;
import org.junit.Test;

public class SortingTest {
    @Test
    public void testBubbleSort(){
        BubbleSort bubbleSort = new BubbleSort();
        Assert.assertArrayEquals(bubbleSort.bubbleSort(new int[]{6,7,1,2,4,3,5}),new int[]{1,2,3,4,5,6,7});
    }

    @Test
    public void testSelectionSort(){
        SelectionSort selectionSort = new SelectionSort();
        Assert.assertArrayEquals(selectionSort.seletionSort(new int[]{6,7,1,2,4,3,5}),new int[]{1,2,3,4,5,6,7});
    }

    @Test
    public void testInsertionSort(){
        InsertionSort insertionSort = new InsertionSort();
        Assert.assertArrayEquals(insertionSort.insertionSort(new int[]{6,7,1,2,4,3,5}),new int[]{1,2,3,4,5,6,7});
    }

    @Test
    public void testMergeSort(){
        MergeSort mergeSort = new MergeSort();
        int[] arr = new int[]{6,7,1,2,4,3,5};
        mergeSort.mergeSort(arr,0, arr.length-1);
        Assert.assertArrayEquals(arr,new int[]{1,2,3,4,5,6,7});
    }

    @Test
    public void testQuickSort(){
        QuickSort quickSort = new QuickSort();
        int[] arr = new int[]{6,7,1,2,4,3,5};
        quickSort.quickSortLomuto(arr,0, arr.length-1);
        Assert.assertArrayEquals(arr,new int[]{1,2,3,4,5,6,7});

        arr = new int[]{6,7,1,2,4,3,5};
        quickSort.quickSortHoare(arr,0, arr.length-1);
        Assert.assertArrayEquals(arr,new int[]{1,2,3,4,5,6,7});

    }
}
