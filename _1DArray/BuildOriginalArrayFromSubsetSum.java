package _1DArray;
import java.util.*;

public class BuildOriginalArrayFromSubsetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = 1 << n;  // 2^n numbers
            int[] arr = new int[m];
            
            for (int i = 0; i < m; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);  // Sorting the numbers

            // Map<Long, Integer> sums = new HashMap<>();  // Stores possible sums and their frequency
            // sums.put(0L, 1);  // 0 can be generated initially

            // List<Long> ans = new ArrayList<>();
            // List<Long> subsums = new ArrayList<>();  // Subset sums that can be created

            // for (int i = 0; i < m; i++) {
            //     if (sums.getOrDefault(arr[i], 0) > 0) {
            //         sums.put(arr[i], sums.get(arr[i]) - 1);  // This sum can be created, so skip once
            //     } else {
            //         ans.add(arr[i]);  // If not present, add to the final array
                    
            //         List<Long> temp = new ArrayList<>();
            //         for (long z : subsums) {  // Create new subset sums
            //             temp.add(z + arr[i]);
            //             sums.put(z + arr[i], sums.getOrDefault(z + arr[i], 0) + 1);
            //         }
            //         for (long z : temp) {
            //             subsums.add(z);  // Add new sums to subset sums
            //         }
            //         subsums.add(arr[i]);  // Also add this element as a set of its own
            //     }
            // }
            
            ArrayList<Integer> ans= new ArrayList<>();
            ArrayList<Integer> subsetsum=new ArrayList<>();
            int freq[]=new int[16];
            freq[0]=1;
            for(Integer val:arr)
            {
                if(freq[val]>0)
                {
                    freq[val]--;
                }else
                {
                    ans.add(val);
                    ArrayList<Integer> temp=new ArrayList<>();
                    for(Integer subsetval:subsetsum)
                    {
                        int newsubsetval=subsetval+val;
                        temp.add(newsubsetval);
                        freq[newsubsetval]++;
                    }
                    for(Integer newsubsetsumval:temp)
                    {
                        subsetsum.add(newsubsetsumval);
                    }
                    subsetsum.add(val);                   
                }
            }

            for (long z : ans) {
                System.out.print(z + " ");
            }
            System.out.println();
        }
    }
}
