package com.prudencia.dsalgo.search;

public class BinarySearch {

    public int binarySearchRecursive(int arr[], int low, int high, int num){

        if (low >high)
            return -1;

        int mid = (low +high )/2;

        if(arr[mid] ==num)
            return mid;
        else if (arr[mid] > num)
            return binarySearchRecursive(arr,low,mid-1,num);
        else
            return binarySearchRecursive(arr,mid+1,high,num);

    }

    public  int binarySearchIterative(int arr[], int length, int num)
    {
        int low = 0, high = length - 1;

        while(low <= high)
        {
            int mid = (low + high) / 2;

            if(arr[mid] == num)
                return mid;

            else if(arr[mid] > num)
                high = mid - 1;

            else
                low = mid + 1;
        }

        return -1;
    }
}
