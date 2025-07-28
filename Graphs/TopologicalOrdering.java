package Graphs;
import java.text.CollationElementIterator;
import java.util.*;

public class TopologicalOrdering {
    static ArrayList<Integer> res= new ArrayList<>();
    static ArrayList<ArrayList<Integer>> graph;
    static int visited[];
    static int dp[];

    public static void khans(int n,int indge[])
    {
        PriorityQueue<Integer> q=new PriorityQueue<>();// Use priorityQueue for smallest lexiographically number 
        for(int i=0;i<n;i++)
        {       
            if(indge[i]==0)
            {
                q.offer(i);
            }
        }
        while(!q.isEmpty())
        {
            int curr=q.poll();
            for(Integer neighbour:graph.get(curr))
            {
                indge[neighbour]--;
                if(indge[neighbour]==0)
                {
                    q.offer(neighbour);
                }
            }
            res.add(curr);
        }
    }

    public static void dfs(int node)
    {
        visited[node]=1;
        for(Integer neighnour:graph.get(node))
        {
            if(visited[neighnour]==0)
            {
                dfs(neighnour);
            }
        }
        res.add(node);
    }

    // Longest Path in the DAG Dp Approach
    public static int recdp(int node,int dp[])
    {
        if(dp[node]!=-1)
        {
            return dp[node];
        }
        int ans=1;
        for(Integer neighbour: graph.get(node))
        {
            ans=Math.max(ans,1+recdp(neighbour, dp));
        }
        return dp[node]=ans;
    }

    public static void recur(int dp[])
    {
        int maxlen=Integer.MIN_VALUE;
        for(Integer node: res)
        {
            int ans=1;
            for(Integer neighour :graph.get(node))
            {
                ans=Math.max(ans,1+dp[neighour]);
            } 
            dp[node]=ans;
            maxlen=Math.max(maxlen,dp[node]);  
        }
        System.out.println("Maximum length "+maxlen);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        graph=new ArrayList<>();
        int n = 5;
        int m = 5;
        visited=new int[n];

        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }
        int indge[]=new int[n];
        for(int i=0;i<n;i++)
        {
            int u=sc.nextInt()-1;
            int v=sc.nextInt()-1;
            graph.get(u).add(v);
            indge[v]++;
        }
         khans(n,indge);
        // for(int i=0;i<n;i++)
        // {
        //     if(visited[i]==0)
        //     {
        //         dfs(i);
        //     }
        // }

        dp=new int[n+1];
        Arrays.fill(dp,-1);

        int maxlen=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            int currans=rec(i, dp);
            System.out.print(currans+" ");
            maxlen=Math.max(maxlen,currans);
        }
        System.out.println("Maximum length "+ (maxlen-1));
        // Collections.reverse(res);
        // for(Integer ii:res)
        // {
        //     System.out.print(ii+" ");
        // }
    }
}
