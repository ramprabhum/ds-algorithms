package com.prudencia.dsalgo.sort;

public class InsertionSort  {

    public int[] insertionSort(int arr[]) {

        int len = arr.length;
        for(int i=0; i< len; i++) {

            int key = arr[i];
            // start from left-1
            int j = i-1;


            System.out.println("i" + i);
            printArray(arr);
            //  move key which are less than arr[j]
            //  move the complete left side
            while (j>=0 && arr[j] > key)
            {
                System.out.println("shift");
                arr[j+1] = arr[j];
                j = j-1;
                printArray(arr);
            }
            // update swapped value
            arr[j+1] = key;
            printArray(arr);
        }

        return arr;
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = new int[]{5,3,1,8};
        InsertionSort insertionSort = new InsertionSort();
        System.out.println(insertionSort.insertionSort(arr));

    }

}
