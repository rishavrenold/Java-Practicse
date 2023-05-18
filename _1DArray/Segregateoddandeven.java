package _1DArray;

public class Segregateoddandeven {
    public static void main(String[] args) {
        int arr[]={2,5,7,3,4,8,11,20,16,17};
        int i=0,j=0;
        while(j<arr.length)
        {
            if(arr[j]%2==0)
            {
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j++;
            }
            else{
                j++;
            }
        }

        for(int ii=0;ii<arr.length;ii++)
        {
            System.out.print(arr[ii]+" ");
        }
    }
}
