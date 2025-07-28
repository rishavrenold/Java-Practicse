package SystemDesign.AbstractFactoryFactory;

public class AbstractFactoryProducer {
    
    public AbstractFactory geAbstractFactory(String value)
    {
        if(value.equalsIgnoreCase("NormalCar"))
        {
            return new NormalCar();
        }else if(value.equalsIgnoreCase("SpeedCar"))
        {
            return new SpeedCar();
        }
        return null;
    }
}
