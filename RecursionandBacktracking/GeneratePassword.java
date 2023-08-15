public class GeneratePassword {
    public static void generate(String str, String asf,int len)
    {
        if(asf.length()==len)
        {
            System.out.println(asf);
            return;
        }
       for(int i=0;i<str.length();i++)
       {
            char ch=str.charAt(i);
            generate(str,asf+ch,len);
       }
    }
    public static void providelen(String s, int len)
    {
        for(int i=1;i<=len;i++)
        {
            generate(s,"", i);
        }
    }
    public static void main(String[] args) {
        String s="abc";
        providelen(s,3);
    }
}
