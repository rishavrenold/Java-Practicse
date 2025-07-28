package Maths;

public class BitmaskCheckForDistinct {
    public static void main(String[] args) {
        int n=12;
        for(int abcde=01234; abcde<=56789;abcde++)
        {
            if(abcde%n!=0) continue;
            int fghij=abcde/n;
            int pre_mask=0;
            int x=abcde;
            for(int i=0;i<5;i++)
            {
                pre_mask|=(1<<(x%10));
                x/=10;
            }
            x=fghij;
            for(int i=0;i<5;i++)
            {
                pre_mask|=(1<<(x%10));
                x/=10;
            }
            if(pre_mask==((1<<10)-1))
            {
                System.out.println(abcde+" "+fghij);
            }
        }
    }
}
