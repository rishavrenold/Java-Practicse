package Graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;


public class _01BFS {
    static class Pair{
        int x;int y;
        Pair(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    static int dx[]={0,0,1,-1};
    static int dy[]={1,-1,0,0};
    public static int minCost(int n,int m,int graph[][],int srcx,int srcy,int desx , int desy)
    {
        ArrayDeque<Pair> q= new ArrayDeque<>();
        int dis[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dis[i],(int)1e9);
        }
        q.offer(new Pair(srcx,srcy));
        dis[srcx][srcy]=0;
        while(!q.isEmpty())
        {
            Pair curr=q.poll();
            for(int i=0;i<4;i++)
            {
                int new_x=curr.x+dx[i];
                int new_y=curr.y+dy[i];
                int wt=(i+1==graph[curr.x][curr.y])?0:1;
                if(new_x>=0 && new_x<n && new_y>=0 && new_y<m && dis[new_x][new_y]>dis[curr.x][curr.y]+wt)
                {
                    dis[new_x][new_y]=dis[curr.x][curr.y]+wt;
                    if(wt==0)
                    {
                        q.addFirst(new Pair(new_x,new_y));
                    }else{
                        q.addLast(new Pair(new_x,new_y));
                    }
                }
            }
        }
        return dis[desx][desy];
    }
    /*
     *  4 4
        1 1 1 1
        2 2 2 2
        1 1 1 1
        2 2 2 2 

     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=4;
        int m=4;
        int graph[][]={{1 ,1 ,1 ,1},
                        {2 ,2, 2, 2},
                        {1 ,1 ,1 ,1},
                        {2, 2, 2 ,2} 
                       };
                       
        System.out.println(minCost(n,m,graph,0,0,n-1,m-1));
        

    }
}
