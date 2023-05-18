package RecursionandBacktracking;
public class MergeSort {
public static void merge(int arr[],int start,int end)
{
        int mid=(start+end)/2;
        int left[]=new int[(mid-start)+1];
        int right[]=new int[end-mid];
        int k=start;
        for(int i=0;i<left.length;i++)
        {
            left[i]=arr[k++];
        }
        k=mid+1;
        for(int i=0;i<right.length;i++)
        {
            right[i]=arr[k++];
        }

        int idx=start;
        int ptr1=0;
        int ptr2=0;
        while(ptr1<left.length && ptr2<right.length)
        {
            if(left[ptr1]<right[ptr2])
            {
                arr[idx++]=left[ptr1++];
            }
            else{
                arr[idx++]=right[ptr2++];
            }            
        }

        while(ptr1<left.length)
        {
            arr[idx++]=left[ptr1++];
        }

        while(ptr2<right.length)
        {
            arr[idx++]=right[ptr2++];
        }

}

public static void mergesort(int arr[],int start,int end)
{
    if(start>=end)
    {
        return;
    }
    int mid=(start+end)/2;
    mergesort(arr, start, mid);
    mergesort(arr, mid+1, end);
    merge(arr,start,end);
}

public static void main(String[] args) {
        int arr[]={4,7,2,8,9,33,1,99};
        mergesort(arr, 0,arr.length-1);

        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }

      
    }
}
