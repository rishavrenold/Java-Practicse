package StringPrac;

public class StringCompression {

    public static String compressString(String str)
    {
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<str.length();i++)
        {
            Integer count=1;
            while(i+1<str.length() && str.charAt(i)==str.charAt(i+1))
            {
                count+=1;
                i++;
            }
            sb.append(str.charAt(i));
            if(count>1)
            {
                sb.append(count.toString());
            }

        }

        return sb.toString();
    }
    public static void main(String[] args) {
        String str="aaabbccccdd"; 
        System.out.println(compressString(str));

    }
}
