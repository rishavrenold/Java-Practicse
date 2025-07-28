package BitManipulation;

public class PrintBinaryRepresentation {
    public static void main(String[] args) {
        int n=7;
        for(int i=31;i>=0;i--)
        {
            int val=n & (1<<i);
            if(val>0)
            {
                System.out.print("1");
            }else{
                System.out.print("0");
            }
        }
    }
}
// 00000000000000000000000000000111
//                               1*(2^2) +1*(2^1) +1*2^0 => 4+2+1
/**
 * last iteration -> 7 & (1<<0) -> (1<<0) equivalent hoga 2^0 -> 1; 1& 1=> 1 issliye last bit set hua
 * n&(1<<i)=> yeh condition check karta hai ki bit at that particular position is set or not. 
 */