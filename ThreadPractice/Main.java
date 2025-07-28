package ThreadPractice;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Finish main method" +Thread.currentThread().getName());
        // Threading threading=new Threading();
        // Thread t=new Thread(threading);
        // t.start();
        // System.out.println("Finish main method" +Thread.currentThread().getName());

        MonitorLockExample ob= new MonitorLockExample();
        Thread t1=new Thread(()->{
            ob.task1();
        });
        Thread t2=new Thread(()->{
            ob.task2();
        });
        Thread t3=new Thread(()->{
            ob.task3();
        });

        t1.start();
        t2.start();
        t3.start();

    }
}
