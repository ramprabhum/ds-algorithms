package com.prudencia.dsalgo.operations.set;

public class DisjointSet {

    public int parent[];

    public void initialize(){
        for(int i=0; i<parent.length;i++)
            parent[i] = i;
    }

    public int find(int n) {
        if(parent[n] == n) {
            return n;
        } else {
            return find(parent[n]);
        }
    }

    public void union(int a, int b) {
       int a_parent  = find(a);
       int b_parent  = find(b);

       if(a_parent == b_parent)
           return;

       parent[b_parent] = a_parent;

    }


    public static void main(String[] args) {
        DisjointSet disjointSet = new
                DisjointSet();
        disjointSet.parent = new int[5];
        disjointSet.initialize();
        disjointSet.union(0, 2);
        disjointSet.union(0, 4);

        System.out.println(disjointSet.parent);
        System.out.println(disjointSet.find(4));
        System.out.println(disjointSet.find(3));

    }
}
