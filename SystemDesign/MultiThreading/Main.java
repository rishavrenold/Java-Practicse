package SystemDesign.MultiThreading;

public class Main {
    public static void main(String[] args) {
        SharedResources ob=new SharedResources();
        Thread thread1 =new Thread(()->{
            ob.add();
        });
        Thread thread2 =new Thread(()->{
            ob.cosume();
        });
        thread2.start();
        thread1.start();
    }
}
