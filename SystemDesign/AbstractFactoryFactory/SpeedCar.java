package SystemDesign.AbstractFactoryFactory;

public class SpeedCar implements AbstractFactory{

    @Override
    public Car getInstance(int value) {
        if(value<=30000)
        {
            return new RangeRover();
        }else if(value<=40000)
            {
                return new Ferrari();
            }
        return null;
    }
    
}
