package com.prudencia.dsalgo.problems.arrays;

class SplitArrayLargest {
    // Defined it as per the maximum size of array and split count
    // But can be defined with the input size as well
    Integer[][] memo = new Integer[5][5];

    private int getMinimumLargestSplitSum(int[] prefixSum, int currIndex, int subarrayCount) {
        int n = prefixSum.length - 1;

        // We have already calculated the answer so no need to go into recursion
        if (memo[currIndex][subarrayCount] != null) {
            return memo[currIndex][subarrayCount];
        }

        // Base Case: If there is only one subarray left, then all of the remaining numbers
        // must go in the current subarray. So return the sum of the remaining numbers.
        if (subarrayCount == 1) {
            return memo[currIndex][subarrayCount] = prefixSum[n] - prefixSum[currIndex];
        }

        // Otherwise, use the recurrence relation to determine the minimum largest subarray
        // sum between currIndex and the end of the array with subarrayCount subarrays remaining.
        int minimumLargestSplitSum = Integer.MAX_VALUE;
        for (int i = currIndex; i <= n - subarrayCount; i++) {

            System.out.println( "i " + i+ "currIndex " + currIndex+ " subarrayCount " + subarrayCount  );
            // Store the sum of the first subarray.
            int firstSplitSum = prefixSum[i + 1] - prefixSum[currIndex];

            System.out.println( "firstSplitSum " + firstSplitSum+ " prefixSum[i + 1] " + prefixSum[i + 1] + "  prefixSum[i] "+ prefixSum[i]);


            // Find the maximum subarray sum for the current first split.
            int largestSplitSum = Math.max(firstSplitSum,
                    getMinimumLargestSplitSum(prefixSum, i + 1, subarrayCount - 1));

            System.out.println( "largestSplitSum " + firstSplitSum+ " minimumLargestSplitSum " + minimumLargestSplitSum);

            // Find the minimum among all possible combinations.
            minimumLargestSplitSum = Math.min(minimumLargestSplitSum, largestSplitSum);

            if (firstSplitSum >= minimumLargestSplitSum) {
                System.out.println( "*****************************************");
                break;
            }
        }

        System.out.println("currIndex "+ currIndex + " subarrayCount "+ subarrayCount);
        return memo[currIndex][subarrayCount] = minimumLargestSplitSum;
    }

    public Integer[][] getMemo(){
        return  this.memo;
    }

    public int splitArray(int[] nums, int m) {
        // Store the prefix sum of nums array.
        int n = nums.length;
        int[] prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
            System.out.println(" i "+ i +" nums "+ nums[i] +" prefixSum[i] "+ prefixSum[i]+" prefixSum[i+1] "+prefixSum[i+1]);
        }

        return getMinimumLargestSplitSum(prefixSum, 0, m);
    }

    public static void main(String[] args) {
        SplitArrayLargest splitArrayLargest = new SplitArrayLargest();
        System.out.println(splitArrayLargest.splitArray(new int[]{7,2,5,10,8,},2));
        Integer[][] output  = splitArrayLargest.getMemo();
        for(int i=0; i<output.length;i++){
            for(int j=0;j<output[0].length;j++){
                if(output[i][j] != null)
                System.out.println("i "+i+" j "+ j +" output"+ output[i][j]);
            }
        }
    }
}