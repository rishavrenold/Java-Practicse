package SystemDesign.AbstractFactoryFactory;

public class Main {
    public static void main(String[] args) {
        AbstractFactoryProducer abstractFactoryProducer=new AbstractFactoryProducer();
        AbstractFactory abstractFactory=abstractFactoryProducer.geAbstractFactory("SpeedCar");
        Car ob= abstractFactory.getInstance(40000);
        System.out.println(ob.getSpeed());
    }
}
