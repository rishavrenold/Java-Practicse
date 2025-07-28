package CreationalDesignPattern.FactoryPattern;

interface Logistics {
    void send();
    
}
class Road implements Logistics{

    @Override
    public void send() {
        System.out.println("Sending by Road");
        
    }
}

class Airplane implements Logistics{

    @Override
    public void send() {
        System.out.println("Sendig By Airplane");
    }
    
}

class LogisticsFactory{

    public static Logistics getLogistics(String mode)
    {
                if(mode.equals("Air"))
                {
                    return new Airplane();
                }
                if(mode.equals("Road"))
                { 
                    return new Road();
                }
                return null;
            }
}

class LogisticsService{

    public void send(String mode)
    {
        Logistics logistics=LogisticsFactory.getLogistics(mode);
        logistics.send();
    }
 
}

public class Factory {
    public static void main(String[] args) {
      LogisticsService ob=new LogisticsService();
       ob.send("Road");
    }
}
