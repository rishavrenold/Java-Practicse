package RecursionandBacktracking;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int arr1[]={2,6,8,9,11};
        int arr2[]={1,3,5,7};
        int res[]=new int [arr1.length+arr2.length];

        int idx=0;
        int ptr1=0;
        int ptr2=0;
        while(ptr1<arr1.length && ptr2<arr2.length)
        {
            System.out.print("ptr 1 = "+ptr1+" ptr 2 = "+ptr2 +" idx = "+idx);
            System.out.println();
            if(arr1[ptr1]<arr2[ptr2])
            {
                res[idx++]=arr1[ptr1++];
            }
            else{
                res[idx++]=arr2[ptr2++];
            }            
        }

        while(ptr1<arr1.length)
        {
            res[idx++]=arr1[ptr1++];
        }

        while(ptr2<arr2.length)
        {
            res[idx++]=arr2[ptr2++];
        }

        for(int i=0;i<res.length;i++)
        {
            System.out.print(res[i]+" ");
        }
    }
}
