package com.prudencia.dsalgo.operations.set;

public class DisjointSetRank {
    public int parent[];
    public int rank[];

    public void initialize(){
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }
    public int find(int n) {
        if(parent[n] == n) {
            return n;
        } else {
            return find(parent[n]);
        }
    }

    public void union(int a, int b){
        int a_parent = find(a);
        int b_parent = find(b);

        if(a_parent == b_parent)
            return;

        if(rank[a_parent] < rank[b_parent]) {
            parent[a_parent] = b_parent;
        }
        else if(rank[a_parent] > rank[b_parent])
            parent[b_parent] = a_parent;
        else{
            parent[b_parent]  = a_parent;
            rank[a_parent]++;
        }

    }

    public static void main(String[] args) {
        DisjointSetRank disjointSetRank = new DisjointSetRank();


        int n = 5;

        disjointSetRank.parent = new int[5];
        disjointSetRank.rank = new int[5];

        disjointSetRank.initialize();

        disjointSetRank.union(3,4);
        disjointSetRank.union(2,3);
        disjointSetRank.union(1,2);
        disjointSetRank.union(0,1);


        System.out.println(disjointSetRank.parent[3]);
        System.out.println(disjointSetRank.rank[3]);

    }
}
