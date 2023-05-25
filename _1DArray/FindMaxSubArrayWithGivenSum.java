package _1DArray;


public class FindMaxSubArrayWithGivenSum {
    public static void main(String[] args) {
        int arr[]={4,8,12,5};
        int targetsum=17;
        int start=0;
        int end=0;
        int currsum=0;
        int maxsum=Integer.MIN_VALUE;
        for(end=0;end<arr.length;end++)
        {
            currsum+=arr[end];
           while(currsum>targetsum)
            {
                currsum-=arr[start++];
            }
            if(currsum==targetsum)
            {
                System.out.println("Found at starting idx = "+start +" end "+ end );
                return;
            }
        }
        System.out.println("Not found");
    }

}
