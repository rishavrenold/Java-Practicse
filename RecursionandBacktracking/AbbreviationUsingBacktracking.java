public class AbbreviationUsingBacktracking {

    public static void printabb(String str,String asf,int count)
    {
        if(str.length()==0)
        {
            if(count>0)
            {
                asf+=count;
                System.out.println(asf);
            }else{
                System.out.println(asf);
            }            
            return;
        }
        char ch=str.charAt(0);
        String ros=str.substring(1);
        // include call
        if(count>0)
        {
            printabb(ros, asf+count+ch,count=0);
        }else{
            printabb(ros,  asf+ch,count);
        }        
        printabb(ros, asf,count+1);      

    }
    public static void main(String[] args) {
        String str="pep";
        printabb(str,"",0);
    }
}
