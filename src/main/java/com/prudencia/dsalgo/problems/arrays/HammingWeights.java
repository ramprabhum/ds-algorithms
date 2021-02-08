package com.prudencia.dsalgo.problems.arrays;

public class HammingWeights {

    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
            System.out.println("*****");
            System.out.println(n);
            System.out.println(n-1);
            System.out.println(n & n-1);
            System.out.println("*****");
        }
        return sum;
    }

    public static void main(String[] args) {
        HammingWeights hammingWeights = new HammingWeights();
        System.out.println(hammingWeights.hammingWeight(001011));
    }
}


