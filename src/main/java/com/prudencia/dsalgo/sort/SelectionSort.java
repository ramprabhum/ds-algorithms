package com.prudencia.dsalgo.sort;

public class SelectionSort {


    public int[] bubbleSort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            // minimum element in unsorted array
            int min = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min])
                    min = j;

            // Swap min element with the first element
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


    public static void main(String args[]) {
        SelectionSort selectionSort = new SelectionSort();
        int arr[] = {2,1,8,3,9,5};
        selectionSort.bubbleSort(arr);
        selectionSort.printArray(arr);
    }

}
