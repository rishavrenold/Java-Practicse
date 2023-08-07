public class PermutationOfStrings {

    // Correct Code Ananlysis
    public static void permute1(String str, int i)
    {
        if(i>=str.length())
        {
            System.out.println(str);
            return;
        }        
        char atj, ati;
        StringBuilder sb= new StringBuilder(str);
        for(int j=i;j<str.length();j++)
        {
            
            ati=sb.charAt(i);
            // System.out.println("character at ati "+ati+" i = "+i);
            atj=sb.charAt(j);
            // System.out.println("character at atj "+atj+" j = "+j);
            // System.out.println("String as of now before swap and before call "+ sb.toString());
            sb.setCharAt(i, atj);
            sb.setCharAt(j, ati);
            // System.out.println("String as of now after swap and before call "+ sb.toString());
            permute1(sb.toString(),i+1);
            ati=sb.charAt(i);
            // System.out.println("character at ati "+ati+" i = "+i);
            atj=sb.charAt(j);
            // System.out.println("character at atj "+atj+" j = "+j);
            // System.out.println("String as of now before swap and after call "+ sb.toString());         
            sb.setCharAt(j,ati);
            sb.setCharAt(i,atj);
            // System.out.println("String as of now after swap and after call "+ sb.toString());
        }
    }

 

    
    public static void main(String[] args) {
        String str="abc";
         permute1(str,0);
    }
}
