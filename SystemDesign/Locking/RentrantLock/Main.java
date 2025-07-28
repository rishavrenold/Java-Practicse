package SystemDesign.Locking.RentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock lock=new ReentrantLock();
        SharedResource resource1=new SharedResource();
        Thread thread1=new Thread(()->{
            resource1.add(lock);
        });
        SharedResource resource2=new SharedResource();
        Thread thread2=new Thread(()->{
            resource2.cosume(lock);
        });
        thread1.start();
        thread2.start();

    }
}
