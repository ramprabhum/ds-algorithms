package com.prudencia.dsalgo.operations.sort;

import com.prudencia.dsalgo.operations.partition.HoarePartition;
import com.prudencia.dsalgo.operations.partition.LomutoPartition;

public class QuickSort {

    LomutoPartition lomutoPartition = new LomutoPartition();
    HoarePartition hoarePartition = new HoarePartition();

    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    public void quickSortLomuto(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pivot = lomutoPartition.lomutoPartition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSortLomuto(arr, low, pivot);
            quickSortLomuto(arr, pivot+1, high);
        }
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    public void quickSortHoare(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pivot = hoarePartition.hoarePartition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSortHoare(arr, low, pivot);
            quickSortHoare(arr, pivot+1, high);
        }
    }


}
