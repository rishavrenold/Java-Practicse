package Graphs;
import java.util.*;
public class CreationGraph {
    // static ArrayList<ArrayList<Integer>> graph;
    // static ArrayList<Integer> graphs[];

    // public static void create(int arr[][],int n)
    // {
    //     graph=new ArrayList<>();
    //     graphs=new ArrayList[n];
    //     for(int i=0;i<n;i++)
    //     {
    //         graph.add(new ArrayList<>());
    //     }
    //     for(int i=0;i<n;i++)
    //     {
    //         graphs[i]=new ArrayList<>();
    //     }
    //     for (int i = 0; i < arr.length; i++) {
    //         int u = arr[i][0] - 1;  
    //         int v = arr[i][1] - 1;  
    //         graph.get(u).add(v);
    //         graph.get(v).add(u); 
    //         graphs[u].add(v);
    //         graphs[v].add(u); 
    //     }
    // }

    // public static void print() {
    //     for (int i = 0; i < graph.size(); i++) {
    //         System.out.print(i + 1 + " -> "); 
    //         for (Integer neighbour : graph.get(i)) {
    //             System.out.print((neighbour + 1) + " ");
    //         }
    //         System.out.println();
    //     }
    // }
    // public static void print1() {
    //     for (int i = 0; i < graphs.length; i++) {
    //         System.out.print(i + 1 + " -> "); 
    //         for (Integer neighbour : graphs[i]) {
    //             System.out.print((neighbour + 1) + " ");
    //         }
    //         System.out.println();
    //     }
    // }

    static List<Integer> graph[];
    static List<List<Integer>> graph1=new ArrayList<>();
    public static void create1(int arr[][],int n)
    {
        graph=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            graph[i]=new ArrayList<>();
            graph1.add(new ArrayList<>());
        }
        for(int i=0;i<arr.length;i++)
        {
            int u=arr[i][0];
            int v=arr[i][1];
            graph[u].add(v);
            graph1.get(u).add(v);
            // graph[v].add(u);
            // graph1.get(v).add(u);
        }
    }

    public static void print()
    {
        for(int i=0;i<graph1.size();i++)
        {
            System.out.println(i+" -> "+graph1.get(i));
        }
    }
    public static void main(String[] args) {
        int arr[][] = {{0,1},{1,2},{2,3},{3,1},{1,4},{4,5},{5,6},{6,1},{1,7},{7,8},{8,9},{7,9}};
        int n=9;
        create1(arr,n);
        print();
        // System.out.println();
        // print1();
    }
}
