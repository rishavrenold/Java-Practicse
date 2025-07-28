package SystemDesign.MultiThreading;

public class SharedResources {
    boolean isAvailable=false;

    public synchronized void cosume()
    {
        if(!isAvailable)
        {
            try{
            System.out.println("Consumed");
            wait();
            }catch(Exception e){

            }
        } 
        isAvailable=false; 
    }

    public synchronized void add()
    {
        isAvailable=true;
        notifyAll();
    }
}
