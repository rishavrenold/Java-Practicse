package CreationalDesignPattern.SingletonPattern;

import java.time.temporal.JulianFields;

// class JudgeAnalytics
// {
//     private int run =0;
//     private int submit=0;

//     public void countRun()
//     {
//         run++;
//     }

//     public void countSubmit()
//     {
//         submit++;
//     }

//     public int getRun()
//     {
//         return run;
//     }

//     public int getSubmit()
//     {
//         return submit;
//     }

// }

// to implement Singleton 
// 1st Approach

// class JudgeAnalytics{
//     private static final JudgeAnalytics ob=new JudgeAnalytics();
//     private int run =0;
//     private JudgeAnalytics()
//     {

//     }
//     public static JudgeAnalytics getJudgeAnalytics()
//     {
//         return ob;
//     }
//     public void countRun()
//     {
//         run++;
//     }
//     public int getRun()
//     {
//         return run;
//     }
// }

// 2nd Approach

// class JudgeAnalytics{
//     private static JudgeAnalytics ob;
//     private int run =0;
//     private JudgeAnalytics()
//     {

//     }
//     public static JudgeAnalytics getJudgeAnalytics()
//     {
//         if(ob==null)
//         {
//             ob=new JudgeAnalytics();
//         }
//         return ob;
//     }
//     public void countRun()
//     {
//         run++;
//     }
//     public int getRun()
//     {
//         return run;
//     }
// }

// 3rd approach based on threading concept synchronised 
// class JudgeAnalytics{
//     private static JudgeAnalytics ob;
//     private int run =0;
//     private JudgeAnalytics()
//     {

//     }
//     public static synchronized JudgeAnalytics getJudgeAnalytics()
//     {
//        if(ob==null)
//        {
//             ob=new JudgeAnalytics();
//        }
//        return ob;
//     }
//     public void countRun()
//     {
//         run++;
//     }
//     public int getRun()
//     {
//         return run;
//     }
// }

//4th approach not using synchronised on the method level instead using a block

class JudgeAnalytics{
    private static JudgeAnalytics ob;
    private int run =0;
    private JudgeAnalytics()
    {

    }
    // Double Locking Mechanism
    public static JudgeAnalytics getJudgeAnalytics()
    {
       if(ob==null)
       {
            synchronized(JudgeAnalytics.class)
            {
                if(ob==null)
                {
                    ob=new JudgeAnalytics();
                }
            }
            ob=new JudgeAnalytics();
       }
       return ob;
    }
    public void countRun()
    {
        run++;
    }
    public int getRun()
    {
        return run;
    }
}

public class Singleton {
    public static void main(String[] args) {
        JudgeAnalytics ob=JudgeAnalytics.getJudgeAnalytics();
        JudgeAnalytics ob1=JudgeAnalytics.getJudgeAnalytics();
        Thread t1= new Thread(()->{
            ob.countRun();
        });
        Thread t2=new Thread(()->{
            ob1.countRun();
        });
        t1.start();
        t2.start();
        System.out.println(ob1);
        System.out.println(ob);

        System.out.println(ob.getRun());
    }
}
