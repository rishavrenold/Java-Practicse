package _1DArray;
import java.io.*;
import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }
       int b[][]= mergeOverlappingIntervals(arr);
      
       for(int i=0;i<b.length;i++)
       {
        for(int j=0;j<b[i].length;j++)
        {
            System.out.print(b[i][j]+" ");
        }
        System.out.println();
       }
    }

    public static int[][] mergeOverlappingIntervals(int[][] arr) {
        // Arrays.sort(arr,(a,b)-> a[0]-b[0]);
        Arrays.sort(arr,new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                return o1[0]-o2[0];
            }
            
        });
        int start=arr[0][0];
        int end=arr[0][1];
        ArrayList<int[]> res= new ArrayList<>();
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i][0]<=end)
            {
                end=Math.max(end,arr[i][1]);
            }
            else
            {
                res.add(new int[]{start,end});
                start=arr[i][0];
                end=arr[i][1];
            }
        }
        res.add(new int[]{start, end});
        for(int[] a:res)
        {
            for(int i:a)
            {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        return res.toArray(new int[0][]);
    }

// ----------------------------------------------------------------------------------
    // Dosen't complete all test cases in leetcode
// ----------------------------------------------------------------------------------
    // public static int[][] insertIntervals(int[][] arr ,int interval[][]) {
    //     // Arrays.sort(arr,(a,b)-> a[0]-b[0]);
    //     Arrays.sort(arr,new Comparator<int[]>() {

    //         @Override
    //         public int compare(int[] o1, int[] o2) {
    //             // TODO Auto-generated method stub
    //             return o1[0]-o2[0];
    //         }
            
    //     });
    //     ArrayList<int[]> res= new ArrayList<>();
    //     if(arr.length==0 || arr==null)
    //     {
    //         return interval;
    //     }
    //     int start=arr[0][0];
    //     int end=arr[0][1];
    //     if(arr.length==1)
    //     {
            
    //         if(interval[0][0]<=end)
    //         {
    //             end=Math.max(end,interval[0][1]);
    //             start=Math.min(start,interval[0][0]);              
    //         } 
    //     }
    //     for(int i=1;i<arr.length;i++)
    //     {
            
    //         if(arr[i][0]<=end)
    //         {
    //             end=Math.max(end,arr[i][1]);               
    //         }
    //         else
    //         {
    //             if(interval[0][0]<=end)
    //             {
    //                 end=Math.max(end,interval[0][1]);
    //                 start=Math.min(start,interval[0][0]);
    //                 if(arr[i][0]<=end)
    //                 {
    //                     end=Math.max(end,arr[i][1]);
    //                 } 
    //                 else{
    //                     res.add(new int[]{start,end});
    //                     start=arr[i][0];
    //                     end=arr[i][1];
    //                 }                    
    //             }
    //             else
    //                 {
    //                     res.add(new int[]{start,end});
    //                     start=arr[i][0];
    //                     end=arr[i][1];
    //                 }
                           
    //         }
    //     }
    //     res.add(new int[]{start, end});
    //     return res.toArray(new int[0][]);
    // }
}
