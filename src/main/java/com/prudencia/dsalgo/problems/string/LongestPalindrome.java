package com.prudencia.dsalgo.problems.string;

public class LongestPalindrome {

    public String longestPalindrome(String s) {

        if(s == null || s.length() < 1)
            return "";

        int start =0;
        int end =0;

        for(int i=0; i<s.length();i++) {

            int lengthOdd = this.checkFromMiddle(s,i,i); //"abba"
            int lenghtEven = this.checkFromMiddle(s,i,i+1); //"abcba"
            int finalLen = Math.max(lengthOdd,lenghtEven);

            if(finalLen > end - start) {

                start = i- ((finalLen-1)/2);
                end = i +( finalLen/2);

            }

        }
        return s.substring(start,end+1);
    }

    public int checkFromMiddle(String str, int left, int right){
        int leftIndex =  left;
        int rightIndex =  right;

        while(leftIndex >=0 && rightIndex < str.length() &&
                str.charAt(leftIndex) == str.charAt(rightIndex)){
            leftIndex--;
            rightIndex++;
        }

        return rightIndex - leftIndex - 1;
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("cabad"));
        System.out.println(longestPalindrome.longestPalindrome("racecar"));
    }
}
