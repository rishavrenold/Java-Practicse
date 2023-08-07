import java.util.Scanner;

public class PalindromeCheck {

    public static boolean checkpalindrome(String ss,int start,int end)
    {

        if(ss.length()==0)
        {
            return true;
        }

        if(start==end)
        {
            return true;
        }
        
        char beign=ss.charAt(start);
        char e=ss.charAt(end);

        if(beign!=e)
        {
            return false;
        }
        
        return checkpalindrome(ss, start+1, end-1);


    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str=sc.nextLine();
        StringBuilder sb= new StringBuilder();
        String ss=str.toLowerCase();
        for(int i=0;i<ss.length();i++)
        {
        
            int equi=(int)ss.charAt(i);
            System.out.println(equi);
            if(equi>=48 && equi<=57)
            {
                sb.append((char)equi);
            }
            if(equi>=97 && equi<=122)
            {
                sb.append((char)(equi));
            }
        }
        System.out.println(sb.toString());


        System.out.println(checkpalindrome(sb.toString(),0,sb.toString().length()-1));

    }
}
