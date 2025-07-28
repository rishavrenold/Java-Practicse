import java.util.*;
public class GenerateAllpermutationofString {

    public static ArrayList<String> generate(String str)
    {
        ArrayList<String> al=new ArrayList<>();
        for(int i=0;i<str.length();i++)
        {
            for(char ch='a';ch<='z';ch++)
            {
                if(ch==str.charAt(i))
                {
                    continue;
                }
                String new_string=str.substring(0, i)+ch+str.substring(i+1, str.length());
                al.add(new_string);
            }
        }
        return al;
    }
    public static void main(String[] args) {
        String str="ab";
        ArrayList<String> res=generate(str);
        System.out.println(res);
    }
}
