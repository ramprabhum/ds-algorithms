package com.prudencia.dsalgo.operations.array;

public class ArrayContinous {

        public int[] searchRange(int[] nums, int target) {
            int[] result = {-1,-1};
            int leftIdx = extremeIndex(nums, target, true);

            // assert that `leftIdx` is within the array bounds and that `target`
            // is actually in `nums`.
            if (leftIdx == nums.length || nums[leftIdx] != target) {
                return result;
            }

            result[0] = leftIdx;
            result[1] = extremeIndex(nums, target, false)-1;

            return result;


        }


        private int extremeIndex(int nums[], int target, boolean left) {
            int lo = 0;
            int hi = nums.length;

            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (nums[mid] > target || (left && target == nums[mid])) {
                    hi = mid;
                }
                else {
                    lo = mid+1;
                }
            }

            return lo;

        }

    public static void main(String[] args) {
        ArrayContinous t = new ArrayContinous();
        System.out.println(t.searchRange(new int[]{5,6,7,8,8,10},8)[0]);
        System.out.println(t.searchRange(new int[]{5,6,7,8,8,10},8)[1]);

    }

}

