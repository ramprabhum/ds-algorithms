package com.prudencia.dsalgo.problems.arrays.matrix;

import java.util.*;

class IslandRemove {

    int[][] directions = {{0,-1},{0,1},{1,0},{-1,0}};
    public int[][] removeIslands(int[][] matrix) {

        for(int row=0; row < matrix.length; row++){
            for(int col=0; col< matrix[0].length; col++){

                if( row == 0 || row == matrix.length-1 || col ==0 || col == matrix[0].length-1) {

                    if(matrix[row][col] ==1) {
                        dfsMatrix(matrix,row,col);
                    }

                }

            }
        }

        for(int row=0; row < matrix.length; row++){
            for(int col=0; col< matrix[0].length; col++){
                if(matrix[row][col] ==1) {
                    matrix[row][col] = 0;
                } else if (matrix[row][col] ==2){
                    matrix[row][col] = 1;
                }

            }
        }


        return matrix;
    }


    public void dfsMatrix(int[][] matrix,int matRow,int matCol) {
        matrix[matRow][matCol] =2;
        for(int i=0; i<directions.length; i++){
            int row = matRow + directions[i][0];
            int col = matCol + directions[i][1];

            if(row <0 || row >= matrix.length || col <0 || col >= matrix[0].length
                    || matrix[row][col] ==0 || matrix[row][col]==2 ) {
                continue;
            }
            dfsMatrix(matrix,row,col);

        }


    }
}

