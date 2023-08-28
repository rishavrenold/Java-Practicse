package _1DArray;
import java.util.Arrays;
import java.util.List;
// brute force method getting all the pair of height and finding the distance between
// index
public class ContainerWithMaxWater {
    public static int maxwater(List<Integer> height)
    {
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<height.size();i++)
        {
            for(int j=i+1;j<height.size();j++)
            {
                int ht=Math.min(height.get(i),height.get(j));
                int w=(j-i);
                maxi=Math.max(maxi,w*ht);
            }
        }
        return maxi;
    }
    public static void main(String[] args) {
       Integer height[]= {1,8,6,2,5,4,8,3,7};
       List<Integer> h=Arrays.asList(height);
       System.out.println(maxwater(h));        
    }
}
