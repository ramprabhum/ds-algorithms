package com.prudencia.dsalgo.sort;

public class MergeSort {

    public void mergeSort(int arr[], int left, int right) {

        if (left < right) {
            // Find the middle point
            int mid = (left + right) / 2;

            // Sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }

    }

    private void merge(int[] arr, int left, int mid, int right) {
        System.out.println("********************");
        System.out.println("left "+left+" mid "+mid+" right "+right);
        int leftArrLen = mid -left + 1;
        int rightArrLen = right -mid;

        int leftArr[]  = new int[leftArrLen];
        int rightArr[] = new int[rightArrLen];

        for (int i = 0; i < leftArrLen; ++i)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < rightArrLen; ++j)
            rightArr[j] = arr[mid + 1 + j];
        for (int i = 0; i < leftArr.length; ++i)
            System.out.print(leftArr[i] + " ");
        System.out.println("****");
        for (int i = 0; i < rightArr.length; ++i)
            System.out.print(rightArr[i] + " ");
        System.out.println("****");

        int i = 0, j = 0;

        // Initial index of merged subarry array 
        int k = left;
        while (i < leftArrLen && j < rightArrLen) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            }
            else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < leftArrLen) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < rightArrLen  ) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }


    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int arr[] = new int[] {3,7,2,1,4,5,9,8,10};
        mergeSort.mergeSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
    }

}
