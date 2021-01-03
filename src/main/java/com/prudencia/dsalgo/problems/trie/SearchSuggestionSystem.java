package com.prudencia.dsalgo.problems.trie;

import java.util.*;

//https://leetcode.com/problems/search-suggestions-system/

public class SearchSuggestionSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord, Trie trie1) {
        String prefix = new String();
        List<List<String>> result = new ArrayList<>();
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            result.add(trie1.typeaheadKeywords(prefix));
        }

        return result;
    }

    public static void main(String[] args) {

        SearchSuggestionSystem searchSuggestionSystem = new SearchSuggestionSystem();
        Trie trie = new Trie();
        trie.insert("root");
        trie.insert("roote");
        trie.insert("roater");
        trie.insert("robr");
        trie.insert("bird");
        System.out.println(searchSuggestionSystem.suggestedProducts(null,"root",trie));
        //trie.print(trie.root);

        // List<String> lstString = trie.searchKeywords("root");
    }
}

class Trie {

    Node root;
    Node curr;
    class Node {
        public boolean isEOW = false;
        public Map<Integer,Node> children = new HashMap<>();
    }

    Trie(){
        root= new Node();
    }

    List<String> resultList;

    public void insert(String s){
        curr = root;
        for(char c:s.toCharArray()){
            if(!curr.children.containsKey(c-'a')){
                curr.children.put(c-'a',new Node());
            }
            curr = curr.children.get(c-'a');
        }
        curr.isEOW = true;
    }

    public List<String> typeaheadKeywords(String str) {
        curr = root;
        resultList = new ArrayList<String>();
        // Move curr to the end of prefix in its trie representation.
        for (char c : str.toCharArray()) {
            if (curr.children.get(c - 'a') == null)
                return resultList;
            curr = curr.children.get(c - 'a');
        }
        dfsTypeahead(curr, str);
        return resultList;

    }

    void dfsTypeahead(Node curr, String word) {
        if (resultList.size() == 3)
            return;
        if (curr.isEOW)
            resultList.add(word);

        // Run DFS on all possible paths.
        for (char c = 'a'; c <= 'z'; c++)
            if (curr.children.get(c - 'a') != null)
                dfsTypeahead(curr.children.get(c - 'a'), word + c);
    }
//    public void print(Node node){
//        print(node, "");
//    }

//    public void print(Node node,String str) {
//
//        if (node.children == null || node.isEOW)
//            System.out.println(str);
//        Set<Map.Entry<Integer, Node>> entry = node.children.entrySet();
//        Iterator<Map.Entry<Integer, Node>> iterator = node.children.entrySet().iterator();
//        while(iterator.hasNext()) {
//            Map.Entry<Integer, Node> entry1 = iterator.next();
//            char cha = (char) ('a'+ entry1.getKey());
//            print(entry1.getValue(),str + cha);
//        }
//    }

}

