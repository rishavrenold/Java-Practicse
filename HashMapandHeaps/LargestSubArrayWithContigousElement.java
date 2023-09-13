package HashMapandHeaps;

public class LargestSubArrayWithContigousElement {

    public static int largestsub(int arr[])
    {
        int maxlen=0;
       for(int i=0;i<arr.length;i++)
        {
                int max=arr[i];
                int min=arr[i];
            for(int j=i;j<arr.length;j++)
            {
                min=Math.min(arr[j],min);
                max=Math.max(arr[j],max);
                if(j-i==max-min)
                {
                    maxlen=Math.max(maxlen,j-i);
                }
            }
        }
        return maxlen;
    }
    public static void main(String[] args) {
        int arr[]={10,12,11};
        System.out.println(largestsub(arr));
    }
}
