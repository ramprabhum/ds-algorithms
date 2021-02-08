package com.prudencia.dsalgo.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ShortestToChar  {

    public int[] shortestToChar(String s, char c) {

        int[] result = new int[s.length()];
        int previous = Integer.MIN_VALUE/2;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == c){
                previous = i;
            }
            result[i] = i - previous;
        }

        Arrays.stream(result).forEach(i -> System.out.println(i));
        System.out.println("****");

        previous = Integer.MAX_VALUE/2;
        for(int i=s.length()-1;i >=0;i--){
            if(s.charAt(i) == c){
                previous = i;
            }

            result[i] = Math.min(result[i],previous-i);


        }
        Arrays.stream(result).forEach(i -> System.out.println(i));

        return result;

    }

    public static void main(String[] args) {
        ShortestToChar shortestToChar = new ShortestToChar();
        shortestToChar.shortestToChar("loveleetcode",'e');
    }
//    public int[] shortestToChar(String s, char c) {
//        ArrayList charlist<int> = new ArrayList<>();
//        charlist.add(-99999);
//        int result = new int[s.length()];
//
//        for(int i=0;i<s.length();s++){
//            if(s[i] == c){
//                charlist.add(i);
//            }
//        }
//
//        charlist.add(999999);
//
//        int first = charlist.get(0);
//        int second = charlist.get(1);
//        int j =2;
//
//        for(int i=0;i<s.length();s++){
//
//            if(s.charAt(i)!=c){
//                result[i]= Math.min(i-first,second-i);
//
//            } else {
//                first = second;
//                second = l.get(k++);
//                result[i] = 0;
//            }
//
//        }
//
//        return result;
//
//
//    }
}
