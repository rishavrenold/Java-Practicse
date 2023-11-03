package _1DArray;

public class ProductWithoutItself {
    public static int[] helper(int arr[])
    {
        int prefixprod[]=new int[arr.length];
        int prod=1;
        for(int i=0;i<arr.length;i++)
        {   
            prod*=arr[i];
            prefixprod[i]=prod;
        }
        int suffix=1;
        int idx=arr.length-1;
        while(idx>0)
        {
            prefixprod[idx]=prefixprod[idx-1]*suffix;
            suffix*=arr[idx];
            idx--;
        }
        prefixprod[0]=suffix;
        return prefixprod;    
    }
    
    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        int ans[]=helper(arr);
        for(int i:ans)
        {
            System.out.print(i+" ");
        }
    }
}
