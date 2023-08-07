public class AddNumber {

    public static int addNum(int num1, int num2, int carry,int sum)
    {
        if(num1==0 && num2==0)
        {
            if(carry!=0)
            {
                sum=sum*10+carry;
                return sum;
            }   
            return sum;
        }
        int n1=num1<=0?0:num1%10;
        int n2=num2<=0?0:num2%10;
        int csum=n1+n2+carry;
        int rem=csum%10;
        carry=csum/10;
        sum=sum*10+rem;
        return addNum(num1/10,num2/10,carry,sum);
    }
    public static void main(String[] args) {
        int num1=777;
        int num2=777;
        int ans=addNum(num1, num2, 0, 0);  
        int sum=0;
        while(ans>0)
        {
            int carry=ans%10;
            sum=sum*10+carry;
            ans=ans/10;
        }      
        System.out.println(sum);
    }
}
