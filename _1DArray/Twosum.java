package _1DArray;
public class Twosum {
    public static int[] twoSum(int[] nums, int target) {       
        int res[]=new int[2];
       for(int i=0;i<nums.length-1;i++)
       {
           for(int j=i+1;j<nums.length;j++)
           {
               if(nums[i]+nums[j]==target)
               {
                   res[0]=i;
                   res[1]=j;
                   return res;
               }
           }
       }
        return res;
    }
    public static void main(String[] args) {
        int arr[]={2,7,11,15};
        int res[]=twoSum(arr, 9);
        for(int i=0;i<res.length;i++)
        {
            System.out.print(res[i]+" ");
        }
    }
}
