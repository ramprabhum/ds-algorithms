package com.prudencia.dsalgo.problems.arrays;

import java.util.HashMap;

public class SubarraySum {
    public static void main(String[] args) {

        int nums[] = new int[]{1,1,1};

        System.out.println("result "+subarraySum(nums,2));

    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            System.out.println(" i "+i+" map "+map+" sum "+sum + " count "+ count + " (sum -k) " + (sum -k));
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            System.out.println(" i "+i+" map "+map+ " count "+ count);
        }
        return count;
    }
}
