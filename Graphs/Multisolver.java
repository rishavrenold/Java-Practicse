package Graphs;
import java.util.*;

public class Multisolver {
    static class Pair{
        int node;
        int wt;
        Pair(int node,int wt)
        {
            this.node=node;
            this.wt=wt;
        }
    }
    static class Pair1 implements Comparable<Pair1>{
        String psf;
        int wt;
        Pair1(String psf,int wt)
        {
            this.psf=psf;
            this.wt=wt;
        }
        public int compareTo(Pair1 o)
        {
            return this.wt-o.wt;
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
    //s->shortest, l->longest
    // static String spath;
    // static Integer spathwt=Integer.MAX_VALUE;
    // static String lpath;
    // static Integer lpathwt=Integer.MIN_VALUE;
    // static String cpath;
    // static Integer cpathwt=Integer.MAX_VALUE;
    // static String fpath;
    // static Integer fpathwt=Integer.MIN_VALUE;
    // static PriorityQueue<Pair1> pq= new PriorityQueue<>();

    // public static void multisolver(List<List<Pair>> graph, int src, int des,int visited[],int factor,int k, String psf, int wsf)
    // {
    //     if(src==des)
    //     {
    //         psf+=" "+src;
    //         // smallest path
    //         if(wsf< spathwt)
    //         {
    //             spath=psf;
    //             spathwt=wsf;
    //         }

    //         // largest path
    //         if(wsf>lpathwt)
    //         {
    //             lpath=psf;
    //             lpathwt=wsf;
    //         }

    //         // ceil path using factor
    //         if(wsf>factor)
    //         {
    //             if(wsf<cpathwt)
    //             {
    //                 cpath=psf;
    //                 cpathwt=wsf;
    //             }
    //         }

    //         // floor path using factor
    //         if(wsf<factor)
    //         {
    //             if(fpathwt<wsf)
    //             {
    //                 fpathwt=wsf;
    //                 fpath=psf;
    //             }
    //         }

    //         // kth largets using min priority queue
    //         if(pq.size()<k)
    //         {
    //             pq.add(new Pair1(psf, wsf));
    //         }else{
    //             if(pq.peek().wt>wsf)
    //             {
    //                 pq.remove();
    //                 pq.add(new Pair1(psf, wsf));
    //             }
    //         }
    //         return;
    //     }
    //     visited[src]=1;
    //     for(Pair p:graph.get(src))
    //     {
    //         int neighnode=p.node;
    //         int neighwt=p.wt;
    //         if(visited[neighnode]==0)
    //         {   
    //             multisolver(graph, neighnode, des, visited, factor, k, psf+" "+src, wsf+neighwt);
    //         }   
    //     }
    //     visited[src]=0;
    // }

    public static void getConnectedComponents(List<List<Pair>> graph,int src,int visited[],List<Integer> component)
    {
        if(visited[src]==0)
        {
            visited[src]=1;
        }
        component.add(src);
        for(Pair neighPair: graph.get(src))
        {
            if(visited[neighPair.node]==0)
            {
                getConnectedComponents(graph, neighPair.node, visited, component);
            }
        }
    }

    public static void getConnectedComponentHelper(List<List<Pair>> graph,int src,int visited[])
    {
        
        visited[src]=1;
        for(Pair neighPair: graph.get(src))
        {
            if(visited[neighPair.node]==0)
            {
                getConnectedComponentHelper(graph, neighPair.node, visited);
            }
        }
    }

    public static boolean isConnected(List<List<Pair>> graph,int src,int visited[])
    {
        int count=0;
        for(int i=0;i<7;i++)
        {
            if(visited[i]==0)
            {
                ++count;
                if(count>1)
                {
                    return false;
                }
                getConnectedComponentHelper(graph,i, visited);
            }
        }
        return true;
    }

    public static void printHamiltonian(List<List<Pair>> graph, int src,String psf,int visited[],HashSet<Integer> hs,int graphsize)
    {
        visited[src] = 1;
        hs.add(src);
        psf += src;

        if (hs.size() == graphsize) {
            System.out.println(psf);
            visited[src] = 0;
            hs.remove(src);
            return;
        }
    
        for(Pair p:graph.get(src))
        {
            if(visited[p.node]==0)
            {
                printHamiltonian(graph,p.node, psf, visited, hs, graphsize);
            }
        }
        visited[src]=0;
        hs.remove(src);
    }

    public static void main(String[] args) {
        int data[][]={
            {0,1,10},
            {0,3,40},
            {1,2,10},
            {1,3,10},
            {2,3,10},
            {3,4,12},
            // {4,2,10},
            // {4,5,8},
            // {5,6,3}
        };
        List<List<Pair>> graph=new ArrayList<>();
        for(int i=0;i<9;i++)
        {
            graph.add(new ArrayList<>());
        }
        create(graph,data);
        int visited[]=new int[5];
        HashSet<Integer> hs=new HashSet<>();
        printHamiltonian(graph, 0, "", visited, hs, 4);
        // multisolver(graph, 0, 6, visited, 40, 2, " ", 0);
        // System.out.print(spath+" "+spathwt+" "+lpath+" "+lpathwt+" "+cpath+" "+cpathwt+" "+fpath+" "+fpathwt);
        //  List<List<Integer>> ccList=new ArrayList<>();
        // for(int i=0;i<7;i++)
        // {
        //     if(visited[i]==0)
        //     {
        //         List<Integer> component=new ArrayList<>();
        //         getConnectedComponents(graph, i, visited, component);
        //         ccList.add(component);
        //     }
        // }
        // for(List<Integer> ll: ccList)
        // {
        //     for(Integer ii:ll)
        //     {
        //         System.out.print(ii+" ");
        //     }
        //     System.out.println();
        // }
        // Boolean ans=isConnected(graph, 0, visited);
        // if(ans)
        // {
        //     System.out.println("Connected graph");
        // }else{
        //     System.out.println("NOt Connected");
        // }
    }
}
