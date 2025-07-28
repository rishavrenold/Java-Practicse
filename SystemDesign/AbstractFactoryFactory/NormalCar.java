package SystemDesign.AbstractFactoryFactory;

public class NormalCar implements AbstractFactory{

    @Override
    public Car getInstance(int value) {
        if(value<=10000)
        {
            return new Maruti();
        }else if(value<=20000)
            {
                return new Tata();
            }
        return null;
    }
    
}
