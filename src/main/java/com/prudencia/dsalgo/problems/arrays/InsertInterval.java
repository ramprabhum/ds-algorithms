package com.prudencia.dsalgo.problems.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int index=0;
        int intervalLen = intervals.length;
        LinkedList<int[]> result = new LinkedList();


        while(index < intervalLen && newStart > intervals[index][0] ){
            result.add(intervals[index]);
            index++;
        }

        int[] interval = new int[2];

        // if there is no overlap, just add the interval
        if (result.isEmpty() || result.getLast()[1] < newStart)
            result.add(newInterval);
            // if there is an overlap, merge with the last interval
        else {
            interval = result.removeLast();
            interval[1] = Math.max(interval[1], newEnd);
            result.add(interval);
        }

        // add next intervals, merge with newInterval if needed
        while (index < intervalLen) {
            interval = intervals[index];
            index++;
            int start = interval[0], end = interval[1];
            // if there is no overlap, just add an interval
            if (result.getLast()[1] < start) result.add(interval);
                // if there is an overlap, merge with the last interval
            else {
                interval = result.removeLast();
                interval[1] = Math.max(interval[1], end);
                result.add(interval);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
//Arrays.stream(insertInterval.insert(new int[][]{{1,3},{6,9}},new int[]{2,5})).forEach(ints -> );

        Arrays.stream(insertInterval.insert(new int[][]{{1,3},{6,9}},new int[]{2,5})).forEach((i) -> {
            System.out.print("[");
            Arrays.stream(i).forEach((j) -> System.out.print(j + " "));
            System.out.println("]");
        });
    }
}


