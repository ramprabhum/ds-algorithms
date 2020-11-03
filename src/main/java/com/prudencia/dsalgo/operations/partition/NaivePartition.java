package com.prudencia.dsalgo.operations.partition;

public class NaivePartition {

    public int[] naivePartition (int arr[], int low, int high, int pointer) {

        int finalArr[] = new int[high -low +1];
        int index =0;

        for (int i=low; i<=high;i++){
            if(arr[i] <= arr[pointer]){
                finalArr[index] = arr[i];
                index++;
            }
        }
        for (int i=low; i<=high;i++){
            if(arr[i] > arr[pointer]){
                finalArr[index] = arr[i];
                index++;
            }
        }
       return finalArr;
    }

}
