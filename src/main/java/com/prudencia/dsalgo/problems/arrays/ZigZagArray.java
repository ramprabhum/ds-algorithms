package com.prudencia.dsalgo.problems.arrays;

import java.util.ArrayList;
import java.util.List;

import java.util.*;

class Program {
    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {

        int height = array.size()-1;
        int width = array.get(0).size() -1;
        List<Integer> result = new ArrayList<Integer>();
        int row =0, column =0;
        boolean moveDown = true;
        while(!checkInValidPath(row,column,height,width)){
            result.add(array.get(row).get(column));
            if(moveDown) {
                if (column == 0 || row == height) {
                    moveDown = false;
                    if(row == height) {
                        column++;
                    } else {
                        row++;
                    }
                } else {
                    row++;
                    column--;
                }
            } else {

                if( row ==0 || column == width) {
                    moveDown = true;
                    if(column == width){
                        row++;
                    }
                    else {
                        column++;
                    }
                } else {
                    row--;
                    column++;
                }
            }
        }
        return result;
    }

    public static boolean checkInValidPath(int row, int column ,int height, int width){

        return row < 0 || row > height || column < 0 || column > width;

    }



}

