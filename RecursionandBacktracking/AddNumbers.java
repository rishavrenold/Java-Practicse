public class AddNumbers {

    public static String addRE(String num1, int p1, String num2,int p2,int carry)
    {
        if(p1<0 && p2<0)
        {
            if(carry!=0)
            {
                String temp="";
                temp+=carry;
                return temp;
            }
            return "";
        }
        int n1=p1>=0?num1.charAt(p1)-'0':0;
        int n2=p2>=0?num2.charAt(p2)-'0':0;
        int csum=n1+n2+carry;
        int rem=csum%10;
        carry=csum/10;
        String ans="";
        ans+=rem;
        ans+=addRE(num1, p1-1, num2, p2-1, carry);
        return ans;
    }
    public static void main(String[] args) {
        String num1="777";
        String num2="777";
        StringBuilder sb= new StringBuilder(addRE(num1, num1.length()-1, num2, num2.length()-1, 0));
        System.out.println(sb.reverse().toString());
    }
}
