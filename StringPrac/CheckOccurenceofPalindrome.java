package StringPrac;
import java.util.*;

public class CheckOccurenceofPalindrome {

    public static int isPalin(String str , int i, int j)
    {
        int count=0;
        while(i>=0 && j<str.length())
        {
            if(str.charAt(i)==str.charAt(j))
            {
                count+=1;
            }
            i--;
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str=sc.next();
        int count=0;
        for(int i=0;i<str.length();i++)
        {
            int evencount=isPalin(str, i, i+1);
            count+=evencount;

            int oddcount=isPalin(str, i, i);
            count+=oddcount;
        }      
        System.out.println(count);
    }
}
