package com.prudencia.dsalgo.problems.arrays;

import java.util.LinkedList;

public class RemoveKdigits {

    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<Character>();

        for(char digit : num.toCharArray()) {
            while(stack.size() > 0 && k > 0 && stack.peekLast() > digit) {
                stack.removeLast();
                k -= 1;
            }
            stack.addLast(digit);
        }

        System.out.println("******" +stack);
        /* remove the remaining digits from the tail. */
        for(int i=0; i<k; ++i) {
            stack.removeLast();
        }

        System.out.println("^^^^^^^" +stack);


        // build the final string, while removing the leading zeros.
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        for(char digit: stack) {
            if(leadingZero && digit == '0') continue;
            leadingZero = false;
            ret.append(digit);
        }

        /* return the final string  */
        if (ret.length() == 0) return "0";
        return ret.toString();
    }

    public static void main(String[] args) {
        RemoveKdigits removeKdigits = new RemoveKdigits();
        System.out.println(removeKdigits.removeKdigits("12345264",4));
    }
}
