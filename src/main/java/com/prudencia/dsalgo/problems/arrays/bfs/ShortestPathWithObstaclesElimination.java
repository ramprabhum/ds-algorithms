package com.prudencia.dsalgo.problems.arrays.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathWithObstaclesElimination {
    public int shortestPath(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] seen = new int[rows][cols];
        int[][] dirs= {{-1,0},{1,0},{0,1},{0,-1}};
        int steps = 0;

        for (int i = 0; i < rows; i++) {
            Arrays.fill(seen[i], Integer.MAX_VALUE);
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0,0,0});
        seen[0][0] = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            while(size >0) {
                size--;
                int[] cur= q.poll();
                if(cur[0] == rows-1 && cur[1] == cols-1) {
                    return steps;
                }
                for(int[] dir: dirs){
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x < 0 || x >= rows || y < 0 || y >= cols) {
                        continue;
                    }
                    int o = grid[x][y] + cur[2];
                    if (o >= seen[x][y] || o > k) {
                        continue;
                    }
                    seen[x][y] = o;
                    q.offer(new int[] {x,y, o});

                }

            }

            ++steps;

        }


        return -1;
    }

    public static void main(String[] args) {
        ShortestPathWithObstaclesElimination shortestPathWithObstaclesElimination = new ShortestPathWithObstaclesElimination();
        System.out.println(shortestPathWithObstaclesElimination.shortestPath(new int[][] {
                {0,0,0}, {1,1,0},{0,0,0},{0,1,1},{0,0,0}
        }, 1));

    }
}
