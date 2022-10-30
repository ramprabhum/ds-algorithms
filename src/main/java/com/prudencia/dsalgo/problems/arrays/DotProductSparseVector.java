package com.prudencia.dsalgo.problems.arrays;

import java.util.HashMap;
import java.util.Map;

public class DotProductSparseVector {

    public static void main(String[] args) {
        SparseVector v1 = new SparseVector(new int[] {1,0,0,2,3});
        SparseVector v2 = new SparseVector(new int[] {0,3,0,4,0});
        int ans = v1.dotProduct(v2);
        System.out.println(ans);
    }


}

class SparseVector {


    Map<Integer, Integer> mapping;

    SparseVector(int[] nums) {
        mapping = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                mapping.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {

        int result = 0;

        // iterate through each non-zero element in this sparse vector
        // update the dot product if the corresponding index has a non-zero value in the other vector
        for (Integer i : this.mapping.keySet()) {
            if (vec.mapping.containsKey(i)) {
                result += this.mapping.get(i) * vec.mapping.get(i);
            }
        }
        return result;

    }
}
