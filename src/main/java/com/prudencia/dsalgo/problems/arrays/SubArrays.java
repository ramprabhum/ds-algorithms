package com.prudencia.dsalgo.problems.arrays;

import java.util.ArrayList;
import java.util.List;

public class SubArrays {
        List<List<Integer>> output = new ArrayList();
        int n, k;

        public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {

            System.out.println("starting   k " + k +" first "+ first+" curr.size() " + curr.size() +" curr "+ curr +" output "+ output);
            // if the combination is done
            if (curr.size() == k) {
                output.add(new ArrayList(curr));
                return;
            }
            for (int i = first; i < n; ++i) {
                // add i into the current combination
                curr.add(nums[i]);
                // use next integers to complete the combination
                backtrack(i + 1, curr, nums);
                // backtrack
                curr.remove(curr.size() - 1);
                System.out.println("ending   k " + k +" first "+ first+" curr.size() " + curr.size() +" curr "+ curr + " output "+ output);
            }
        }

        public List<List<Integer>> subsets(int[] nums) {
            n = nums.length;
            for (k = 0; k < n + 1; ++k) {
                System.out.println("***********    "+k+"    **********");
                backtrack(0, new ArrayList<Integer>(), nums);
            }

            System.out.println(output);
            return output;
        }


    public static void main(String[] args) {
        SubArrays subArrays = new SubArrays();
        subArrays.subsets(new int[]{1,2,3});
    }

}
