package _1DArray;
// 3 pointer problem

public class DutchNationalFlag {
    public static void swap(int i,int j, int arr[])
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args) {
        // int arr[]={0,2,1,0,0,2,1,2,1,2,1,0,1,2};
        int nums[]={2,0,1};
        int low=0,mid=0,high=nums.length-1;
        while (mid <=high)
    {
      if (nums[mid] == 0)
      {
        int temp=nums[low];
        nums[low]=nums[mid];
        nums[mid]=temp;
        low++;
        mid++;
      }
      else if (nums[mid] == 1)
      {
        mid++;
      }
      else
      {
        int temp=nums[high];
        nums[high]=nums[mid];
        nums[mid]=temp;
        high--;
      }
    }
        for(int ii=0;ii<nums.length;ii++)
        {
            System.out.print(nums[ii]+" ");
        }
    }
}
