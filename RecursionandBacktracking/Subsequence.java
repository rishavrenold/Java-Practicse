import java.util.ArrayList;
import java.util.Scanner;

public class Subsequence {

    public static void generatesubsequence(String str, String s, ArrayList<String> res)
    {
        if(str.length()==0)
        {
            res.add(s);
            return;
        }
        String newString=str.substring(1);
        char ch=str.charAt(0);
        generatesubsequence(newString, s+ch,res);
        generatesubsequence(newString, s,res);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string for generating subsequcene :");
        String str=sc.next();
        ArrayList<String> res=new ArrayList<>();
        generatesubsequence(str,"",res);
        for(String s:res)
        {
            System.out.print(s+" ");
        }
    
}
}
