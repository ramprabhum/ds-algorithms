package com.prudencia.dsalgo.operations.graph;

import java.util.ArrayList;
import java.util.Iterator;

public class DFS {

    private int V; // No. of vertices

    // Array  of lists for
    // Adjacency List Representation
    private ArrayList<ArrayList<Integer>> adj;

    public DFS(int v) {
        this.V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++)
            adj.add(i, new ArrayList<>());
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w); // Add w to v's list.
    }


    // The function to do DFS traversal.
    // It uses recursive
    // DFSUtil()
    void DFSTraverse(int v)
    {
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper
        // function to print DFS
        // traversal
        DFSUtil(v, visited);
    }
    // A function used by DFS
    void DFSUtil(int v, boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> i = adj.get(v).listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
    // Driver Code
    public static void main(String args[])
    {
        DFS g = new DFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");

        g.DFSTraverse(2);
    }
}
