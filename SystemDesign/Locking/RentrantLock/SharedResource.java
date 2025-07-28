package SystemDesign.Locking.RentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    
    boolean isAvailable=false;

    public void cosume(ReentrantLock lock)
    {
        lock.lock();
        try{
            System.out.println("Consuming lock");
            Thread.sleep(4000);
            System.out.println("Awakend");
        }
        catch(Exception e)
        {

        }
        finally{
            lock.unlock();
        }
    }

    public void add(ReentrantLock lock)
    {
        lock.lock();
        try{
            System.out.println("Add lock");
            Thread.sleep(4000);
            System.out.println("Awakend 2");
        }
        catch(Exception e)
        {

        }
        finally{
            lock.unlock();
        }
    }
}
