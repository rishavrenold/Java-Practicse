package Graphs;

import java.util.*;

public class HasPath {
    static class Pair{
        int node;
        int wt;
        Pair(int node,int wt)
        {
            this.node=node;
            this.wt=wt;
        }
    }

    public static void create(List<List<Pair>> graph,int data[][])
    {
        for(int i=0;i<data.length;i++)
        {
            int u=data[i][0];
            int v=data[i][1];
            int wt=data[i][2];

            graph.get(u).add(new Pair(v,wt));
        }
    }

    public static void display(List<List<Pair>> graph)
    {
        for(int i=0;i<7;i++)
        {
            if(graph.get(i).isEmpty())
            {
                break;
            }
            System.out.print(i+" -> ");
            for(Pair neigh:graph.get(i))
            {
                System.out.print("[ "+neigh.node+ " - "+ neigh.wt+" ]");
            }
            System.out.println();
        }
    }

    public static boolean hasPath(List<List<Pair>> graph,int src, int des)
    {
        if(src==des)
        {
            return true;
        }
        for(Pair neigh:graph.get(src))
        {
            boolean ans=hasPath(graph,neigh.node, des);
            if(ans==true)
            {
                return true;
            }
        }
        return false;
    }

    public static void printAllPaths(List<List<Pair>> graph,int src,int des,String psf,int visited[])
    {
        if(src==des)
        {
            psf+=" "+src;
            System.out.println(psf);
            return;
        }
        visited[src]=1;
        for(Pair p:graph.get(src))
        {
            if(visited[p.node]==0)
            {
                printAllPaths(graph, p.node, des, psf+" "+src, visited);
            }
        }
        visited[src]=0;
    }

    public static void main(String[] args) {
        int data[][]={
            {0,1,10},
            {0,3,40},
            {1,2,10},
            {2,3,10},
            {3,4,12},
            {4,5,8},
            {5,6,3}
        };
        List<List<Pair>> graph=new ArrayList<>();
        for(int i=0;i<7;i++)
        {
            graph.add(new ArrayList<>());
        }
        create(graph,data);
        // display(graph);
        int visited[]=new int[7];
        printAllPaths(graph, 0, 6, "", visited);
        // System.out.println(hasPath(graph,0,5));

    }
}
