package RecursionandBacktracking;
import java.util.*;

public class RatInAMaze {

    public static boolean isSafe(int sr ,int sc,int dr,int dc,
    ArrayList<ArrayList<Boolean>> visited, int arr[][])
    {
        if((sr<dr && sr>=0) && (sc<dc && sc>=0) && (arr[sr][sc]==1) && 
        (visited.get(sr).get(sc)==false))
        {
            return true;
        } 
        return false;
    
    }

    public static void findallPaths(int sr,int sc, int dr, int dc,
    ArrayList<ArrayList<Boolean>> visited, int arr[][],String res)
    {

        if(sr==dr-1 && sc==dc-1)
        {
            System.out.println(res);
            return;
        }   

        //Down
        
        if(isSafe(sr+1,sc,dr,dc,visited,arr))
        {
            visited.get(sr).set(sc, true);
            findallPaths(sr+1, sc, dr, dc, visited, arr, res+"D");
            visited.get(sr).set(sc, false);
        } 
        
        //Left
        if(isSafe(sr,sc-1,dr,dc,visited,arr))
        {
            visited.get(sr).set(sc, true);
            findallPaths(sr, sc-1, dr, dc, visited, arr, res+"L");
            visited.get(sr).set(sc, false);
        } 
        //Right
        if(isSafe(sr,sc+1,dr,dc,visited,arr))
        {
            visited.get(sr).set(sc, true);
            findallPaths(sr, sc+1, dr, dc, visited, arr, res+"R");
            visited.get(sr).set(sc, false);
        } 
        //Up  
        if(isSafe(sr-1,sc,dr,dc,visited,arr))
        {     
            visited.get(sr).set(sc, true);       
            findallPaths(sr-1, sc, dr, dc, visited, arr, res+"U");
            visited.get(sr).set(sc, false);            
        } 
        
        
        
    }
    public static void main(String[] args) {
        int arr[][]={{1,0,0},
                        {1,1,0},
                        {1,1,1}};
        ArrayList<ArrayList<Boolean>> visited =new ArrayList<ArrayList<Boolean>>();
        for(int i=0;i<arr.length;i++)
        {
           ArrayList<Boolean> row= new ArrayList<>();
           for(int j=0;j<arr.length;j++)
           {
                 row.add(false);
           }
           visited.add(row);
        }
        visited.get(0).set(0, true); 
            findallPaths(0,0,arr.length,arr[0].length,visited,arr,"");    
            visited.get(0).set(0, false); 
        }

    }

//  USING VISITIED BOOLEAN ARRAY 
// ------------------------------------------------------------------
    // public static boolean isSafe(int sr ,int sc,int dr,int dc,
    // boolean[][] visited, int arr[][])
    // {
    //     if((sr<dr && sr>=0) && (sc<dc && sc>=0) && (arr[sr][sc]==1) && 
    //     (visited[sr][sc]==false))
    //     {
    //         return true;
    //     } 
    //     return false;
    
    // }

    // public static void findallPaths(int sr,int sc, int dr, int dc,
    // boolean[][] visited, int arr[][],String res)
    // {

    //     if(sr==dr-1 && sc==dc-1)
    //     {
    //         System.out.println(res);
    //         return;
    //     }   

    //     //Down
        
    //     if(isSafe(sr+1,sc,dr,dc,visited,arr))
    //     {
    //         visited[sr+1][sc]=true;
    //         findallPaths(sr+1, sc, dr, dc, visited, arr, res+"D");
    //         visited[sr+1][sc]=false;
    //     } 
        
    //     //Left
    //     if(isSafe(sr,sc-1,dr,dc,visited,arr))
    //     {
    //        visited[sr][sc-1]=true;;
    //         findallPaths(sr, sc-1, dr, dc, visited, arr, res+"L");
    //         visited[sr][sc-1]=false;
    //     } 
    //     //Right
    //     if(isSafe(sr,sc+1,dr,dc,visited,arr))
    //     {
    //         visited[sr][sc+1]=true;
    //         findallPaths(sr, sc+1, dr, dc, visited, arr, res+"R");
    //        visited[sr][sc+1]=false;;
    //     } 
    //     //Up  
    //     if(isSafe(sr-1,sc,dr,dc,visited,arr))
    //     {     
    //         visited[sr-1][sc]=true;       
    //         findallPaths(sr-1, sc, dr, dc, visited, arr, res+"U");
    //         visited[sr-1][sc]=false;            
    //     } 
    // }
    // public static void main(String[] args) {
    //     int arr[][]={{1,0,0},
    //                 {1,1,0},
    //                 {1,1,1}};
    //     boolean visited[][]=new boolean[arr.length][arr[0].length];
    //     // for(int i=0;i<visited.length;i++)
    //     // {
    //     //     for(int j=0;j<visited[0].length;j++)
    //     //     {
    //     //         System.out.print(visited[i][j]+" ");
    //     //     }
    //     //     System.out.println();
    //     // }
    //         visited[0][0]=true; 
    //         findallPaths(0,0,arr.length,arr[0].length,visited,arr,"");    
    //         visited[0][0]=false; 
    //     }