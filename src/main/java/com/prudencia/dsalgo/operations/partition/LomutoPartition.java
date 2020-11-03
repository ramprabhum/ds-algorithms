package com.prudencia.dsalgo.operations.partition;

public class LomutoPartition {

    public int lomutoPartition(int arr[], int low, int high){
        int pointer = arr[high];
        int i = low - 1;
        int temp;

        for(int j=low; j< high;j++){

            if(arr[j] < pointer) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }

        }
        temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i;
    }



}
