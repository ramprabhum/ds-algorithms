package com.prudencia.dsalgo.problems.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WordBreakII {

    public static List<Integer> wordBreak(String s, List<String> wordDict) {
        List<String> result = new LinkedList<String>();
        if (s == null || s.length() == 0 || wordDict == null) {
            return null;
        }
        HashMap<Integer, List<Integer>> pointers = new HashMap<Integer, List<Integer>>();
        List<Integer> tmp = new LinkedList<Integer>();
        tmp.add(-1);
        pointers.put(-1, tmp);
        for (int j = 0; j < s.length(); j++) {
            pointers.put(j, new LinkedList<Integer>());
            for (int i = 0; i <= j; i++) {
                if (pointers.get(i - 1).size() > 0 && wordDict.contains(s.substring(i, j + 1))) {
                    pointers.get(j).add(i);
                }
            }
        }
        return null;

    }

    public static void main(String[] args) {
        System.out.println(wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
    }
    }