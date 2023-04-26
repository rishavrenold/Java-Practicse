package RecursionandBacktracking;

import java.util.ArrayList;
import java.util.Scanner;

public class StairCasePath {

    public static ArrayList<String> generatepath(int n)
    {
        if(n==0)
        {
            ArrayList<String> temp= new ArrayList<>();
            temp.add("");
            return temp;
        }

        ArrayList<String> mres= new ArrayList<>();
        if(n-1>=0)
        {
            ArrayList<String> p1=generatepath(n-1);
            for(String s:p1)
            {
                mres.add(s+"1");
            }
        }
        if(n-2>=0)
        {
            ArrayList<String> p2=generatepath(n-2);
            for(String s:p2)
            {
                mres.add(s+"2");
            }
        }
        if(n-3>=0)
        {
            ArrayList<String> p3=generatepath(n-3);
            for(String s:p3)
            {
                mres.add(s+"3");
            }
        }
        return mres;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of stairs");
        int n=sc.nextInt();
        ArrayList<String> res=generatepath(n);
        System.out.println(res);
    }
}
