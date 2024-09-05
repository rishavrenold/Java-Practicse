public class PrintDigits {

    public static void print(int num)
    {
        if(num==0)
        {
            return;
        }
        System.out.print((num%10)+" ");
        print(num/10);
    }
    public static void main(String[] args) {
        int num=121;
        print(num);
    }
}
