package Recursion;

import java.util.Scanner;

public class Subsequence {

    public static void generatesubsequence(String str, String res)
    {
        if(str.length()==0)
        {
            System.out.println(res);
            return;
        }
        String newString=str.substring(1);
        char ch=str.charAt(0);
        generatesubsequence(newString, res+ch);
        generatesubsequence(newString, res);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string for generating subsequcene :");
        String str=sc.next();
        generatesubsequence(str,"");
    }
}
