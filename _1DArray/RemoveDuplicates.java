package _1DArray;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int idx=0;
        for(int j=1;j<nums.length;j++)
        {
            if(nums[idx]!=nums[j])
            {
                idx++;
                nums[idx]=nums[j];
            }
        }

        return idx+1;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3};
        System.out.println(removeDuplicates(arr));
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
