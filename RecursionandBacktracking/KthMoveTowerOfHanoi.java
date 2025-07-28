public class KthMoveTowerOfHanoi {

    public static void kthMove(int disc, char source, char target, char aux, int k)
    {
        if(k<=(1<<(disc-1))-1)
        {
            kthMove(disc-1, source, aux, target, k);
        }
        else if(k==(1<<(disc-1)))
        {
           System.out.println("Moved disc " + disc +" from "+source +" to "+target);
           return;
        }
        else{
            kthMove(disc-1, aux, target, source,k-(1<<(disc-1)));
        }
    }

    public static void main(String[] args) {
        int k=(1<<3)-1;
        for(int i=1;i<=7;i++)
        {
            kthMove(3,'A','C','B',i);
        }
    }
}
