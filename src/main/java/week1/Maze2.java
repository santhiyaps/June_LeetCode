package week1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Maze2 {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int [][]dist=new int[maze.length][maze[0].length];
        for(int arr[]:dist)
             Arrays.fill(dist,Integer.MAX_VALUE);
        Queue<int[]> queue=new LinkedList<>();
        queue.add(start);
        dist[start[0]][start[1]]=0;
        while(!queue.isEmpty()){
            int[]curr=queue.poll();
            for(int[] dir:dirs){
               int x=curr[0]+dir[0];
                int y=curr[1]+dir[1];
                int count=0;
               while(x>=0 && y>=0 && x<maze.length && y<maze[0].length && maze[x][y]==0) {
                   x+=dir[0];
                   y+=dir[1];
                   count++;
               }
               if(dist[curr[0]][curr[1]]+count< dist[x-dir[0]][y-dir[1]]){
                   dist[x-dir[0]][y-dir[0]]=dist[curr[0]][curr[1]]+count;
                   queue.add(new int[]{x-dir[0],y-dir[1]});
               }
            }
        }
        return dist[destination[0]][destination[1]]==Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]];
    }
}
