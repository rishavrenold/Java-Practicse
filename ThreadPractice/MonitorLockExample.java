package ThreadPractice;

public class MonitorLockExample {
    
    public synchronized void task1()
    {
        try{
            System.out.println("inside task1");
            Thread.sleep(10000);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void task2()
    {
        System.out.println("task2 before synx");
        synchronized(this)
        {
            System.out.println("task2 inside");
        }
    }
    public void task3()
    {
        System.out.println("task3");
    }

}
