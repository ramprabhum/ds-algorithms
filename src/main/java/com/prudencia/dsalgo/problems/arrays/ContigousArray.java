package com.prudencia.dsalgo.problems.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContigousArray {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,0,0,0,1,1};
        System.out.println(findMaxLength(nums));
    }

//    public static int findMaxLength(int[] nums) {
//
//        int[] arr = new int[2 * nums.length + 1];
//        Arrays.fill(arr,-2);
//        arr[nums.length] = -1;
//        int maxlen = 0, count = 0;
//
//        System.out.println("---");
//        Arrays.stream(arr).forEach(System.out::print);
//        System.out.println("*************************");
//
//        for (int i = 0; i < nums.length; i++) {
//            count = count + (nums[i] == 0 ? -1 : 1);
//            System.out.println(i + " i  **" + count +" count");
//            if (arr[count + nums.length] >= -1) {
//                System.out.println(maxlen + " maxlen  "+ (i - arr[count + nums.length]) + " val" );
//                maxlen = Math.max(maxlen, i - arr[count + nums.length]);
//            } else {
//                System.out.println(i + " i " + count + nums.length+ " val");
//                        arr[count + nums.length] = i;
//            }
//            System.out.println("---");
//            Arrays.stream(arr).forEach(System.out::print);
//        }
//        return maxlen;
//
//    }
//0,0,1,0,0,0,1,1
    public static  int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        System.out.println("***"+map);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            System.out.println("**count************"+count + " num " + nums[i]);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
                System.out.println("maxlen  "+maxlen+"val"+ (i - map.get(count)));

            } else {
                map.put(count, i);
            }
            System.out.println("map"+map);
        }
        return maxlen;
    }
}
