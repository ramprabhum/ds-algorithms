package com.prudencia.dsalgo.problems.arrays.matrix;

class MatrixSearch {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row  = matrix.length;
        if(row == 0){
            return false;
        }
        int column = matrix[0].length;



        int left = 0;
        int right = row * column - 1;
        int mid = 0;
        int midElement = 0;

        while(left <= right) {


            mid  = (left + right)/2 ;

            System.out.println("left "+left+" right "+right+" mid "+mid+ " mid/column "+ mid/column + " mid%column " +mid%column );

            midElement = matrix[mid/column][mid%column];



            if(target == midElement){
                return true;
            } else {
                if (target < midElement){
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        MatrixSearch  matrixSearch = new MatrixSearch();
        System.out.println(matrixSearch.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,6}},30));

    }
}