package com.prudencia.dsalgo.problems.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static int wordCount(String[] startWords, String[] targetWords) {
         Set<String> startSet = new HashSet<>();
        for(String word : startWords) {
            int[] chs = new int[26];
            for(char c : word.toCharArray()) {
                int i = c - 'a';
                chs[i]++;
            }
            startSet.add(String.valueOf(chs));
        }
        
        for (String s : startSet) {
            System. out. println(Arrays.toString(s.toCharArray()));
            }
        int res = 0;
        for(String word : targetWords) {
            int[] chs = new int[26];
            for(char c : word.toCharArray()) {
                chs[c - 'a']++;
            }
            for(int i = 0; i < 26; ++i) {
                if(chs[i] == 0) continue;
                chs[i]--;
                String newStr = String.valueOf(chs);
                if(startSet.contains(newStr)) {
                    
                    res++;
                    break;
                }
                chs[i]++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(wordCount(new String[] {"ant","act","tack"}, new String[]{"tack","act","acti"}));
    }
}