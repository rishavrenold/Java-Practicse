public class ReverseString {

    public static void reverse(StringBuilder s,int start, int end)
    {
        if(start>end)
        {
            return;
        }
        char temp=s.charAt(start);
        s.setCharAt(start,s.charAt(end));
        s.setCharAt(end,temp);
        reverse(s,start+1,end-1);
    }
    public static void main(String[] args) {
        String str="Rishav";
        StringBuilder sb= new StringBuilder(str);
        reverse(sb,0,sb.length()-1);
        System.out.println(sb.toString());
    }
}
