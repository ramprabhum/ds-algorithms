package com.prudencia.dsalgo.problems.arrays;

public class SortedSquares {

    public int[] sortedSquares(int[] nums) {

        int len = nums.length;
        int[] result = new int[len];
        int right = 0;

        while(right < len && nums[right] < 0){
            right++;
        }

        int left = right-1;
        int i=0;

        while(left >=0 && right < len){
            if(nums[left]* nums[left] < nums[right] * nums[right]){
                result[i] = nums[left]* nums[left];
                left--;
                i++;
            } else {
                result[i] = nums[right]* nums[right];
                right++;
                i++;
            }
        }

        while(left >=0) {
            result[i] = nums[left]* nums[left];
            i++;
            left--;
        }
        while(right < len){
            result[i] = nums[right]* nums[right];
            right++;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        SortedSquares sortedSquares = new SortedSquares();
        sortedSquares.sortedSquares(new int[]{-4,-1,0,3,10});
    }
}
