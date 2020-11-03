package com.prudencia.dsalgo.operations.partition;

public class HoarePartition {

    public int hoarePartition(int arr[], int low, int high){
        int pivot = arr[low];
        int i= low -1;
        int j= high + 1;

        while (true){

            do {
                i++;
            } while (arr[i]< pivot);

            do {
                j--;
            } while (arr[j]> pivot);

            if(i >=j)
                return j;
            swap(arr, i, j);
        }
    }
    private static void swap(int array[], int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
