package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class DetectCycle {
    static ArrayList<ArrayList<Integer>> graph;

    public static void create(int arr[][], int n) {
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < arr.length; i++) {
            int u = arr[i][0];
            int v = arr[i][1];
            graph.get(u).add(v);
            // graph.get(v).add(u);
        }
    }
    

    
    // static ArrayList<Integer> prefixorder=new ArrayList<>();
    // public static boolean checkCycle(int node, int par, int[] visited,int parent[],int currcycle[]) {
    //     visited[node] = 1; 
    //     parent[node]=par; 
    //     for (Integer neighbour : graph.get(node)) {
    //         if (visited[neighbour] == 0) {  
    //             if (checkCycle(neighbour, node, visited,parent,currcycle)) {
    //                 return true;
    //             }
    //         } else if (visited[neighbour]==1)//neighbour != par
    //          {  
    //             if(is_cycle==0)
    //             {
    //                 loopst=neighbour;
    //                 loopen=node;
    //             }
    //             currcycle[neighbour]=1;
    //             currcycle[parent[node]]=-1;
    //             is_cycle=1;
    //             return true;
    //         }
    //     }
    //     visited[node]=2;
    //     prefixorder.add(node);
    //     return false;
    // }

    static int is_cycle=0;
    static int loopst=-1;
    static int loopen=-1;
    static ArrayList<Integer> prefixorder=new ArrayList<>();
    public static void check(int node, int par,int visited[],int parent[],int currcycle[])
    {
        visited[node]=1;
        parent[node]=par;
        for(Integer neighbour:graph.get(node))
        {
            if(visited[neighbour]==0)
            {
                check(neighbour, node, visited, parent, currcycle);
            }else if(visited[neighbour]==1)
            {
                if(is_cycle==0)
                {
                    loopst=neighbour;
                    loopen=node;
                    while(loopen!=loopst)
                    {
                        System.out.println(loopen);
                        loopen=parent[loopen];
                    }
                    System.out.println(loopst);
                }
                is_cycle=1;
                currcycle[parent[neighbour]]--;
                currcycle[node]++;
            }
        }
        visited[node]=2;
        prefixorder.add(node);
    }

    public static void main(String[] args) {
        int arr[][] = {{0,1},{1,2},{2,3},{3,1},{1,4},{4,5},{5,6},{6,1},{1,7},{7,8},{8,9},{7,9}};
        int n =10; 
        create(arr, n);
        int visited[] = new int[n];
        int parent[] = new int[n];
        int currcycle[]=new int[n];
        Arrays.fill(visited, 0);

        // boolean hasCycle = false;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {  
                check(i, -1, visited,parent,currcycle);
                    // hasCycle = true;
                    // break;
                }
            }

        // print any cycle
        // ArrayList<Integer> loop=new ArrayList<>();
        // while(loopen!=loopst)
        // {
        //     loop.add(loopen);
        //     loopen=parent[loopen];
        // }
        // loop.add(loopst);
        // System.out.println(loop);

        //nodes which are partof sum cycle
        for(Integer ii:prefixorder)
        {
            currcycle[parent[ii]]+=currcycle[ii];
        }

        System.out.println(prefixorder);



        // if (is_cycle==1) {
        //     System.out.println("Cycle detected in the graph.");
        // } else {
        //     System.out.println("No cycle detected in the graph.");
        // }
    }
}
