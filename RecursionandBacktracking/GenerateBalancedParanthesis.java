import java.util.Scanner;

public class GenerateBalancedParanthesis {

    public static void generateAll(String str, int open , int close, int n)
    {
        if(close==n)
        {
            System.out.println(str);
            return;
        }
       
        if(open>close)
        {
            generateAll(str+"}", open, close+1, n);
        }
        if(open<n)
        {
            generateAll(str+"{", open+1, close, n);
        }
             
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        generateAll("", 0,0 , n);
    }
}
