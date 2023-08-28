package _1DArray;

public class ProductOfArrayExceptSelf {
    public static int[] product(int arr[])
    {
        int n=arr.length;
        int res[]=new int[n];
        if(n==0)
        {
            return res;
        }        
        int product=1;
        for(int i=0;i<n;i++)
        {
            product*=arr[i];
            res[i]=product;
        }
        
        product=1;
        for(int i=n-1;i>0;i--)
        {
            res[i]=product*res[i-1];
            product*=arr[i];
        }
        res[0]=product;
        return res;

    }
    public static int[] productapproach2(int arr[])
    {
        int n=arr.length;
        int leftarray[]=new int[n];
        int rightarray[]=new int[n];
        int res[]=new int[n];
        int product=1;
        for(int i=0;i<n;i++)
        {
            product*=arr[i];
            leftarray[i]=product;
        }
        product=1;
        for(int i=n-1;i>=0;i--)
        {
            product*=arr[i];
            rightarray[i]=product;
        }
        res[0]=rightarray[1];
        res[n-1]=leftarray[n-2];
        for(int i=1;i<n-1;i++)
        {
            res[i]=leftarray[i-1]*rightarray[i+1];
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        int res[]=productapproach2(arr);
        for(int i:res)
        {
            System.out.print(i+" ");
        }
    }
}
