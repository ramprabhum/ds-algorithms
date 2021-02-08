package com.prudencia.dsalgo.operations.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class SegmentTree {
    public static void main(String[] args) {
        int size=4;
        SegmentTree segmentTree = new SegmentTree(size);
//        segmentTree.arr = new int[]{10, 20, 30, 40};
//        System.out.println(segmentTree.constructSegmentTree(0, size - 1, 0));
//        System.out.println(Arrays.toString(segmentTree.tree));
//        System.out.println(segmentTree.querySum(0, 2, 0, 3, 0));
//        segmentTree.updateRecord(0, 3, 0, 5, 1);
//        System.out.println(Arrays.toString(segmentTree.tree));
//
//        size=3;
//        segmentTree = new SegmentTree(size);
//        segmentTree.arr = new int[]{1,3,5};
//        System.out.println(segmentTree.constructSegmentTree(0, size - 1, 0));
//        System.out.println(Arrays.toString(segmentTree.tree));
//        System.out.println(segmentTree.querySum(0, 2, 0, 2, 0));
//        //segmentTree.updateRecord(0, 3, 0, 5, 1);
//        System.out.println(Arrays.toString(segmentTree.tree));
//        segmentTree.updateRecord(0, 2, 0, -1, 1);
//        System.out.println(Arrays.toString(segmentTree.tree))
//
//["NumArray","update","update","update","sumRange","update","sumRange","update","sumRange","sumRange","update"]

//[[[7,2,7,2,0]],[4,6],[0,2],[0,9],[4,4],[3,8],[0,4],[4,1],[0,3],[0,4],[0,4]
//[null,null,null,null,6,null,32,null,26,27,null]


        size=5;
        segmentTree = new SegmentTree(size);
        segmentTree.arr = new int[]{7,2,7,2,0};
        System.out.println(segmentTree.constructSegmentTree(0, size - 1, 0));
        System.out.println(Arrays.toString(segmentTree.tree));
        segmentTree.updateRecord(0, 4, 0, segmentTree.arr[4]-6, 4);
        System.out.println(Arrays.toString(segmentTree.tree));
        segmentTree.updateRecord(0, 4, 0, segmentTree.arr[0]-2, 0);
        System.out.println(Arrays.toString(segmentTree.tree));
        segmentTree.updateRecord(0, 4, 0, -5, 0);
        System.out.println(Arrays.toString(segmentTree.tree));








    }

     int tree[] = null;
     int arr[] = null;
    public SegmentTree(int size){
        tree = new int[4*size];
    }

    public int constructSegmentTree(int segStart, int segEnd, int segIndex){
        if(segStart == segEnd) {
            tree[segIndex] = arr[segStart];
            return arr[segStart];
        }

        int mid = (segStart + segEnd) / 2;

        tree[segIndex] = constructSegmentTree(segStart, mid, 2 * segIndex + 1)
                +constructSegmentTree(mid + 1, segEnd, 2 * segIndex + 2);

        return tree[segIndex];

    }

    public int querySum(int queryStart, int queryEnd,int segStart, int segEnd, int segIndex){
        if(segEnd<queryStart || segStart >queryEnd)
            return 0;
        if(queryStart<=segStart && queryEnd >= segEnd)
            return tree[segIndex];


        int mid = (segStart + segEnd) / 2;

        return querySum(queryStart, queryEnd, segStart, mid, 2 * segIndex + 1)
                + querySum(queryStart, queryEnd, mid + 1, segEnd, 2 * segIndex + 2);

    }


    public void updateRecord(int segStart, int segEnd, int segIndex,int diff, int i){
        if(i < segStart || i > segEnd)
            return;

        tree[segIndex] = tree[segIndex] + diff;

        if(segEnd > segStart)
        {
            int mid = (segStart + segEnd) / 2;

            updateRecord(segStart, mid, 2 * segIndex + 1, diff,i);
            updateRecord(mid + 1, segEnd, 2 * segIndex + 2, diff,i);

        }

    }



}
